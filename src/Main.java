import java.util.Scanner;
import java.util.Stack;

/**
 * UC5: Stack-Based Palindrome Checker
 * This version uses the LIFO property of a Stack to reverse the input.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Stack-Based Method) ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 1. Initialize a Stack of Characters
        Stack<Character> stack = new Stack<>();

        // 2. Push all characters of the string into the stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // 3. Pop characters from the stack to build the reversed string
        // Since it is LIFO, the last character pushed is the first one popped
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // 4. Compare and display result
        System.out.println("\nOriginal: " + input);
        System.out.println("Reversed: " + reversed.toString());

        if (input.equalsIgnoreCase(reversed.toString())) {
            System.out.println("Result: It is a Palindrome!");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        scanner.close();
    }
}