import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class MovieBookingSystem {
    private final List<String> availableMovies = Arrays.asList("Inception", "Interstellar", "The Matrix");

    public void bookTicket(String movieName) throws MovieNotAvailableException {
        if (movieName == null || movieName.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie name must not be empty.");
        }

        if (!availableMovies.contains(movieName)) {
            throw new MovieNotAvailableException("Sorry, '" + movieName + "' is not available for booking.");
        }

        System.out.println("Ticket booked successfully for: " + movieName);
    }

    public void loadMovieSchedule(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("Movie schedule file not found at: " + filePath);
        }

        System.out.println("Movie schedule loaded successfully.");
    }
}