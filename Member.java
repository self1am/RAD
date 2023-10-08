import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    private String name;
    private List<Book> booksBorrowed;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.booksBorrowed = new ArrayList<>();
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }
    
}
