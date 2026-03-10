import java.util.Scanner;

/**
 * UC10: Case-Insensitive & Space-Ignored Palindrome
 * This version uses preprocessing (Regex) to normalize the input
 * before applying the validation logic.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Normalized Method) ---");
        System.out.println("This version ignores spaces, punctuation, and case.");
        System.out.print("Enter a string or sentence: ");
        String input = scanner.nextLine();

        // 1. Preprocessing / Normalization
        // Use Regex [^a-zA-Z0-9] to remove everything except letters and numbers
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 2. Validation Logic (Using two-pointer approach for efficiency)
        boolean isPalindrome = checkPalindrome(normalized);

        // 3. Display Results
        System.out.println("\nOriginal: " + input);
        System.out.println("Normalized: " + normalized);

        if (!normalized.isEmpty() && isPalindrome) {
            System.out.println("Result: It is a Palindrome!");
        } else if (normalized.isEmpty()) {
            System.out.println("Result: No valid characters to check.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        scanner.close();
    }

    /**
     * Efficient two-pointer check on the normalized string
     */
    private static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}