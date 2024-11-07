// Question 2
// Purpose: Voter age excpetion handling

import java.util.Scanner;

class VoterException{

    // Exception for Invalid Age
    static class InvalidVoterAgeException extends Exception {
        public InvalidVoterAgeException(String message) {
            super(message);
        }
    }

    // Voter class 
    static class Voter {
        int voterId;
        String name;
        int age;

        // Parameterized constructor
        public Voter(int voterId, String name, int age) throws InvalidVoterAgeException {
            if (age < 18) {
                throw new InvalidVoterAgeException("invalid age for voter");
            }
            this.voterId = voterId;
            this.name = name;
            this.age = age;
        }

        // Display voter information
        public void displayVoterInfo() {
            System.out.println("Voter ID: " + voterId);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get User information
        try {
            System.out.print("Enter Voter ID: ");
            int voterId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            // Voter object
            Voter voter = new Voter(voterId, name, age);

            // Display Voter information
            voter.displayVoterInfo();

        } catch (InvalidVoterAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

