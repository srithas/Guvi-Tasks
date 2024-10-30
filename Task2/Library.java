// Question 1.
// Purpose: Create a Book and Library Management System, where users can search add remove books

import java.util.Scanner;

class Library {
    Book[] books;   
    int bookCount;  

    // Initoa;ization Constructor
    public Library() {
        books = new Book[5];
        bookCount = 0;
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.println("Book Added");
        } else {
            System.out.println("Cannot add more books");
        }
    }

    // Method to remove a book
    public void removeBook(int bookID) {
        boolean found = false;
        
        // For loop to iterate through array of books
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookID() == bookID) {
                // Move the remaining books
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }

                // Need to decrease the book count
                books[--bookCount] = null;  
                System.out.println("Book Removed");
                found = true;
                break;
            }
        }

        // If book id is incorrect or not in system, display error message
        if (!found) {
            System.out.println("Book with ID " + bookID + " not found.");
        }
    }

    // Method to search for a book 
    public void searchBook(int bookID) {
        // For loop to iterate through array until Book ID matches
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookID() == bookID) {
                books[i].displayBook();
                return;
            }
        }
        // If book id is incorrect or not in system, display error message
        System.out.println("Book with ID " + bookID + " not found.");
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the library.");
        } else {

            // For loop to iterate through array and display
            for (int i = 0; i < bookCount; i++) {
                books[i].displayBook();
            }
        }
    }

    // User Library System Interaction
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int select;

        // Menu for user to select
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Display All Books");
            System.out.print("Enter Selection: ");
            select = scanner.nextInt();

            // Create switch statements based on each case corresponding to user selection
            switch (select) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();  

                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();

                    Book newBook = new Book(bookID, title, author);
                    library.addBook(newBook);
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeID = scanner.nextInt();
                    library.removeBook(removeID);
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchID = scanner.nextInt();
                    library.searchBook(searchID);
                    break;

                case 4:
                    library.displayBooks();
                    break;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (select != 5);
    }
}
