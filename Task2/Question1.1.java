// Question 1.1
// Purpose: Create class Person with name and age, along with given features

class Person{
    String name;
    int age;

    // Constructor with the default age of 18
    public Person(String name){
        this.name = name;
        this.age = 18;
    }

    // Constructor with name and age
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    // Method to display name and age of person
    public void display(){
        System.out.println("Name: " + name + " | Age: " + age);
    }

    public static void main(String[] args){
        Person person1 = new Person("Sritha");
        person1.display();

        Person person2 = new Person("Sritha", 23);
        person2.display();
    }
}