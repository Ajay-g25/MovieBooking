import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String screenName;
    private Movie movie;
    private List<Seat> seats;
    private int rows;
    private int columns;

    public Screen(String screenName, Movie movie, int rows, int columns) {
        this.screenName = screenName;
        this.movie = movie;
        this.rows = rows;
        this.columns = columns;
        this.seats = new ArrayList<>();

        for (int i = 1; i <= rows * columns; i++) {
            seats.add(new Seat(i));
        }
    }

    public String getScreenName() {
        return screenName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void displaySeatMatrix() {
        System.out.println("Seat Matrix for Screen: " + screenName + " (Movie: " + movie.getTitle() + ")");
        System.out.print("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Seat seat = seats.get(i * columns + j);
                System.out.print(seat.isBooked() ? "[X] " : "[O] ");
            }
            System.out.println();
        }
    }

    public boolean bookSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.size()) {
            System.out.print("\n");
            System.out.println("Invalid seat number!");
            return false;
        }
        Seat seat = seats.get(seatNumber - 1);
        if (seat.isBooked()) {
            System.out.print("\n");
            System.out.println("Seat already booked!");
            return false;
        }
        seat.setBooked(true);
        System.out.println("Seat " + seatNumber + " booked successfully.");
        System.out.print("\n");
        return true;
    }

    public boolean cancelBooking(int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.size()) {
            System.out.print("\n");
            System.out.println("Invalid seat number!");
            return false;
        }
        Seat seat = seats.get(seatNumber - 1);
        if (!seat.isBooked()) {
            System.out.print("\n");
            System.out.println("Seat is not booked yet!");
            return false;
        }
        seat.setBooked(false);
        System.out.println("Seat " + seatNumber + " booking canceled successfully.");
        System.out.print("\n");
        return true;
    }
}
