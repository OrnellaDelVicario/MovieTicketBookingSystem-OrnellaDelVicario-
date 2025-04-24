import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        MovieBookingSystem system = new MovieBookingSystem();

        // 1. Checked Exception
        try {
            system.loadMovieSchedule("movie_schedule.txt"); // File does not exist
        } catch (FileNotFoundException e) {
            System.out.println("Checked Exception: " + e.getMessage() + " → path does not exist.");
        }

        // 2. Custom Exception
        try {
            system.bookTicket("Titanic"); // Movie not listed
        } catch (MovieNotAvailableException e) {
            System.out.println("Custom Exception: The movie is not available – " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Runtime Exception: Invalid movie name – " + e.getMessage());
        }

        // 3. Unchecked Exception
        try {
            system.bookTicket(""); // Null name → IllegalArgumentException
        } catch (MovieNotAvailableException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Runtime Exception: Invalid movie name – " + e.getMessage());
        }

        // Finally
        System.out.println("Thank you for using our movie booking system!");
    }
}
