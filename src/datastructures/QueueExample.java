package datastructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * SCENARIO: Customer Service Line
 *
 * Customers arrive at a help desk and wait in line.
 * The FIRST person to arrive is the FIRST one helped.
 * This is FIFO: First In, First Out (like a real queue/line)
 * A QUEUE is perfect for fair ordering and task scheduling.
 *
 * WHAT IS A QUEUE?
 * - Think of it like a line at a store
 * - People join at the BACK
 * - People leave from the FRONT
 * - FIFO: First In, First Out
 *
 * STACK vs QUEUE:
 * - Stack: LIFO (Last In, First Out) - like plates
 * - Queue: FIFO (First In, First Out) - like a line
 *
 * REAL-WORLD EXAMPLES:
 * - Customer service lines
 * - Printer queue
 * - Task scheduling
 * - Buffering (video streaming)
 */
public class QueueExample {

    public static void main(String[] args) {

        // Step 1: Create a queue for customer service
        // Queue is an interface, so we use LinkedList as the implementation
        Queue<String> customerLine = new LinkedList<>();

        System.out.println("=== CUSTOMER SERVICE LINE ===\n");

        // Step 2: Customers join the line
        // offer() or add() adds customer to the BACK of the line
        System.out.println("Customers joining the line...");
        customerLine.offer("Alice");
        System.out.println("→ Alice joined the line");

        customerLine.offer("Bob");
        System.out.println("→ Bob joined the line");

        customerLine.offer("Charlie");
        System.out.println("→ Charlie joined the line");

        customerLine.offer("Diana");
        System.out.println("→ Diana joined the line");

        // Step 3: Check who's first in line
        // peek() shows the FRONT person WITHOUT removing them
        System.out.println("\nNext customer to be served: " + customerLine.peek());
        System.out.println("People in line: " + customerLine.size());

        // Step 4: Serve customers (remove from front)
        // poll() removes and returns the FRONT person
        System.out.println("\n--- Serving customers ---");
        String served = customerLine.poll();
        System.out.println("✓ Served: " + served);
        System.out.println("Next in line: " + customerLine.peek());
        System.out.println("Remaining: " + customerLine.size() + " customers");

        // Serve another customer
        System.out.println("\n--- Serving next customer ---");
        served = customerLine.poll();
        System.out.println("✓ Served: " + served);
        System.out.println("Next in line: " + customerLine.peek());

        // Step 5: More customers arrive
        System.out.println("\n--- New customers arriving ---");
        customerLine.offer("Eve");
        System.out.println("→ Eve joined the line");

        customerLine.offer("Frank");
        System.out.println("→ Frank joined the line");

        // Step 6: Display entire queue
        System.out.println("\n--- Current Line (front to back) ---");
        System.out.println(customerLine);
        System.out.println("Total waiting: " + customerLine.size());

        // Step 7: Check if queue is empty
        System.out.println("\nIs line empty? " + customerLine.isEmpty());

        // Step 8: Serve all remaining customers
        System.out.println("\n--- Serving all customers ---");
        int customerNumber = 1;
        while (!customerLine.isEmpty()) {
            String customer = customerLine.poll();
            System.out.println(customerNumber + ". ✓ Served: " + customer);
            customerNumber++;
        }

        System.out.println("\nLine is now empty: " + customerLine.isEmpty());

        // Step 9: Demonstrate another use case - Printer Queue
        demonstratePrinterQueue();

        /**
         * KEY POINTS ABOUT QUEUE:
         * ✓ FIFO: First In, First Out
         * ✓ Add at the BACK, remove from the FRONT
         * ✓ Fair ordering - first come, first served
         * ✓ Fast add/remove operations
         *
         * MAIN METHODS:
         * - offer(item) / add(item) - adds item to back
         * - poll() / remove() - removes and returns front item
         * - peek() / element() - returns front item without removing
         * - isEmpty() - checks if queue is empty
         * - size() - returns number of items
         *
         * DIFFERENCE BETWEEN METHODS:
         * - offer() vs add(): offer returns false if full, add throws exception
         * - poll() vs remove(): poll returns null if empty, remove throws exception
         * - peek() vs element(): peek returns null if empty, element throws exception
         * (Usually use offer, poll, peek for safer code)
         *
         * WHEN TO USE QUEUE:
         * - First-come, first-served scenarios
         * - Task scheduling
         * - Breadth-first search
         * - Buffering
         * - Order processing
         */
    }

    /**
     * Bonus: Another example showing printer queue
     */
    private static void demonstratePrinterQueue() {
        System.out.println("\n\n=== PRINTER QUEUE ===\n");

        Queue<String> printerQueue = new LinkedList<>();

        // Add print jobs
        System.out.println("Adding print jobs...");
        printerQueue.offer("Document1.pdf (5 pages)");
        printerQueue.offer("Photo.jpg (1 page)");
        printerQueue.offer("Report.docx (20 pages)");
        printerQueue.offer("Resume.pdf (2 pages)");

        System.out.println("Print jobs in queue: " + printerQueue.size());

        // Process print jobs
        System.out.println("\n--- Printing documents ---");
        while (!printerQueue.isEmpty()) {
            String job = printerQueue.poll();
            System.out.println("🖨️  Printing: " + job);

            // Simulate printing time
            try {
                Thread.sleep(1000);  // Wait 1 second
            } catch (InterruptedException e) {
                // Ignore
            }
        }

        System.out.println("\n✓ All print jobs completed!");
    }
}
