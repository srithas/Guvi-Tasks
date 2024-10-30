// Question 2
// Purpose: Use abstract classes to calculate the income tax on yearly salary and sales tax on unit price of product

public class Employee implements Taxable {
    int empID;
    String name;
    double salary;

    // Initialization Constructor
    public Employee(int empID, String name, double salary) {
        this.empID = empID;
        this.name = name;
        this.salary = salary;
    }

    // Method to calculate income tax on yearly salary
    @Override
    public double calcTax() {
        return salary * INCOME_TAX; 
    }

    // Display employee information and tax
    public void displayInfo() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("Income Tax: $" + calcTax());
    }
}
