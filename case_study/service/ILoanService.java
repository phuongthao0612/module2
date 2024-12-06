package service;

import entity.Loan;

public interface ILoanService extends IService<Loan> {
    void updateLoan(Loan loan);

}
