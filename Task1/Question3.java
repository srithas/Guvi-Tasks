// Question 3
// Purpose: Write a loop to reverse the order of the given integer

import java.util.Scanner;

class Reverse{
    public static void main(String[] args){
        // Get user input
        System.out.println("Enter an integer: ");
        Scanner obj = new Scanner(System.in);
        int value = obj.nextInt();

        int result = 0;
        // Use while loop to iterate through number
        while(value != 0){
            // Divide by 10 to get remainder which will be last digit
            int num = value % 10;
            // Store last digit and multiply by 10 so when adding new digit it will be added to the end
            result = result * 10 + num;
            // Remove last digit from user value
            value = value / 10;
        }

        System.out.println(result);
    }
}
