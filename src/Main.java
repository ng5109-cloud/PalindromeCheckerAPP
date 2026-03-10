import java.util.*;

/**
 * UC13: Performance Comparison
 * Measures and compares the execution time of different palindrome algorithms.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC13: Palindrome Performance Comparison ---");
        System.out.print("Enter a long string to test: ");
        String input = scanner.nextLine();
        
        // Warm-up the JVM (to ensure accurate timing)
        runLoopMethod(input);

        // 1. Measure String Reversal (UC3)
        long start = System.nanoTime();
        runLoopMethod(input);
        long end = System.nanoTime();
        long timeLoop = end - start;

        // 2. Measure Two-Pointer / Array (UC4)
        start = System.nanoTime();
        runTwoPointerMethod(input);
        end = System.nanoTime();
        long timeTwoPointer = end - start;

        // 3. Measure Stack-Based (UC5)
        start = System.nanoTime();
        runStackMethod(input);
        end = System.nanoTime();
        long timeStack = end - start;

        // 4. Display Results in a Table
        System.out.println("\n--- Comparison Results ---");
        System.out.printf("%-25s | %-15s%n", "Method", "Execution Time (ns)");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-25s | %-15d%n", "String Reverse (Loop)", timeLoop);
        System.out.printf("%-25s | %-15d%n", "Two-Pointer (Array)", timeTwoPointer);
        System.out.printf("%-25s | %-15d%n", "Stack (LIFO)", timeStack);
        
        System.out.println("\nObservation: The Two-Pointer method is typically the fastest because it avoids object creation.");

        scanner.close();
    }

    // UC3 Logic
    private static void runLoopMethod(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        boolean res = str.equalsIgnoreCase(reversed);
    }

    // UC4 Logic
    private static void runTwoPointerMethod(String str) {
        char[] arr = str.toLowerCase().toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left++] != arr[right--]) return;
        }
    }

    // UC5 Logic
    private static void runStackMethod(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        boolean res = str.equalsIgnoreCase(sb.toString());
    }
}