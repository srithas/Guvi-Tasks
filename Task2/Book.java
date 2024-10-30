// Question 1.
// Purpose: Create a Book and Library Management System, where users can search add remove books

class Book{
    int bookID;
    String title;
    String author;
    boolean isAvailable;
    
    public Book(int bookID, String title, String author){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Initialize getter methods
    public int getBookID(){
        return bookID;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    // Display Book Details
    public void displayBook(){
        System.out.println("Book ID: " + bookID + " | Title: " + title + " | Author: " + author + " - Available: " + isAvailable);
    }
}
