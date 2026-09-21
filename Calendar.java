import java.util.ArrayList;

public class Calendar {

    private ArrayList<Event> events;
    private int displayedMonth;
    private int displayedYear;

    public Calendar() {
        events = new ArrayList<Event>();
    }

    public boolean addEvent(Event event) {

        if (!DateValidator.isValidDate(event.getDate())) {
            return false;
        }

        events.add(event);
        return true;
    }

    public ArrayList<Event> getAll() {
        return events;
    }

    public int getDisplayedMonth() {
        return displayedMonth;
    }

    public void setDisplayedMonth(int displayedMonth) {
        this.displayedMonth = displayedMonth;
    }

    public int getDisplayedYear() {
        return displayedYear;
    }

    public void setDisplayedYear(int displayedYear) {
        this.displayedYear = displayedYear;
    }
}