public class TestBookApplication {
    public static void main(String[] args) {
        System.out.println("~~~ Running Test Cases ~~~");


        PrintedBook pb1 = new PrintedBook("Sorcerer's Stone", "J.K. Rowling", "Sci-Fi", 500, 29.99);
        PrintedBook pb2 = new PrintedBook("The Hobbit", "R. Tolkien", "Drama", 700, 24.99);


        AudioBook ab1 = new AudioBook("Pride and Prejudice", "Jane Austen", "Romance", 600, 19.99);
        AudioBook ab2 = new AudioBook("Better than the Movies", "Lynn Painter", "Romance", 618, 15.99);


        System.out.println("Printed book cost: " + pb1.calculateCost());
        System.out.println("Audio book cost: " + ab1.calculateCost());


        System.out.println("Average Pages: " + PrintedBook.getAveragePages());
        System.out.println("Average Length: " + AudioBook.getAverageLength());


        Book sampleBook = Book.getAllBooks().get(0);
        System.out.println("Romance books: " + sampleBook.getNumBooksPerGenre("Romance"));
        System.out.println("Drama books: " + sampleBook.getNumBooksPerGenre("Drama"));


        System.out.println("Total Cost: $" + sampleBook.getTotalCost());


        System.out.println(PrintedBook.displayLastThreePrinted());
        System.out.println(AudioBook.displayLastThreeAudio());

        System.out.println("Tests completed successfully.");
    }
}
