public class Event {

    private String name;
    private String date;
    private String time;
    private String location;
    private String eventType;
    private String notes;

    public Event(String name, String date, String time,
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", eventType='" + eventType + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}