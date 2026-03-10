import java.util.Scanner;

/**
 * UC9: Recursive Palindrome Checker
 * This version uses recursion to validate the string by 
 * shrinking the problem size with each call.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Recursive Method) ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Standardize input: remove spaces and convert to lowercase for better accuracy
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();

        // 1. Call the recursive function
        boolean isPalindrome = checkPalindromeRecursive(cleanInput, 0, cleanInput.length() - 1);

        // 2. Display Result
        System.out.println("\nInput: " + input);
        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome!");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Recursive function to check palindrome
     * @param str The string to check
     * @param start The current starting index
     * @param end The current ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean checkPalindromeRecursive(String str, int start, int end) {
        // Base Condition 1: If pointers meet or cross, all characters matched
        if (start >= end) {
            return true;
        }

        // Base Condition 2: If characters at start and end don't match, it's not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive Step: Check the inner substring by moving pointers inward
        return checkPalindromeRecursive(str, start + 1, end - 1);
    }
}