import java.util.ArrayList;
import java.util.List;

public abstract class Book implements BookInterface {
    protected String title;
    protected String author;
    protected String genre;
    protected double cost;
    protected static List<Book> allBooks = new ArrayList<>();


    public Book(String title, String author, String genre, double cost) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.cost = cost;
        storeBookInfo(title, author, genre, cost);
    }


    public abstract void storeBookInfo(String title, String author, String genre, double cost);


    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public double getCost() { return cost; }


    public abstract double calculateCost();


    @Override
    public double getTotalCost() {
        double total = 0;
        for (Book book : allBooks) {
            total += book.getCost();
        }
        return total;
    }


    @Override
    public int getNumBooksPerGenre(String genre) {
        int count = 0;
        for (Book book : allBooks) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                count++;
            }
        }
        return count;
    }


    public static List<Book> getAllBooks() {
        return new ArrayList<>(allBooks);
    }

    public static void addBook(Book book) {
        allBooks.add(book);
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, Genre: %s, Cost: $%.2f",
                title, author, genre, cost);
    }
}