import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateValidator {

    public static boolean isValidDate(String text) {
        if (text == null
                || !text.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            return false;
        }

        try {
            LocalDate date = LocalDate.parse(text);
            return date.getYear() >= 1;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalDate parseDate(String text) {
        if (!isValidDate(text)) {
            throw new IllegalArgumentException(
                "Enter a real date using YYYY-MM-DD."
            );
        }

        return LocalDate.parse(text);
    }
}