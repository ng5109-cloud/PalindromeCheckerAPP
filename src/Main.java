import java.util.*;

/**
 * 1. Strategy Interface
 * Defines the contract for all palindrome algorithms.
 */
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

/**
 * 2. Concrete Strategy: Stack-Based
 */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        
        return clean.equals(reversed.toString());
    }
}

/**
 * 3. Concrete Strategy: Two-Pointer (Efficient)
 */
class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) return false;
        }
        return true;
    }
}

/**
 * 4. Context Class
 * Uses a strategy to perform the check.
 */
class PalindromeContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.isPalindrome(input);
    }
}

/**
 * Main Application
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("--- UC12: Strategy Pattern Palindrome Checker ---");
        System.out.print("Enter string: ");
        String text = scanner.nextLine();

        System.out.println("Choose Algorithm: 1. Stack (LIFO) | 2. Two-Pointer (Fast)");
        int choice = scanner.nextInt();

        // Polymorphism in action: Injecting strategy at runtime
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else {
            context.setStrategy(new TwoPointerStrategy());
        }

        boolean result = context.executeStrategy(text);
        System.out.println("\nResult using selected strategy: " + (result ? "PALINDROME" : "NOT A PALINDROME"));

        scanner.close();
    }
}