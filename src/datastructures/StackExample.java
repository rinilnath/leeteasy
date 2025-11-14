package datastructures;

import java.util.Stack;

/**
 * SCENARIO: Web Browser History (Back Button)
 *
 * When you browse websites, clicking "Back" takes you to the LAST page you visited.
 * This is LIFO: Last In, First Out (like a stack of plates)
 * A STACK is perfect for "undo" operations or tracking history.
 *
 * WHAT IS A STACK?
 * - Think of it like a stack of plates
 * - You can only add or remove from the TOP
 * - Last plate you put on is the first one you take off
 * - LIFO: Last In, First Out
 *
 * REAL-WORLD EXAMPLES:
 * - Browser back button
 * - Undo in text editors (Ctrl+Z)
 * - Function call stack in programming
 */
public class StackExample {

    public static void main(String[] args) {

        // Step 1: Create an empty stack for browser history
        Stack<String> browserHistory = new Stack<>();

        System.out.println("=== BROWSER HISTORY (BACK BUTTON) ===\n");

        // Step 2: Visit websites (push onto stack)
        // push() adds an item to the TOP of the stack
        System.out.println("Visiting websites...");
        browserHistory.push("google.com");
        System.out.println("→ Visited: google.com");

        browserHistory.push("github.com");
        System.out.println("→ Visited: github.com");

        browserHistory.push("stackoverflow.com");
        System.out.println("→ Visited: stackoverflow.com");

        browserHistory.push("youtube.com");
        System.out.println("→ Visited: youtube.com");

        // Step 3: Check current page (top of stack)
        // peek() shows the top item WITHOUT removing it
        System.out.println("\nCurrent page: " + browserHistory.peek());
        System.out.println("History size: " + browserHistory.size() + " pages");

        // Step 4: Click the BACK button
        // pop() removes and returns the TOP item
        System.out.println("\n--- Clicking BACK button ---");
        String lastPage = browserHistory.pop();
        System.out.println("← Going back from: " + lastPage);
        System.out.println("Now on: " + browserHistory.peek());

        // Click back again
        System.out.println("\n--- Clicking BACK again ---");
        lastPage = browserHistory.pop();
        System.out.println("← Going back from: " + lastPage);
        System.out.println("Now on: " + browserHistory.peek());

        // Step 5: Visit a new page (pushes onto current position)
        System.out.println("\n--- Visiting new page ---");
        browserHistory.push("reddit.com");
        System.out.println("→ Visited: reddit.com");
        System.out.println("Current page: " + browserHistory.peek());

        // Step 6: Display entire history
        System.out.println("\n--- Complete History (bottom to top) ---");
        System.out.println(browserHistory);

        // Step 7: Check if stack is empty
        System.out.println("\nIs history empty? " + browserHistory.isEmpty());

        // Step 8: Search for a page in history
        String searchPage = "google.com";
        if (browserHistory.search(searchPage) != -1) {
            // search() returns position from top (1-based)
            int position = browserHistory.search(searchPage);
            System.out.println("\n'" + searchPage + "' is " + position + " step(s) back");
        } else {
            System.out.println("\n'" + searchPage + "' not in history");
        }

        // Step 9: Go back through all history
        System.out.println("\n--- Going back through all pages ---");
        while (!browserHistory.isEmpty()) {
            String page = browserHistory.pop();
            System.out.println("← " + page);
        }

        System.out.println("\nHistory is now empty: " + browserHistory.isEmpty());

        // Step 10: Demonstrate another use case - Text Editor Undo
        demonstrateTextEditorUndo();

        /**
         * KEY POINTS ABOUT STACK:
         * ✓ LIFO: Last In, First Out
         * ✓ Only access the TOP item
         * ✓ Fast add/remove from top - O(1)
         * ✗ Can't access middle elements directly
         *
         * MAIN METHODS:
         * - push(item) - adds item to top
         * - pop() - removes and returns top item
         * - peek() - returns top item without removing
         * - isEmpty() - checks if stack is empty
         * - search(item) - finds position from top (1-based)
         * - size() - returns number of items
         *
         * WHEN TO USE STACK:
         * - Undo/Redo functionality
         * - Browser history (back button)
         * - Checking balanced parentheses
         * - Depth-first search
         * - Expression evaluation
         */
    }

    /**
     * Bonus: Another example showing text editor undo functionality
     */
    private static void demonstrateTextEditorUndo() {
        System.out.println("\n\n=== TEXT EDITOR UNDO ===\n");

        Stack<String> undoStack = new Stack<>();

        // Simulate typing
        System.out.println("Typing text...");
        undoStack.push("Hello");
        System.out.println("Text: Hello");

        undoStack.push("Hello World");
        System.out.println("Text: Hello World");

        undoStack.push("Hello World!");
        System.out.println("Text: Hello World!");

        undoStack.push("Hello World! Java is awesome");
        System.out.println("Text: Hello World! Java is awesome");

        // Undo (Ctrl+Z)
        System.out.println("\n--- Pressing Ctrl+Z (Undo) ---");
        undoStack.pop();
        System.out.println("Text after undo: " + undoStack.peek());

        System.out.println("\n--- Pressing Ctrl+Z again ---");
        undoStack.pop();
        System.out.println("Text after undo: " + undoStack.peek());
    }
}
