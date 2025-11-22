import java.util.*;

public class BookApplication {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        FileHandler.readBooksFromFile();

        System.out.println("~~~ Welcome to Book Application System ~~~");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addPrintedBook();
                    break;
                case 2:
                    addAudioBook();
                    break;
                case 3:
                    displayAllBooks();
                    break;
                case 4:
                    displayLastSixBooks();
                    break;
                case 5:
                    displayGenreCounts();
                    break;
                case 6:
                    displayCostInformation();
                    break;
                case 7:
                    displayAverages();
                    break;
                case 8:
                    saveBooksToFile();
                    break;
                case 9:
                    running = false;
                    System.out.println("Thank you for using Book Application System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n~~~ Main Menu ~~~");
        System.out.println("1. Add Printed Book");
        System.out.println("2. Add Audio Book");
        System.out.println("3. Display All Books");
        System.out.println("4. Display Last 6 Books");
        System.out.println("5. Display Books by Genre");
        System.out.println("6. Display Cost Information");
        System.out.println("7. Display Averages");
        System.out.println("8. Save Books to File");
        System.out.println("9. Exit");
    }

    private static void addPrintedBook() {
        System.out.println("\n~~~ Add Printed Book ~~~");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        int pages = getIntInput("Enter number of pages: ");
        double cost = getDoubleInput("Enter book cost: $");

        try {
            PrintedBook book = new PrintedBook(title, author, genre, pages, cost);
            System.out.println("Printed book added successfully!");
            System.out.println("Stored cost: $" + book.getCost());
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    private static void addAudioBook() {
        System.out.println("\n~~~ Add Audio Book ~~~");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        double length = getDoubleInput("Enter length in minutes: ");
        double cost = getDoubleInput("Enter book cost: $");

        try {
            AudioBook book = new AudioBook(title, author, genre, length, cost);
            System.out.println("Audio book added successfully!");
            System.out.println("Stored cost: $" + book.getCost());
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    private static void displayAllBooks() {
        List<Book> allBooks = Book.getAllBooks();
        if (allBooks.isEmpty()) {
            System.out.println("No books in the system.");
            return;
        }

        System.out.println("\n~~~ All Books ~~~");
        for (int i = 0; i < allBooks.size(); i++) {
            System.out.println((i + 1) + ". " + allBooks.get(i));
        }


        System.out.println(PrintedBook.displayLastThreePrinted());
        System.out.println(AudioBook.displayLastThreeAudio());
    }

    private static void displayLastSixBooks() {
        List<Book> allBooks = Book.getAllBooks();
        if (allBooks.isEmpty()) {
            System.out.println("No books in the system.");
            return;
        }


        Book sampleBook = allBooks.get(0);
        sampleBook.displayLastSixBooks(allBooks);
    }

    private static void displayGenreCounts() {
        List<Book> allBooks = Book.getAllBooks();
        if (allBooks.isEmpty()) {
            System.out.println("No books in the system.");
            return;
        }


        Set<String> genres = new HashSet<>();
        for (Book book : allBooks) {
            genres.add(book.getGenre());
        }

        System.out.println("\n~~~ Books per Genre ~~~");
        Book sampleBook = allBooks.get(0);
        for (String genre : genres) {
            int count = sampleBook.getNumBooksPerGenre(genre);
            System.out.println(genre + ": " + count + " books");
        }
    }

    private static void displayCostInformation() {
        List<Book> allBooks = Book.getAllBooks();
        if (allBooks.isEmpty()) {
            System.out.println("No books in the system.");
            return;
        }

        Book sampleBook = allBooks.get(0);
        double totalCost = sampleBook.getTotalCost();

        System.out.println("\n~~~ Cost Information ~~~");
        System.out.printf("Total cost of all books: $%.2f%n", totalCost);


        for (int i = 0; i < allBooks.size(); i++) {
            Book book = allBooks.get(i);
            System.out.printf("%d. %s: $%.2f%n", i + 1, book.getTitle(), book.getCost());
        }
    }

    private static void displayAverages() {
        System.out.println("\n~~~ Average Information ~~~");
        System.out.printf("Average pages per printed book: %.2f%n", PrintedBook.getAveragePages());
        System.out.printf("Average length per audio book: %.2f minutes%n", AudioBook.getAverageLength());
    }

    private static void saveBooksToFile() {
        List<Book> allBooks = Book.getAllBooks();
        if (allBooks.isEmpty()) {
            System.out.println("No books to save.");
            return;
        }

        FileHandler.writeBooksToFile(allBooks);
    }


    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}