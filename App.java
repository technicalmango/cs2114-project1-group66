
import java.util.Scanner;

public class App {

    private boolean isRunning = true;
    private Calendar calendar = new Calendar();
    private Scanner scanner = new Scanner(System.in);

    public void run() {

        while (isRunning) {

            System.out.println();
            System.out.println("Add your event here or type 'exit' to quit:");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                isRunning = false;
                System.out.println("Goodbye!");
                continue;
            }

            // Get event name
            System.out.println("Enter event name:");
            String name = scanner.nextLine();

            // Get and validate event date
            System.out.println("Enter event date (YYYY-MM-DD):");
            String date = scanner.nextLine();

            if (!DateValidator.isValidDate(date)) {
                System.out.println(
                    "Invalid date. Please use a valid date in YYYY-MM-DD format."
                );
                continue;
            }

            // Get event time
            System.out.println("Enter event time (HH:MM AM/PM):");
            String time = scanner.nextLine();

            // Get event location
            System.out.println("Enter event location:");
            String location = scanner.nextLine();

            // Get event type
            System.out.println("Enter event type:");
            String eventType = scanner.nextLine();

            // Get optional notes
            System.out.println("Enter event notes (optional):");
            String notes = scanner.nextLine();

            // Create the Event object
            Event event = new Event(
                name,
                date,
                time,
                location,
                eventType,
                notes
            );

            // Add the Event to the Calendar
            if (calendar.addEvent(event)) {
                System.out.println();
                System.out.println("Event saved successfully!");
                System.out.println(event);
            } else {
                System.out.println();
                System.out.println("Event could not be saved.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {

        App app = new App();

        app.run();
    }
}

