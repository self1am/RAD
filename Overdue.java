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

}
