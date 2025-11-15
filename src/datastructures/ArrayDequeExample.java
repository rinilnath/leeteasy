package datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * SCENARIO: Photo Editor with Undo/Redo
 *
 * You're editing a photo and want to undo and redo your changes.
 * An ARRAYDEQUE (Double-Ended Queue) allows you to add/remove from BOTH ends!
 * It's perfect for undo/redo, and can work as both Stack AND Queue.
 *
 * WHAT IS AN ARRAYDEQUE?
 * - DEque = Double-Ended Queue (pronounced "deck")
 * - Can add/remove from BOTH front and back
 * - Faster than Stack and LinkedList
 * - Can be used as Stack (LIFO) OR Queue (FIFO)
 * - No capacity restrictions (grows as needed)
 *
 * THINK OF IT LIKE:
 * - A deck of cards - you can add/remove from top or bottom
 * - A line where people can join from either end
 */
public class ArrayDequeExample {

    public static void main(String[] args) {

        // Step 1: Create deques for undo and redo
        // Deque is the interface, ArrayDeque is the implementation
        Deque<String> undoHistory = new ArrayDeque<>();
        Deque<String> redoHistory = new ArrayDeque<>();

        System.out.println("=== PHOTO EDITOR - UNDO/REDO ===\n");

        // Step 2: User makes edits (add to undo history)
        System.out.println("Making edits...");
        undoHistory.push("Original Photo");
        System.out.println("1. Original Photo");

        undoHistory.push("Applied Filter: Black & White");
        System.out.println("2. Applied Filter: Black & White");

        undoHistory.push("Cropped Image");
        System.out.println("3. Cropped Image");

        undoHistory.push("Added Text: 'Vacation 2024'");
        System.out.println("4. Added Text: 'Vacation 2024'");

        undoHistory.push("Adjusted Brightness");
        System.out.println("5. Adjusted Brightness");

        System.out.println("\nCurrent state: " + undoHistory.peek());
        System.out.println("Undo history size: " + undoHistory.size());

        // Step 3: UNDO - Go back 2 steps
        System.out.println("\n--- UNDO (Ctrl+Z) ---");
        String undone1 = undoHistory.pop();  // Remove from top
        redoHistory.push(undone1);           // Save to redo
        System.out.println("Undid: " + undone1);
        System.out.println("Current state: " + undoHistory.peek());

        System.out.println("\n--- UNDO again ---");
        String undone2 = undoHistory.pop();
        redoHistory.push(undone2);
        System.out.println("Undid: " + undone2);
        System.out.println("Current state: " + undoHistory.peek());

        // Step 4: REDO - Go forward
        System.out.println("\n--- REDO (Ctrl+Y) ---");
        String redone = redoHistory.pop();   // Remove from redo stack
        undoHistory.push(redone);            // Put back to undo stack
        System.out.println("Redid: " + redone);
        System.out.println("Current state: " + undoHistory.peek());

        System.out.println("\nUndo history: " + undoHistory.size() + " states");
        System.out.println("Redo history: " + redoHistory.size() + " states");

        // Step 5: Demonstrate BOTH ENDS functionality
        demonstrateDoubleEndedOperations();

        // Step 6: Demonstrate as Queue (FIFO)
        demonstrateAsQueue();

        // Step 7: Demonstrate Task Priority System
        demonstrateTaskPriority();

        /**
         * KEY POINTS ABOUT ARRAYDEQUE:
         * ✓ Fast operations at BOTH ends
         * ✓ More efficient than Stack and LinkedList
         * ✓ Can work as Stack (LIFO) or Queue (FIFO)
         * ✓ No capacity restrictions - grows as needed
         * ✓ NOT thread-safe (use for single thread)
         * ✗ No null elements allowed
         * ✗ Can't access middle elements by index
         *
         * STACK-LIKE METHODS (for top/front):
         * - push(item) - adds to front
         * - pop() - removes from front
         * - peek() - views front without removing
         *
         * QUEUE-LIKE METHODS:
         * - offer(item) / offerLast(item) - adds to back
         * - poll() / pollFirst() - removes from front
         * - peek() / peekFirst() - views front
         *
         * DOUBLE-ENDED METHODS:
         * - addFirst(item) / offerFirst(item) - adds to front
         * - addLast(item) / offerLast(item) - adds to back
         * - removeFirst() / pollFirst() - removes from front
         * - removeLast() / pollLast() - removes from back
         * - getFirst() / peekFirst() - views front
         * - getLast() / peekLast() - views back
         *
         * WHEN TO USE ARRAYDEQUE:
         * - Undo/Redo functionality
         * - Need both stack and queue operations
         * - Better performance than Stack or LinkedList
         * - Sliding window problems
         * - Priority task management
         */
    }

    /**
     * Demonstrates adding/removing from both ends
     */
    private static void demonstrateDoubleEndedOperations() {
        System.out.println("\n\n=== DOUBLE-ENDED OPERATIONS ===\n");

        Deque<String> deque = new ArrayDeque<>();

        // Add to both ends
        System.out.println("Building a deque from both ends...");

        deque.addLast("Middle");
        System.out.println("Added to back: Middle");
        System.out.println("Deque: " + deque);

        deque.addFirst("Front");
        System.out.println("\nAdded to front: Front");
        System.out.println("Deque: " + deque);

        deque.addLast("Back");
        System.out.println("\nAdded to back: Back");
        System.out.println("Deque: " + deque);

        deque.addFirst("VeryFront");
        System.out.println("\nAdded to front: VeryFront");
        System.out.println("Deque: " + deque);

        // View both ends
        System.out.println("\n--- Viewing Both Ends ---");
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());
        System.out.println("Size: " + deque.size());

        // Remove from both ends
        System.out.println("\n--- Removing from Both Ends ---");
        String first = deque.removeFirst();
        System.out.println("Removed from front: " + first);
        System.out.println("Deque: " + deque);

        String last = deque.removeLast();
        System.out.println("Removed from back: " + last);
        System.out.println("Deque: " + deque);
    }

    /**
     * Use ArrayDeque as a Queue (FIFO)
     */
    private static void demonstrateAsQueue() {
        System.out.println("\n\n=== USING AS QUEUE (FIFO) ===\n");

        Deque<String> queue = new ArrayDeque<>();

        System.out.println("Customers joining line...");
        queue.offer("Alice");    // Add to back
        queue.offer("Bob");
        queue.offer("Charlie");

        System.out.println("Queue: " + queue);

        System.out.println("\nServing customers (FIFO):");
        while (!queue.isEmpty()) {
            String customer = queue.poll();  // Remove from front
            System.out.println("✓ Served: " + customer);
        }
    }

    /**
     * Bonus: Task Priority System
     * Urgent tasks go to front, normal tasks to back
     */
    private static void demonstrateTaskPriority() {
        System.out.println("\n\n=== TASK PRIORITY SYSTEM ===\n");

        Deque<String> taskQueue = new ArrayDeque<>();

        // Add normal tasks (to back)
        System.out.println("Adding normal tasks...");
        taskQueue.offerLast("Write report");
        taskQueue.offerLast("Reply to emails");
        taskQueue.offerLast("Update documentation");

        System.out.println("Task queue: " + taskQueue);

        // Urgent task arrives! (add to front)
        System.out.println("\n🚨 URGENT task arrives!");
        taskQueue.offerFirst("Fix critical bug!");
        System.out.println("Task queue: " + taskQueue);

        // Another urgent task
        System.out.println("\n🚨 Another URGENT task!");
        taskQueue.offerFirst("Call important client");
        System.out.println("Task queue: " + taskQueue);

        // Add a normal task
        System.out.println("\nAdding normal task...");
        taskQueue.offerLast("Schedule meeting");
        System.out.println("Task queue: " + taskQueue);

        // Process all tasks (urgent ones first!)
        System.out.println("\n--- Processing Tasks ---");
        int taskNum = 1;
        while (!taskQueue.isEmpty()) {
            String task = taskQueue.pollFirst();  // Take from front
            if (task.contains("URGENT") || task.contains("critical") || task.contains("important")) {
                System.out.println(taskNum + ". 🚨 " + task + " (URGENT)");
            } else {
                System.out.println(taskNum + ". ✓ " + task);
            }
            taskNum++;
        }

        System.out.println("\n✓ All tasks completed!");
    }
}
