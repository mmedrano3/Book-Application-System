 import java.util.List;

    public interface BookInterface {

        default void displayLastSixBooks(List<Book> allBooks) {
            System.out.println("\n~~~ Last 6 Books ~~~");
            int start = Math.max(0, allBooks.size() - 6);
            for (int i = start; i < allBooks.size(); i++) {
                System.out.println((i - start + 1) + ". " + allBooks.get(i));
            }
        }


        int getNumBooksPerGenre(String genre);


        double getTotalCost();
    }

