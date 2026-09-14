import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Calendar {
    private ArrayList<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
        sortEvents();
    }

    private void sortEvents() {
        events.sort(
            Comparator.comparing(Event::getDate)
                .thenComparing(Event::getTime)
        );
    }

    public int size() {
        return events.size();
    }

    public Event getEvent(int index) {
        return events.get(index);
    }

    public void editEvent(int index, Event replacement) {
        events.set(index, replacement);
        sortEvents();
    }

    public void deleteEvent(int index) {
        events.remove(index);
    }

    public void showAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events yet.");
            return;
        }

        for (int i = 0; i < events.size(); i++) {
            System.out.println("\nEvent " + (i + 1));
            System.out.println(events.get(i));
        }
    }

    public void showEventsOnDate(LocalDate date) {
        boolean found = false;

        for (Event event : events) {
            if (event.getDate().equals(date)) {
                System.out.println();
                System.out.println(event);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No events on that date.");
        }
    }
}