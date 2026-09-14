import java.util;
import java.io.File;

public void main(String[] args) {
    public class App{

        private boolean isRunning;

        Calendar[] calendars = new Calendar[100];

        while (isRunning) {
            // Prompt the user to add an event or exit
            System.out.println("add your event here or type 'exit' to quit:");
            // Read the user's input
            Scanner scr = new Scanner(System.in);
            
            // Check if the user wants to exit
            if (scr.nextLine().equals("exit")) 
            {
                isRunning = false;
            } 
            else 
            {
                System.out.println("Entear event name:");
                    String name = new Scanner(System.in).nextLine();
                System.out.println("Enter event date (YYYY-MM-DD):");
                    String date = new Scanner(System.in).nextLine();
                System.out.println("Enter event time (HH:MM AM/PM):");
                    String time = new Scanner(System.in).nextLine();
                System.out.println("Enter event location:");
                    String location = new Scanner(System.in).nextLine();
                System.out.println("Enter event season:");
                    String season = new Scanner(System.in).nextLine();
                System.out.println("Enter event notes:");
                    String notes = new Scanner(System.in).nextLine();
                
                //creates a calendar object with the user input
                Calendar calendar = new Calendar(name, date, time, location, season);
                // Store the calendar object in the array
                for (int i = 0; i < calendars.length; i++) {
                    if (calendars[i] == null) {
                        calendars[i] = calendar;
                        break;
                    }
                }
            }
        }


    }
        
    }
}