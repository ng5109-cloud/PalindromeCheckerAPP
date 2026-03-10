import java.util.Scanner;

/**
 * UC4: Character Array Based Palindrome Check
 * This version uses a char array and the two-pointer approach for efficiency.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Two-Pointer Method) ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 1. Convert String to a Character Array
        // This allows direct index-based access to individual characters
        char[] charArray = input.toLowerCase().toCharArray();

        // 2. Initialize Two Pointers
        int left = 0;
        int right = charArray.length - 1;
        boolean isPalindrome = true;

        // 3. Compare characters using the pointers
        while (left < right) {
            // Check if characters at both ends match
            if (charArray[left] != charArray[right]) {
                isPalindrome = false;
                break; // Optimization: stop as soon as a mismatch is found
            }
            // Move pointers toward the middle
            left++;
            right--;
        }

        // 4. Display the result
        System.out.println("\nInput: " + input);
        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome!");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        scanner.close();
    }
}