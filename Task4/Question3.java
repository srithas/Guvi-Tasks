// Question 3
// Purpose: Handling out of bound exception for day outside range

import java.util.Scanner;

class WeekdayException{
    public static void main(String[] args) {
        // Array of weekdays => Sunday starts at 0 
        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        Scanner scanner = new Scanner(System.in);
        
        // Get user input
        try {
            System.out.print("Enter day position from 0 to 6: ");
            int dayIndex = scanner.nextInt();
            
            // Display Weekday
            System.out.println(weekdays[dayIndex]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index Out Of Bounds");
        } 
    }
}
