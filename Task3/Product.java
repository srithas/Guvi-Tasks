// Question 2
// Purpose: Use abstract classes to calculate the income tax on yearly salary and sales tax on unit price of product

public class Product implements Taxable {
    int pid;
    double price;
    int quantity;

    // Initialization Constructor
    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate sales tax on unit price
    @Override
    public double calcTax() {
        return price * SALES_TAX;
    }

    // Display product information and tax
    public void displayProduct() {
        System.out.println("Product ID: " + pid);
        System.out.println("Unit Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Sales Tax (per unit): $" + calcTax());
    }
}

