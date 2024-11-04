import java.util.LinkedList;

class Book {
    private long ISBN_no;
    private String name;
    private int edition;
    private String author;
    private String publisher;
    private String status;

    public Book(long ISBN_no, String name, int edition, String author, String publisher, String status) {
        this.ISBN_no = ISBN_no;
        this.name = name;
        this.edition = edition;
        this.author = author;
        this.publisher = publisher;
        this.status = status;
    }

    public void checkStatus() {
        System.out.println("Status of " + name + ": " + status);
    }

    public void changeStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Status of " + name + " changed to: " + status);
    }

    public void display() {
        System.out.println("ISBN: " + ISBN_no + ", Name: " + name + ", Edition: " + edition +
                ", Author: " + author + ", Publisher: " + publisher + ", Status: " + status);
    }
}

public class BookTester {
    public static void main(String[] args) {
        LinkedList<Book> bookList = new LinkedList<>();

        Book obj1 = new Book(1111, "Harry Potter", 1, "J.K. Rowling", "XYZ Publisher", "Available");
        Book obj2 = new Book(2222, "The Hobbit", 1, "J.R.R. Tolkien", "ABC Publisher", "Checked Out");

        bookList.add(obj1);
        bookList.add(obj2);
        obj1.checkStatus();
        obj1.changeStatus("Checked Out");
        obj1.checkStatus();

        Book obj3 = new Book(3333, "1984", 1, "George Orwell", "DEF Publisher", "Available");
        Book obj4 = new Book(4444, "To Kill a Mockingbird", 1, "Harper Lee", "GHI Publisher", "Available");

        bookList.addFirst(obj3);
        bookList.addLast(obj4);

        System.out.println("\nCurrent Books in the Library:");
        for (Book book : bookList) {
            book.display();
        }
    }
}
