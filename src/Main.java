import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * UC6: Queue + Stack Based Palindrome Checker
 * Demonstrates FIFO vs LIFO principles for validation.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Stack + Queue Method) ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 1. Initialize Data Structures
        // Stack follows LIFO (Last In First Out)
        Stack<Character> stack = new Stack<>();
        // Queue follows FIFO (First In First Out) - LinkedList implements Queue in Java
        Queue<Character> queue = new LinkedList<>();

        // 2. Load the characters into both structures
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stack.push(c);   // Adding to Stack
            queue.add(c);    // Adding to Queue (Enqueue)
        }

        boolean isPalindrome = true;

        // 3. Compare Dequeue (Original order) vs Pop (Reversed order)
        while (!stack.isEmpty()) {
            char fromStack = stack.pop();    // Last character added
            char fromQueue = queue.remove(); // First character added

            if (fromStack != fromQueue) {
                isPalindrome = false;
                break;
            }
        }

        // 4. Display Results
        System.out.println("\nInput: " + input);
        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome!");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        scanner.close();
    }
}