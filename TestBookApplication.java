public class TestBookApplication {
    public static void main(String[] args) {
        System.out.println("~~~ Running Test Cases ~~~");


        PrintedBook pb1 = new PrintedBook("Java Programming", "John Doe", "Education", 300, 29.99);
        PrintedBook pb2 = new PrintedBook("Python Basics", "Jane Smith", "Education", 250, 24.99);


        AudioBook ab1 = new AudioBook("Mystery Novel", "Author X", "Mystery", 480, 19.99);
        AudioBook ab2 = new AudioBook("Sci-Fi Adventure", "Author Y", "Sci-Fi", 360, 15.99);


        System.out.println("Printed book cost: " + pb1.calculateCost());
        System.out.println("Audio book cost: " + ab1.calculateCost());


        System.out.println("Average Pages: " + PrintedBook.getAveragePages());
        System.out.println("Average Length: " + AudioBook.getAverageLength());


        Book sampleBook = Book.getAllBooks().get(0);
        System.out.println("Education books: " + sampleBook.getNumBooksPerGenre("Education"));
        System.out.println("Mystery books: " + sampleBook.getNumBooksPerGenre("Mystery"));


        System.out.println("Total Cost: $" + sampleBook.getTotalCost());


        System.out.println(PrintedBook.displayLastThreePrinted());
        System.out.println(AudioBook.displayLastThreeAudio());

        System.out.println("All tests completed successfully!");
    }
}