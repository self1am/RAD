import java.util.*;

public class Overdue {
    private Book book;
    private Member member;
    private Date dueDate;
    private int daysOverdue;

    public Overdue(Book book, Member member, Date dueDate, int daysOverdue) {
        this.book = book;
        this.member = member;
        this.dueDate = dueDate;
        this.daysOverdue = daysOverdue;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setDaysOverdue(int daysOverdue) {
        this.daysOverdue = daysOverdue;
    }

    
}
