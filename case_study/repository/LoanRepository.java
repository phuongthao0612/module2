package repository;

import entity.Loan;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LoanRepository {
    public List<Loan> getAll() {
        File file = new File("src/csv/loan.csv");
        List<Loan> loans = new LinkedList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                try {
                    int loanId = Integer.parseInt(data[0]);
                    int bookId = Integer.parseInt(data[1]);
                    int memberId = Integer.parseInt(data[2]);
                    String loanDate = data[3];
                    String returnDate = data[4];
                    boolean isReturned = Boolean.parseBoolean(data[5]);
                    Loan loan = new Loan(loanId, bookId, memberId, loanDate, returnDate);
                    loan.setReturned(isReturned);
                    loans.add(loan);
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi khi chuyển đổi dữ liệu từ chuỗi: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file " + "src/csv/loan.csv");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file " + "src/csv/loan.csv");
        }
        return loans;
    }

    private void writeFile(List<Loan> loans, boolean append) {
        File file = new File("src/csv/loan.csv");
        try (FileWriter fileWriter = new FileWriter(file, append);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Loan loan : loans) {
                bufferedWriter.write(loan.getLoanId() + "," +
                        loan.getBookId() + "," +
                        loan.getMemberId() + "," +
                        loan.getLoanDate() + "," +
                        loan.getReturnDate() + "," +
                        loan.isReturned());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu");
        }
    }

    public void add(Loan loan) {
        List<Loan> loans = new ArrayList<>();
        loans.add(loan);
        writeFile(loans, true);
    }

    public void remove(int loanId) {
        List<Loan> loans = getAll();
        loans.removeIf(loan -> loan.getLoanId() == loanId);
        writeFile(loans, false);
    }

    public Loan findById(int loanId) {
        List<Loan> loans = getAll();
        for (Loan loan : loans) {
            if (loan.getLoanId() == loanId) {
                return loan;
            }
        }
        return null;
    }

    public void updateLoan(Loan loan) {
        List<Loan> loans = getAll();
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getLoanId() == loan.getLoanId()) {
                loans.set(i, loan);
                writeFile(loans, false);
                break;
            }
        }
    }
}
