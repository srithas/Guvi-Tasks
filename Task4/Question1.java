// Question 1
// Purpose: Handle exception in a Student Management System

import java.util.Scanner;


class SystemException{

    // Exception for Age validation
    static class AgeNotWithinRangeException extends Exception {
        public AgeNotWithinRangeException(String message) {
            super(message);
        }
    }

    // Exception for Name validation
    static class NameNotValidException extends Exception {
        public NameNotValidException(String message) {
            super(message);
        }
    }

    // Student Class
    static class Student {
        int rollNo;
        String name;
        int age;
        String course;

        // Constructor to initialize Student attributes
        public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
            this.rollNo = rollNo;
            setName(name);  
            setAge(age);
            this.course = course;
        }

        // Age Validation
        public void setAge(int age) throws AgeNotWithinRangeException {
            if (age < 15 || age > 21) {
                throw new AgeNotWithinRangeException("Age Not Within Range 15 to 21");
            }
            this.age = age;
        }

        // Name Validation
        public void setName(String name) throws NameNotValidException {
            if (!name.matches("[a-zA-Z ]+")) {  
                throw new NameNotValidException("Name Not Valid");
            }
            this.name = name;
        }

        // Display student details
        public void displayStudentInfo() {
            System.out.println("Roll No: " + rollNo);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Course: " + course);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user information
        try {
            System.out.print("Enter Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine();  
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();  
            
            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            // Student object
            Student student = new Student(rollNo, name, age, course);
            
            // Display student information
            student.displayStudentInfo();

        } catch (AgeNotWithinRangeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NameNotValidException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
