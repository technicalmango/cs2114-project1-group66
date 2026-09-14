import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private String eventType;
    private String notes;

    public Event(String name, LocalDate date, LocalTime time,
            String location, String eventType, String notes) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.eventType = eventType;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return name
            + "\nDate: " + date
            + "\nTime: " + time
            + "\nLocation: " + location
            + "\nEvent type: " + eventType
            + "\nNotes: " + notes;
    }
}