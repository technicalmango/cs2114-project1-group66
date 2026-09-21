public class DateValidator {

    public static boolean isValidDate(String date) {

        String regex = "^\\d{4}-\\d{2}-\\d{2}$";

        if (!date.matches(regex)) {
            return false;
        }

        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        if (month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonth = {
            31,
            isLeapYear(year) ? 29 : 28,
            31,
            30,
            31,
            30,
            31,
            31,
            30,
            31,
            30,
            31
        };

        return day >= 1 && day <= daysInMonth[month - 1];
    }

    private static boolean isLeapYear(int year) {

        return (year % 4 == 0 && year % 100 != 0)
                || (year % 400 == 0);
    }
}