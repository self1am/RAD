/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author hanafemira
 */
public class RAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Library librarySystem = new Library();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Member");
            System.out.println("4. Remove Member");
            System.out.println("5. Search Book Information");
            System.out.println("6. Search Member Information");
            System.out.println("7. Display Book Names");
            System.out.println("8. Display Member Names");
            System.out.println("9. Lend Book");
            System.out.println("10. Return Book");
            System.out.println("11. View Lending Information");
            System.out.println("12. Display Overdue Books");
            System.out.println("13. Quit");

            System.out.print("Enter your choice: ");
            String choice = scanner.next();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case "1":
                    // Add Book
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Copies Available: ");
                    int copiesAvailable = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    Book book = new Book(bookId, title, author, copiesAvailable);
                    librarySystem.addBook(book);
                    break;

                case "2":
                    // Remove Book
                    System.out.print("Enter Title of Book to Remove: ");
                    String bookTitleToRemove = scanner.nextLine();
                    Book bookToRemove = librarySystem.searchBookInformation(bookTitleToRemove);
                    if (bookToRemove != null) {
                        librarySystem.removeBook(bookToRemove);
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case "3":
                    // Register Member
                    System.out.print("Enter Member ID: ");
                    int memberId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Member Name: ");
                    String memberName = scanner.nextLine();
                    Member member = new Member(memberId, memberName);
                    librarySystem.registerMember(member);
                    break;

                case "4":
                    // Remove Member
                    System.out.print("Enter Member ID to Remove: ");
                    int memberToRemoveId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    Member memberToRemove = librarySystem.searchMemberInformation(memberToRemoveId);
                    if (memberToRemove != null) {
                        librarySystem.removeMember(memberToRemove);
                        System.out.println("Member removed successfully.");
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case "5":
                    // Search Book Information
                    System.out.print("Enter Title to Search: ");
                    String searchTitle = scanner.nextLine();
                    Book searchedBook = librarySystem.searchBookInformation(searchTitle);
                    if (searchedBook != null) {
                        System.out.println("Book Found:");
                        System.out.println("Title: " + searchedBook.getTitle());
                        System.out.println("Author: " + searchedBook.getAuthor());
                        System.out.println("Copies Available: " + searchedBook.getCopiesAvailable());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case "6":
                    // Search Member Information
                    System.out.print("Enter Member ID to Search: ");
                    int searchMemberId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    Member searchedMember = librarySystem.searchMemberInformation(searchMemberId);
                    if (searchedMember != null) {
                        System.out.println("Member Found:");
                        System.out.println("Name: " + searchedMember.getName());
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case "7":
                    // Display Book Names
                    System.out.println("Book Names:");
                    librarySystem.displayBookNames();
                    break;

                case "8":
                    // Display Member Names
                    System.out.println("Member Names:");
                    librarySystem.displayMemberNames();
                    break;

                case "9":
                    // Lend Book
                    System.out.print("Enter the Book Title: ");
                    String searchBookTitle = scanner.nextLine();
                    Book selBook = librarySystem.searchBookInformation(searchBookTitle);
                    System.out.print("Enter the Member ID: ");
                    int searchMemID = scanner.nextInt();
                    Member selMember = librarySystem.searchMemberInformation(searchMemID);

                    librarySystem.lendBook(selBook, selMember);

                    break;

                case "10":
                    // Return Book
                    System.out.print("Enter the Book Title: ");
                    String searchBookTitle = scanner.nextLine();
                    Book selBook = librarySystem.searchBookInformation(searchBookTitle);
                    System.out.print("Enter the Member ID: ");
                    int searchMemID = scanner.nextInt();
                    Member selMember = librarySystem.searchMemberInformation(searchMemID);

                    librarySystem.returnBook(selBook, selMember);
                    break;

                case "11":
                    // View Lending Information
                    List<Lending> lendingInfoList = librarySystem.viewLendingInformation();
                    System.out.println("Lending Information:");
                    for (Lending lendingInfo : lendingInfoList) {
                        System.out.println("Book Title: " + lendingInfo.getBook().getTitle());
                        System.out.println("Member Name: " + lendingInfo.getMember().getName());
                        System.out.println("Borrow Date: " + dateFormat.format(lendingInfo.getBorrowDate()));
                        System.out.println("Return Date: " + dateFormat.format(lendingInfo.getReturnDate()));
                        System.out.println("Fine Amount: " + lendingInfo.getFineAmount());
                        System.out.println();
                    }
                    break;

                case "12":
                    // Display Overdue Books
                    librarySystem.displayOverdueBooks();
                    break;

                case "13":
                    // Quit the program
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
    
}
