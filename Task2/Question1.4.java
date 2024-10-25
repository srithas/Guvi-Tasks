// Question 1.4
// Purpose: Define base class Person, subclass Employee that inherits information from Person

class Employee extends Person{
    int employeeID;
    double salary;

    // Constuctor Employee - using super keyword
    public Employee(String name, int age, int employeeID, double salary){
        super(name, age);
        this.employeeID = employeeID;
        this.salary = salary;
    }

    // Display Employee
    public void displayEmployee(){
        displayPerson();
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: $" + salary);
    }

    public static void main(String[] args){
        Employee employee = new Employee("Sritha", 23, 001, 95000.0);
        employee.displayEmployee();
    }
}