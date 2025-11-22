import java.util.ArrayList;
import java.util.List;

public class AudioBook extends Book {
    private double length;
    private static List<AudioBook> audioBooks = new ArrayList<>();

    public AudioBook(String title, String author, String genre, double length, double cost) {
        super(title, author, genre, cost);
        this.length = length;
        audioBooks.add(this);
        Book.addBook(this);

        if (audioBooks.size() > 3) {
            audioBooks.remove(0);
        }
    }

    @Override
    public void storeBookInfo(String title, String author, String genre, double cost) {

        System.out.println("Stored Audio Book: " + title);
    }


    public double getLength() { return length; }
    public void setLength(double length) {
        this.length = length;
        this.cost = length * 5.0;
    }


    public static double getAverageLength() {
        if (audioBooks.isEmpty()) return 0;
        double total = 0;
        for (AudioBook book : audioBooks) {
            total += book.length;
        }
        return total / audioBooks.size();
    }


    @Override
    public double calculateCost() {
        return cost;
    }


    public static String displayLastThreeAudio() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n~~~ Last 3 Audio Books ~~~\n");
        for (int i = 0; i < audioBooks.size(); i++) {
            AudioBook book = audioBooks.get(i);
            sb.append(String.format("%d. %s, Length: %.2f min, Cost: $%.2f\n",
                    i + 1, book.getTitle(), book.getLength(), book.getCost()));
        }
        return sb.toString();
    }

    public static List<AudioBook> getAudioBooks() {
        return new ArrayList<>(audioBooks);
    }

    @Override
    public String toString() {
        return String.format("AudioBook[Title: %s, Author: %s, Genre: %s, Length: %.2f min, Cost: $%.2f]",
                title, author, genre, length, cost);
    }
}