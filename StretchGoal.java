import java.util.ArrayList;

public class StretchGoal {

    public static ArrayList<String> getItems(Event event) {
        ArrayList<String> items = new ArrayList<>();

        String type = event.getEventType();

        if (type.equalsIgnoreCase("birthday")) {
            items.add("Birthday card");
            items.add("Gift");
        } else if (type.equalsIgnoreCase("meeting")) {
            items.add("Notebook");
            items.add("Pen");
        } else if (type.equalsIgnoreCase("sports")) {
            items.add("Water bottle");
            items.add("Athletic shoes");
        }

        // Seasons based on Northern Hemisphere months.
        int month = event.getDate().getMonthValue();

        if (month >= 3 && month <= 5) {
            items.add("Umbrella");
            items.add("Light jacket");
        } else if (month >= 6 && month <= 8) {
            items.add("Sunscreen");
            items.add("Water bottle");
        } else if (month >= 9 && month <= 11) {
            items.add("Jacket");
        } else {
            items.add("Warm coat");
            items.add("Gloves");
        }

        return items;
    }
}