// Question 2
// Purpose: Write a condition that takes input and determines if it is a positive or negative number

import java.util.Scanner;

class Condition{
    // Using if else statements, get user input
    public static void main(String[] args){
        // User Input
        System.out.println("Enter a negative or positive number: ");
        Scanner obj = new Scanner(System.in);
        double value = obj.nextDouble();

        if(value < 0){
            System.out.println("Negative");
        }
        else{
            System.out.println("Positive");
        }

    }
}
