// Question 4
// Purpose: Write condition statements to find the smallest number among 3 given numbers

import java.util.Scanner;

class Smallest{
    public static void main(String[] args){
        // Get user input
        System.out.println("Enter 3 integers: ");
        Scanner obj = new Scanner(System.in);
        int a = obj.nextInt();
        int b = obj.nextInt();
        int c = obj.nextInt();

        // Using conditional statements and AND operator to compare values of the 3 numbers
        if(a < b && a < c){
            System.out.println(a + " is the smallest number");
        }
        else if(b < a && b < c ){
            System.out.println(b + " is the smallest number");
        }
        else{
            System.out.println(c + " is the smallest number");
        }
    }
}
