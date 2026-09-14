import java.util.Scanner;

public class App {
    private static final int MAX_EVENTS = 100;
    private final Calendar[] calendars = new Calendar[MAX_EVENTS];
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Add your event here or type 'exit' to quit:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                isRunning = false;
                System.out.println("Goodbye!");
                continue;
            }

            System.out.println("Enter event name:");
            String name = scanner.nextLine();
            System.out.println("Enter event date (YYYY-MM-DD):");
            String date = scanner.nextLine();
            System.out.println("Enter event time (HH:MM AM/PM):");
            String time = scanner.nextLine();
            System.out.println("Enter event location:");
            String location = scanner.nextLine();
            System.out.println("Enter event season:");
            String season = scanner.nextLine();
            System.out.println("Enter event notes:");
            String notes = scanner.nextLine();

            if (!DateValidator.isValidDate(date)) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                continue;
            }

            Calendar calendar = new Calendar(name, date, time, location, season);
            calendar.setNotes(notes);

            for (int i = 0; i < calendars.length; i++) {
                if (calendars[i] == null) {
                    calendars[i] = calendar;
                    break;
                }
            }

            System.out.println("Event saved: " + calendar);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new App().run();
    }
}

