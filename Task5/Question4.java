// Question 4
// Purpose: Using user input of given birthdate, calculate the age

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class CalculateAge{
    public static void main(String[] args) {
        // Get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birthdate (yyyy-mm-dd): ");
        String bd = scanner.nextLine();

        // Parse the input into a LocalDate object
        LocalDate birthdate = LocalDate.parse(bd);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the time between the birthdate and the current date
        Period age = Period.between(birthdate, currentDate);

        System.out.printf("Your age is: %d years, %d months, and %d days%n", age.getYears(), age.getMonths(), age.getDays());
    }
}
