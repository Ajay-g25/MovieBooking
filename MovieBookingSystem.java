import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieBookingSystem {
    public static void main(String[] args) {
        
        Movie movie1 = new Movie("Inception", 148);
        Movie movie2 = new Movie("Avatar", 162);
        Movie movie3 = new Movie("The Dark Knight", 152);

        Theater theater1 = new Theater("Grand Cinema");
        Theater theater2 = new Theater("Galaxy Multiplex");

        theater1.addScreen(new Screen("Screen 1", movie1, 10, 5));
        theater1.addScreen(new Screen("Screen 2", movie2, 25, 4));
        theater2.addScreen(new Screen("Screen 1", movie3, 20, 6));

        List<Theater> theaters = new ArrayList<>();
        theaters.add(theater1);
        theaters.add(theater2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAvailable Theaters:");
            for (int i = 0; i < theaters.size(); i++) {
                System.out.println((i + 1) + ". " + theaters.get(i).getName());
            }
            System.out.print("\n");
            System.out.print("Choose a theater (or 0 to exit): ");
            int theaterChoice = scanner.nextInt();
            if (theaterChoice == 0) break;
            if (theaterChoice < 1 || theaterChoice > theaters.size()) {
                System.out.println("Invalid choice!");
                continue;
            }
            Theater chosenTheater = theaters.get(theaterChoice - 1);

            System.out.print("\n");
            System.out.println("\nAvailable Screens in " + chosenTheater.getName() + ":");
            List<Screen> screens = chosenTheater.getScreens();
            for (int i = 0; i < screens.size(); i++) {
                System.out.println((i + 1) + ". " + screens.get(i).getScreenName() + " (Movie: " + screens.get(i).getMovie().getTitle() + ")");
            }
            System.out.print("\n");
            System.out.print("Choose a screen (or 0 to go back): ");
            int screenChoice = scanner.nextInt();
            if (screenChoice == 0) continue;
            if (screenChoice < 1 || screenChoice > screens.size()) {
                System.out.println("Invalid choice!");
                continue;
            }
            Screen chosenScreen = screens.get(screenChoice - 1);

            while (true) {
                chosenScreen.displaySeatMatrix();
                System.out.print("\n");
                System.out.print("Enter seat number to book, 0 to go back, or -1 to cancel booking: ");
                int seatNumber = scanner.nextInt();

                if (seatNumber == -1) {
                    System.out.print("Enter the seat number to cancel booking: ");
                    int cancelSeatNumber = scanner.nextInt();
                    chosenScreen.cancelBooking(cancelSeatNumber);
                } else if (seatNumber == 0) {
                    break;
                } else {
                    chosenScreen.bookSeat(seatNumber);
                }
            }
        }

        scanner.close();
        System.out.println("\nThank you for choosing us!");
    }
}
