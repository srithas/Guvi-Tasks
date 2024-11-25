// Question 3
// Purpose: Filter student names so the teacher can give gifts to students whose names only start with A

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class StudentsLetterA{
    public static void main(String[] args) {
        // List of student names
        List<String> students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");
        students.add("Adam");
        students.add("Clarice");
        students.add("Ashton");
        students.add("Drew");
        students.add("Artey");
        students.add("Ethan");
        students.add("Amanda");
        students.add("Sritha");

        // Using Stream and Lambda functions to filter students names starting with A 
        List<String> students_A = students.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        
        System.out.println("List of Student starting with letter 'A': " + students_A);
    }
}
