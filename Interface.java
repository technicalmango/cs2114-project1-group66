import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Interface {
    private static Scanner scanner = new Scanner(System.in);
    private static Calendar calendar = new Calendar();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- HOKIE PLANS ---");
            System.out.println("1. Create event");
            System.out.println("2. Show all events");
            System.out.println("3. Show events on a date");
            System.out.println("4. Edit event");
            System.out.println("5. Delete event");
            System.out.println("6. What should I bring?");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    calendar.addEvent(readEvent());
                    System.out.println("Event added.");
                    break;

                case "2":
                    calendar.showAllEvents();
                    break;

                case "3":
                    calendar.showEventsOnDate(readDate());
                    break;

                case "4":
                    int editIndex = chooseEvent();

                    if (editIndex != -1) {
                        System.out.println(
                            "Enter all the replacement details:"
                        );
                        Event replacement = readEvent();
                        calendar.editEvent(editIndex, replacement);
                        System.out.println("Event updated.");
                    }
                    break;

                case "5":
                    int deleteIndex = chooseEvent();

                    if (deleteIndex != -1) {
                        calendar.deleteEvent(deleteIndex);
                        System.out.println("Event deleted.");
                    }
                    break;

                case "6":
                    int selectedIndex = chooseEvent();

                    if (selectedIndex != -1) {
                        Event event = calendar.getEvent(selectedIndex);

                        System.out.println("Suggested items:");
                        for (String item : StretchGoal.getItems(event)) {
                            System.out.println("- " + item);
                        }
                    }
                    break;

                case "7":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Choose a number from 1 to 7.");
            }
        }

        scanner.close();
    }

    private static Event readEvent() {
        String name = readRequiredText("Event name: ");
        LocalDate date = readDate();
        LocalTime time = readTime();
        String location = readRequiredText("Location: ");
        String type = readRequiredText(
            "Event type (birthday, meeting, sports, etc.): "
        );

        System.out.print("Notes (press Enter to skip): ");
        String notes = scanner.nextLine();

        return new Event(name, date, time, location, type, notes);
    }

    private static String readRequiredText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = scanner.nextLine().trim();

            if (!text.isEmpty()) {
                return text;
            }

            System.out.println("This field cannot be blank.");
        }
    }

    private static LocalDate readDate() {
        while (true) {
            System.out.print("Date (YYYY-MM-DD): ");
            String text = scanner.nextLine();

            if (DateValidator.isValidDate(text)) {
                return DateValidator.parseDate(text);
            }

            System.out.println(
                "Invalid date. Try a real date like 2026-09-14."
            );
        }
    }

    private static LocalTime readTime() {
        while (true) {
            System.out.print("Time (24-hour HH:MM, like 14:30): ");
            String text = scanner.nextLine();

            if (text.matches("[0-9]{2}:[0-9]{2}")) {
                try {
                    return LocalTime.parse(text);
                } catch (DateTimeParseException e) {
                    // Show the message below and ask again.
                }
            }

            System.out.println(
                "Invalid time. Use something like 09:00 or 14:30."
            );
        }
    }

    private static int chooseEvent() {
        calendar.showAllEvents();

        if (calendar.size() == 0) {
            return -1;
        }

        while (true) {
            System.out.print("Event number (0 to cancel): ");

            try {
                int number = Integer.parseInt(scanner.nextLine());

                if (number == 0) {
                    return -1;
                }

                if (number >= 1 && number <= calendar.size()) {
                    return number - 1;
                }
            } catch (NumberFormatException e) {
                // Show the message below and ask again.
            }

            System.out.println("Enter a listed event number or 0.");
        }
    }
}