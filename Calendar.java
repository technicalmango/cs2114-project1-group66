import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Calendar {
    private String name;
    private String date;
    private String time;
    private String location;
    private String season;
    private String notes;

    public Calendar(String name, String date, String time, String location, String season) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.season = season;

        try {
            Files.writeString(
                Path.of("EventStore.txt"),
                name + " " + date + " " + time + " " + location + " " + season + System.lineSeparator(),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Unable to save event: " + e.getMessage());
        }
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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", season='" + season + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}