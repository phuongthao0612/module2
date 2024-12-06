package controller;

import entity.Loan;
import service.ILoanService;
import service.impl.LoanService;

import java.util.List;

public class LoanController {
    private ILoanService loanService = new LoanService();

    public void add(Loan loan) {
        loanService.add(loan);
    }

    public Loan findById(int loanId) {
        return loanService.findById(loanId);
    }

    public void remove(int loanId) {
        Loan loanToRemove = findById(loanId);
        if (loanToRemove != null) {
            loanService.remove(loanId);
        } else {
            System.out.println("Không tìm thấy phiếu mượn với ID: " + loanId);
        }
    }

    public List<Loan> getAll() {
        return loanService.getAll();
    }

    public void updateLoan(Loan loan) {
        loanService.updateLoan(loan);
    }
}
