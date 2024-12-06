package service.impl;

import entity.Loan;
import repository.LoanRepository;
import service.ILoanService;

import java.util.List;

public class LoanService implements ILoanService {
    private LoanRepository loanRepository = new LoanRepository();

    @Override
    public void add(Loan loan) {
        loanRepository.add(loan);

    }

    @Override
    public void remove(int loanId) {
        loanRepository.remove(loanId);

    }


    @Override
    public Loan findById(int loanId) {
        return loanRepository.findById(loanId);
    }

    @Override
    public List<Loan> getAll() {
        return loanRepository.getAll();
    }


    @Override
    public void updateLoan(Loan loan) {
        loanRepository.updateLoan(loan);


    }
}
