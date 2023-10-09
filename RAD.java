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
        try (Scanner scanner = new Scanner(System.in)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            System.out.println(" ___       __      __");
            System.out.println("|   \\     /  \\    |   \\");
            System.out.println("| | /    / __ \\   |   ||");
            System.out.println("| \\ \\   /_/  \\_\\  |___//");

            System.out.println("Rapid Application Development Group Assignment\n");
            System.out.println("          Members:");
            System.out.println("   21020639 A.M. Hanafe Mira");
            System.out.println("   21020515 M.L.F. Shamah");
            System.out.println("   21021058 Kumudu Wickramasinghe");
            System.out.println("   21020582 Dewmini Lochana");


            while (true) {
                System.out.println("\nLibrary Management System Menu:");
                System.out.println("\n--*--*--*--*--*--*--*--*--\n");
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
                System.out.println("\n--*--*--*--*--*--*--*--*--\n\n");

                System.out.print("Enter your choice: ");
                String choice = scanner.next();
                scanner.nextLine(); // Consume the newline

                switch (choice) {
                    case "1":
                        try {
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
                        } catch (Exception e) {
                            System.out.println("An error occurred while adding a book: " + e.getMessage());
                        }
                        break;

                    case "2":
                        try {
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
                        } catch (Exception e) {
                            System.out.println("An error occurred while removing a book: " + e.getMessage());
                        }
                        break;

                    case "3":
                        try {
                            // Register Member
                            System.out.print("Enter Member ID: ");
                            int memberId = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline
                            System.out.print("Enter Member Name: ");
                            String memberName = scanner.nextLine();
                            Member member = new Member(memberId, memberName);
                            librarySystem.registerMember(member);
                        } catch (Exception e) {
                            System.out.println("An error occurred while registering a member: " + e.getMessage());
                        }
                        break;

                    case "4":
                        try {
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
                        } catch (Exception e) {
                            System.out.println("An error occurred while removing a member: " + e.getMessage());
                        }
                        break;

                    case "5":
                        try {
                            // Search Book Information
                            System.out.print("Enter Title to Search: ");
                            String searchTitle = scanner.nextLine();
                            Book searchedBook = librarySystem.searchBookInformation(searchTitle);
                            if (searchedBook != null) {
                                System.out.println("Book Found:");
                                System.out.println("\t------------");
                                System.out.println("\tTitle: " + searchedBook.getTitle());
                                System.out.println("\tAuthor: " + searchedBook.getAuthor());
                                System.out.println("\tCopies Available: " + searchedBook.getCopiesAvailable());
                                System.out.println("\t------------");

                            } else {
                                System.out.println("Book not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("An error occurred while searching the book: " + e.getMessage());
                        }
                        break;

                    case "6":
                        try {
                            // Search Member Information
                            System.out.print("Enter Member ID to Search: ");
                            int searchMemberId = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline
                            Member searchedMember = librarySystem.searchMemberInformation(searchMemberId);
                            if (searchedMember != null) {
                                System.out.println("Member Found:");
                                System.out.println("\t------------");
                                System.out.println("\tName: " + searchedMember.getName());
                                System.out.println("\tMember Id: " + searchMemberId);
                                System.out.println("\t------------");
                            } else {
                                System.out.println("Member not found.");
                            }
                        } catch (Exception e) {
                            System.out.println("An error occurred while searching the member: " + e.getMessage());
                        }
                        break;

                    case "7":
                        try {
                            // Display Book Names
                            System.out.println("Book Names:");
                            librarySystem.displayBookNames();
                        } catch (Exception e) {
                            System.out.println("An error occurred while displaying books: " + e.getMessage());
                        }
                        break;

                    case "8":
                        try {
                            // Display Member Names
                            System.out.println("Member Names:");
                            librarySystem.displayMemberNames();
                        } catch (Exception e) {
                            System.out.println("An error occurred while displaying members: " + e.getMessage());
                        }
                        break;

                        case "9":
                        try {
                            // Lend Book
                            System.out.print("Enter the Book Title: ");
                            String lendBookTitle = scanner.nextLine(); 
                            Book lendSelBook = librarySystem.searchBookInformation(lendBookTitle); 
                            System.out.print("Enter the Member ID: ");
                            int lendMemID = scanner.nextInt(); 
                            Member lendSelMember = librarySystem.searchMemberInformation(lendMemID); 
                        
                            librarySystem.lendBook(lendSelBook, lendSelMember); 
                        } catch (Exception e) {
                            System.out.println("An error occurred while lending the book: " + e.getMessage());
                        }
                    
                        break;
                    
                    case "10":
                        try {
                            // Return Book
                            System.out.print("Enter the Book Title: ");
                            String returnBookTitle = scanner.nextLine(); 
                            Book returnSelBook = librarySystem.searchBookInformation(returnBookTitle); 
                            System.out.print("Enter the Member ID: ");
                            int returnMemID = scanner.nextInt(); 
                            Member returnSelMember = librarySystem.searchMemberInformation(returnMemID); 
                        
                            librarySystem.returnBook(returnSelBook, returnSelMember); 
                        } catch (Exception e) {
                            System.out.println("An error occurred while returning the book: " + e.getMessage()+" Please try again...");
                        }
                        break;
                    

                    case "11":
                        try {
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
                        } catch (Exception e) {
                            System.out.println("An error occurred while displaying the lending information " + e.getMessage());
                        }
                        break;

                    case "12":
                        try {
                            // Display Overdue Books
                            librarySystem.displayOverdueBooks();
                        } catch (Exception e) {
                            System.out.println("An error occurred while displaying the overdue books : " + e.getMessage());
                        }
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
    
}
