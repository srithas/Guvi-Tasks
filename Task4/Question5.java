// Question 5
// Purpose: Using Collection Classes to store Integers, push and pop elements from the stack

import java.util.Scanner;
import java.util.Stack;

class IntegerStack {
    Stack<Integer> stack;

    // Constructor Stack
    public IntegerStack() {
        stack = new Stack<>();
    }

    // Push an element onto the stack
    public void push(int element) {
        stack.push(element);
        System.out.println("Pushed => " + element + " onto stack");
    }

    // Pop an element from the stack
    public void pop() {
        // Check if stack is empty
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. No elements to pop");
        } else {
            int element = stack.pop();
            System.out.println("Popped => " + element + " from stack");
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    
    public static void main(String[] args) {
        IntegerStack integerStack = new IntegerStack();
        Scanner scanner = new Scanner(System.in);

        // Get user selection
        while (true) {
            System.out.println("\nMake a Selection:");
            System.out.println("1. Push element onto stack");
            System.out.println("2. Pop element from stack");
            System.out.println("3. Check if stack is empty");
            System.out.print("Selection: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    integerStack.push(element);
                    break;
                case 2:
                    integerStack.pop();
                    break;
                case 3:
                    if (integerStack.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Stack is not empty");
                    }
                    break;
            }
        }
    }
}
