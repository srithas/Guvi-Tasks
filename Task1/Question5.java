// Question 5
// Purpose: Write program to calculate final payable amount after discount

import java.util.Scanner;

class Discount{
    public static void main(String[] args){
        // Get user input
        System.out.println("Enter purchase amount: ");
        Scanner obj = new Scanner(System.in);
        double price = obj.nextDouble();

        // Using conditional statements and apply discount respectively
        if(price < 500){
            System.out.printf("$%.2f\n", price);
        }
        else if(price >= 500 && price <= 1000){
            double discount = price * 0.10;
            price = price - discount;
            System.out.printf("$%.2f\n", price);
        }
        else{
            double discount = price * 0.20;
            price = price - discount;
            System.out.printf("$%.2f\n", price);
        }
    }
}

