import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (UC3) ---");
        System.out.print("Enter a string to check: ");
        String original = scanner.nextLine();

        // 1. Reverse string using a loop
        String reversed = "";
        
        // Loop backwards from the end of the string to the start
        for (int i = original.length() - 1; i >= 0; i--) {
            // String Concatenation: Building the reversed string
            // Note: This creates a new String object in every iteration
            reversed += original.charAt(i);
        }

        // 2. Compare original and reversed using equals()
        // We use .equals() because == checks memory reference, 
        // while .equals() checks the actual sequence of characters.
        if (original.equals(reversed)) {
            System.out.println("Result: '" + original + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + original + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}