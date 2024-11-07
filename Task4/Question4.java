// Question 4
// Purpose: Creating HashMap for new Student and displaying students grade by name

import java.util.HashMap;
import java.util.Scanner;

class StudentGrades{
    HashMap<String, Integer> grades;

    // Constructor for HashMap
    public StudentGrades() {
        grades = new HashMap<>();
    }

    // Add Student name and grade
    public void addStudent(String name, int grade) {
        grades.put(name, grade);
        System.out.println("Added => Student: " + name + " - Grade: " + grade);
    }

    // Remove Student by name
    public void removeStudent(String name) {
        if (grades.containsKey(name)) {
            grades.remove(name);
            System.out.println("Removed => Student: " + name);
        } else {
            System.out.println(name + " Not Found");
        }
    }

    // Display student's grade by name
    public void displayGrade(String name) {
        Integer grade = grades.get(name);
        if (grade != null) {
            System.out.println(name + " -> " + grade);
        }
    }


    public static void main(String[] args) {
        StudentGrades studentGrades = new StudentGrades();
        Scanner scanner = new Scanner(System.in);

        // User Selection
        while (true) {
            System.out.println("\nMake a Selection:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Student Grade");
            System.out.print("Selection: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    int grade = scanner.nextInt();
                    studentGrades.addStudent(name, grade);
                    break;
                case 2:
                    System.out.print("Enter student name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    studentGrades.removeStudent(nameToRemove);
                    break;
                case 3:
                    System.out.print("Enter student name to display grade: ");
                    String nameToDisplay = scanner.nextLine();
                    studentGrades.displayGrade(nameToDisplay);
                    break;
            }
        }
    }
}
