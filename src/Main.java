import java.util.Scanner;

/**
 * PalindromeService Class (The "Engine")
 * Encapsulates the logic according to OOP principles.
 */
class PalindromeService {
    
    /**
     * Public method to check if a string is a palindrome.
     * Uses normalization to ensure robustness.
     */
    public boolean check(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }

        // Normalize string: Remove non-alphanumeric and lowercase
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        return isPalindromeLogic(cleanText);
    }

    /**
     * Private helper method (Internal implementation)
     */
    private boolean isPalindromeLogic(String str) {
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

/**
 * Main Class (The "Interface")
 * Handles user input and interacts with the service.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Instantiate the Service Object
        PalindromeService service = new PalindromeService();

        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");
        System.out.print("Enter string to validate: ");
        String userInput = scanner.nextLine();

        // Use the object to perform the check
        boolean result = service.check(userInput);

        // Display Output
        System.out.println("\nAnalyzing: \"" + userInput + "\"");
        if (result) {
            System.out.println("Status: VALID Palindrome");
        } else {
            System.out.println("Status: INVALID Palindrome");
        }

        scanner.close();
    }
}