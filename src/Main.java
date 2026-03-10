import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * UC7: Deque-Based Optimized Palindrome Checker
 * Uses a Double-Ended Queue to compare characters from both ends simultaneously.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Deque-Based Method) ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 1. Initialize a Deque
        // ArrayDeque is a highly efficient implementation of the Deque interface
        Deque<Character> deque = new ArrayDeque<>();

        // 2. Insert characters into the deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindrome = true;

        // 3. Remove from first and last and compare
        // We continue as long as there are at least 2 characters to compare
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (Character.toLowerCase(first) != Character.toLowerCase(last)) {
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