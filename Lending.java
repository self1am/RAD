import java.util.*;

public class Lending {
    private Book book;
    private Member member;
    private Date borrowDate;
    private Date returnDate;
    private double fineAmount;

    public Lending(Book book, Member member, Date borrowDate, Date returnDate, double fineAmount) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.fineAmount = fineAmount;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    
}
