// Question 1.2
// Purpose: Create main function in different class and perform given tasks

import java.util.Scanner;

class XYZ{
    public static double calculate(Product[] products){
        double total = 0;
        
        // For loop to iterate through array and add prices together
        for (Product product : products){
            total += product.price * product.quantity;
        }

        return total;
    }
    public static void main(String[] args) {
        // Accepting five product information from user and store in an array
        Scanner scanner = new Scanner(System.in);
        Product[] products = new Product[5];

        // For loop to iterate through information and stor in array
        for (int i = 0; i < 5; i++){
            System.out.println("Enter product information: Product " + (i + 1) + ": ");
        
            System.out.print("PID: ");
            int pid = scanner.nextInt();

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();

            products[i] = new Product(pid, price, quantity);
        }

        // Find PID of the product with the highest price
        int PID_highest = products[0].pid;
        double Price_highest = products[0].pid;

        // Use a for loop and if condition to iterate through array and compare prices
        for (int i = 1; i < products.length; i++){
            if (products[i].price > Price_highest){
                Price_highest = products[i].price;
                PID_highest = products[i].pid;
            }
        }

        // Display
        System.out.println("PID of product with highest price: " + PID_highest);

        // Total amount spent on all products
        double total = calculate(products);
        System.out.println("Total amount spent on all products: $" + total);
    }

}
    
