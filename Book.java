
public class Book {
    private int id;
    private String title;
    private String author;
    private int copiesAvailable;

    //constructors
    public Book(int id, String title, String author, int copiesAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void incrementCopiesAvailable() {
        copiesAvailable++;
    }

    public void decrementCopiesAvailable() {
        copiesAvailable--;
    }

}
