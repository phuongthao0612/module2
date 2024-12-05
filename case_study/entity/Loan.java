package entity;

import java.util.Date;

public class Loan {
    private int loanId;
    private int bookId;
    private int memberId;
    private Date loanDate;
    private Date returnDate;
    private boolean isReturned;

    public Loan(int loanId, int bookId, int memberId, Date loanDate, Date returnDate, boolean isReturned) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    @Override
    public String toString() {
        return "Loan [loanId=" + loanId + ", bookId=" + bookId + ", memberId=" + memberId
                + ", loanDate=" + loanDate + ", returnDate=" + returnDate + ", isReturned="
                + isReturned + "]";
    }
}
