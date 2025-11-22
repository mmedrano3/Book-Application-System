import java.util.ArrayList;
import java.util.List;

public class PrintedBook extends Book {
    private int pages;
    private static List<PrintedBook> printedBooks = new ArrayList<>();

    public PrintedBook(String title, String author, String genre, int pages, double cost) {
        super(title, author, genre, cost);
        this.pages = pages;
        printedBooks.add(this);
        Book.addBook(this);

        if (printedBooks.size() > 3) {
            printedBooks.remove(0);
        }
    }


    @Override
    public void storeBookInfo(String title, String author, String genre, double cost) {

        System.out.println("Stored Printed Book: " + title);
    }


    public int getPages() { return pages; }
    public void setPages(int pages) {
        this.pages = pages;
        this.cost = pages * 10.0;
    }


    public static double getAveragePages() {
        if (printedBooks.isEmpty()) return 0;
        int total = 0;
        for (PrintedBook book : printedBooks) {
            total += book.pages;
        }
        return (double) total / printedBooks.size();
    }


    @Override
    public double calculateCost() {
        return cost;
    }


    public static String displayLastThreePrinted() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n~~~ Last 3 Printed Books ~~~\n");
        for (int i = 0; i < printedBooks.size(); i++) {
            PrintedBook book = printedBooks.get(i);
            sb.append(String.format("%d. %s, Pages: %d, Cost: $%.2f\n",
                    i + 1, book.getTitle(), book.getPages(), book.getCost()));
        }
        return sb.toString();
    }

    public static List<PrintedBook> getPrintedBooks() {
        return new ArrayList<>(printedBooks);
    }

    @Override
    public String toString() {
        return String.format("PrintedBook[Title: %s, Author: %s, Genre: %s, Pages: %d, Cost: $%.2f]",
                title, author, genre, pages, cost);
    }
}