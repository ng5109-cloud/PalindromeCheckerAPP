import java.util.Scanner;

/**
 * UC8: Linked List Based Palindrome Checker
 * Uses a custom Singly Linked List and the Fast/Slow pointer technique.
 */
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Palindrome Checker (Linked List Method) ---");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        if (input == null || input.isEmpty()) {
            System.out.println("Result: It is a Palindrome!");
            scanner.close();
            return;
        }

        // 1. Build the Linked List
        Node head = new Node(input.charAt(0));
        Node current = head;
        for (int i = 1; i < input.length(); i++) {
            current.next = new Node(input.charAt(i));
            current = current.next;
        }

        // 2. Find the middle using Fast and Slow pointers
        // 
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 3. Reverse the second half of the list in-place
        // 
        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        // 4. Compare the two halves
        boolean isPalindrome = true;
        Node tempSecond = secondHalf;
        while (tempSecond != null) {
            if (Character.toLowerCase(firstHalf.data) != Character.toLowerCase(tempSecond.data)) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        // 5. Display Result
        System.out.println("\nInput: " + input);
        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome!");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
        
        scanner.close();
    }

    // Helper method to reverse a Linked List in-place
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}