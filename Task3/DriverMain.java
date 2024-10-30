// Question 2
// Purpose: Use abstract classes to calculate the income tax on yearly salary and sales tax on unit price of product

import java.util.Scanner;

public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Employee Information
        System.out.println("Enter Employee Details:");
        System.out.print("Employee ID: ");
        int empID = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(empID, name, salary);
        System.out.println("\nEmployee Information and Income Tax:");
        employee.displayInfo();

        // Product Information
        System.out.println("\nEnter Product Details:");
        System.out.print("Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Unit Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(pid, price, quantity);
        System.out.println("\nProduct Information and Sales Tax:");
        product.displayProduct();

        scanner.close();
    }
}
