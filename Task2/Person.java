// Question 1.4
// Purpose: Define base class Person, subclass Employee that inherits information from Person

class Person{
    String name;
    int age;

    // Constructor
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // Display
    public void displayPerson(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}