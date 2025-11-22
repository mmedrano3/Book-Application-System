import java.io.*;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "books.txt";


    public static void writeBooksToFile(List<Book> books) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                if (book instanceof PrintedBook) {
                    PrintedBook pb = (PrintedBook) book;
                    writer.printf("PRINTED|%s|%s|%s|%d|%.2f%n",
                            pb.getTitle(), pb.getAuthor(), pb.getGenre(),
                            pb.getPages(), pb.getCost());
                } else if (book instanceof AudioBook) {
                    AudioBook ab = (AudioBook) book;
                    writer.printf("AUDIO|%s|%s|%s|%.2f|%.2f%n",
                            ab.getTitle(), ab.getAuthor(), ab.getGenre(),
                            ab.getLength(), ab.getCost());
                }
            }
            System.out.println("Books successfully saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }


    public static void readBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 6) {
                    String type = parts[0];
                    String title = parts[1];
                    String author = parts[2];
                    String genre = parts[3];
                    double cost = Double.parseDouble(parts[5]);

                    if (type.equals("PRINTED")) {
                        int pages = Integer.parseInt(parts[4]);
                        new PrintedBook(title, author, genre, pages, cost);
                    } else if (type.equals("AUDIO")) {
                        double length = Double.parseDouble(parts[4]);
                        new AudioBook(title, author, genre, length, cost);
                    }
                }
            }
            System.out.println("Books successfully loaded from " + FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("No existing book file found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from file: " + e.getMessage());
        }
    }
}