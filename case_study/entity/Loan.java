package entity;

public class Loan {
    private int loanId;
    private int bookId;
    private int memberId;
    private String loanDate;
    private String returnDate;
    private boolean isReturned;

    public Loan(int loanId, int bookId, int memberId, String loanDate, String returnDate) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.isReturned = false;
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

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
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
                + ", loanDate=" + loanDate + ", returnDate=" + returnDate + ", isReturned=" + isReturned + "]";
    }
}
