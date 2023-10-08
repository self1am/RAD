import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private List<Lending> lendingInfoList;
    private List<Overdue> overdueBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.lendingInfoList = new ArrayList<>();
        this.overdueBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void registerMember(Member member) {
        members.add(member);
    }

    public void removeMember(Member member) {
        members.remove(member);
    }

    public Book searchBookInformation(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    public Member searchMemberInformation(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null; // Member not found
    }

    public void displayBookNames() {
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

    public void displayMemberNames() {
        for (Member member : members) {
            System.out.println(member.getName());
        }
    }

    public void lendBook(Book book, Member member) {
        if (book.getCopiesAvailable() > 0) {
            // Decrease the available copies of the book
            book.decrementCopiesAvailable();

            // Get the current date for borrowDate
            Date borrowDate = new Date();

            // Calculate the return date (e.g., 14 days from the borrow date)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(borrowDate);
            calendar.add(Calendar.DAY_OF_YEAR, 14); // 14 days
            Date returnDate = calendar.getTime();

            // Create a new lending information entry
            Lending lendingInfo = new Lending(book, member, borrowDate, returnDate, 0.0);
            lendingInfoList.add(lendingInfo);

            System.out.println("Book lent successfully.");
        } else {
            System.out.println("Sorry, no copies of this book are available.");
        }
    }

    public void returnBook(Book book, Member member) {
        Lending foundLendingInfo = null;
        for (Lending lendingInfo : lendingInfoList) {
            if (lendingInfo.getBook().equals(book) && lendingInfo.getMember().equals(member)) {
                foundLendingInfo = lendingInfo;
                break;
            }
        }

        if (foundLendingInfo != null) {
            // Calculate the fine amount (if any) based on the return date
            Date returnDate = new Date();
            long diffInMillis = returnDate.getTime() - foundLendingInfo.getReturnDate().getTime();
            int daysOverdue = (int) (diffInMillis / (24 * 60 * 60 * 1000)); // Convert milliseconds to days

            double fineAmount = 0.0;
            if (daysOverdue > 0) {
                // Implement fine calculation logic here
                // For example, Rs. 50 per additional day for up to 7 days, Rs. 100 per additional day after 7 days
                if (daysOverdue <= 7) {
                    fineAmount = daysOverdue * 50.0;
                } else {
                    fineAmount = 7 * 50.0 + (daysOverdue - 7) * 100.0;
                }
            }

            // Update the fine amount in the lending information
            foundLendingInfo.setFineAmount(fineAmount);

            // Increase the available copies of the book
            book.incrementCopiesAvailable();

            System.out.println("Book returned successfully.");
        } else {
            System.out.println("No record of this book being borrowed by the member.");
        }
    }

    public List<Overdue> displayOverdueBooks() {
        // Clear the previous list of overdue books
        overdueBooks.clear();
    
        // Get the current date
        Date currentDate = new Date();
    
        // Iterate through lending information to find overdue books
        for (Lending lendingInfo : lendingInfoList) {
            if (lendingInfo.getReturnDate().before(currentDate)) {
                // Calculate the number of days overdue
                long diffInMillis = currentDate.getTime() - lendingInfo.getReturnDate().getTime();
                int daysOverdue = (int) (diffInMillis / (24 * 60 * 60 * 1000)); // Convert milliseconds to days
    
                // Create an overdue book entry
                Overdue overdueBook = new Overdue(
                        lendingInfo.getBook(),
                        lendingInfo.getMember(),
                        lendingInfo.getReturnDate(),
                        daysOverdue
                );
    
                // Add the overdue book to the list
                overdueBooks.add(overdueBook);
            }
        }
    
        // Display the list of overdue books
        if (overdueBooks.isEmpty()) {
            System.out.println("No books are currently overdue.");
        } else {
            System.out.println("Overdue Books:");
            for (Overdue overdueBook : overdueBooks) {
                System.out.println("Book Title: " + overdueBook.getBook().getTitle());
                System.out.println("Member Name: " + overdueBook.getMember().getName());
                System.out.println("Due Date: " + overdueBook.getDueDate());
                System.out.println("Days Overdue: " + overdueBook.getDaysOverdue());
                System.out.println();
            }
        }
    
        return overdueBooks;
    }
    

    public List<Lending> viewLendingInformation() {
        return lendingInfoList;
    }

}
