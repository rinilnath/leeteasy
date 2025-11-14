package datastructures;

import java.util.HashSet;
import java.util.ArrayList;

/**
 * SCENARIO: Website Unique Visitors Tracker
 *
 * You want to track unique visitors to your website.
 * If someone visits multiple times, count them only ONCE.
 * A HASHSET automatically removes duplicates!
 *
 * WHAT IS A HASHSET?
 * - Stores UNIQUE items only (no duplicates!)
 * - Super fast to check if item exists
 * - No specific order (items aren't sorted)
 * - Think of it like a bag where duplicates magically disappear
 *
 * ARRAYLIST vs HASHSET:
 * - ArrayList: Allows duplicates, maintains order
 * - HashSet: NO duplicates, no specific order, faster searches
 *
 * HASHMAP vs HASHSET:
 * - HashMap: Stores KEY-VALUE pairs
 * - HashSet: Stores just KEYS (values only)
 */
public class HashSetExample {

    public static void main(String[] args) {

        // Step 1: Create a set to track unique visitors
        HashSet<String> uniqueVisitors = new HashSet<>();

        System.out.println("=== WEBSITE VISITOR TRACKER ===\n");

        // Step 2: Visitors arrive (some visit multiple times)
        System.out.println("Recording visits...");

        uniqueVisitors.add("Alice");
        System.out.println("→ Alice visited");

        uniqueVisitors.add("Bob");
        System.out.println("→ Bob visited");

        uniqueVisitors.add("Charlie");
        System.out.println("→ Charlie visited");

        // Alice visits again - will NOT be added (duplicate!)
        boolean added = uniqueVisitors.add("Alice");
        if (added) {
            System.out.println("→ Alice visited (new)");
        } else {
            System.out.println("→ Alice visited again (already counted)");
        }

        uniqueVisitors.add("Diana");
        System.out.println("→ Diana visited");

        // Bob visits again - duplicate
        added = uniqueVisitors.add("Bob");
        if (added) {
            System.out.println("→ Bob visited (new)");
        } else {
            System.out.println("→ Bob visited again (already counted)");
        }

        // Step 3: Check unique visitor count
        System.out.println("\n--- STATISTICS ---");
        System.out.println("Unique visitors: " + uniqueVisitors.size());

        // Step 4: Check if specific visitor exists
        // contains() is SUPER FAST with HashSet
        String visitor = "Charlie";
        if (uniqueVisitors.contains(visitor)) {
            System.out.println("✓ " + visitor + " has visited");
        } else {
            System.out.println("✗ " + visitor + " has NOT visited");
        }

        // Step 5: Display all unique visitors
        System.out.println("\n--- ALL UNIQUE VISITORS ---");
        for (String name : uniqueVisitors) {
            System.out.println("- " + name);
        }
        // Note: Order might differ each time you run!

        // Step 6: Remove a visitor
        uniqueVisitors.remove("Bob");
        System.out.println("\nRemoved Bob from tracking");
        System.out.println("Unique visitors now: " + uniqueVisitors.size());

        // Step 7: Check if set is empty
        System.out.println("\nIs visitor list empty? " + uniqueVisitors.isEmpty());

        // Step 8: Clear all visitors
        uniqueVisitors.clear();
        System.out.println("\nCleared all visitors");
        System.out.println("Unique visitors: " + uniqueVisitors.size());

        // Demonstrate use cases
        demonstrateRemovingDuplicates();
        demonstrateSetOperations();

        /**
         * KEY POINTS ABOUT HASHSET:
         * ✓ Stores UNIQUE items only
         * ✓ Automatically removes duplicates
         * ✓ SUPER FAST contains() check - O(1)
         * ✓ FAST add/remove operations
         * ✗ NO specific order
         * ✗ Can't access by index (no get(i))
         *
         * MAIN METHODS:
         * - add(item) - adds item (returns false if duplicate)
         * - remove(item) - removes item
         * - contains(item) - checks if item exists
         * - size() - returns number of items
         * - isEmpty() - checks if set is empty
         * - clear() - removes all items
         *
         * WHEN TO USE HASHSET:
         * - Need to store unique items only
         * - Need fast lookup to check if item exists
         * - Don't care about order
         * - Removing duplicates from a list
         * - Set operations (union, intersection)
         */
    }

    /**
     * Bonus 1: Remove duplicates from a list
     */
    private static void demonstrateRemovingDuplicates() {
        System.out.println("\n\n=== REMOVING DUPLICATES ===\n");

        // List with duplicates
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(2);  // duplicate
        numbers.add(5);  // duplicate
        numbers.add(3);
        numbers.add(8);  // duplicate

        System.out.println("Original list (with duplicates): " + numbers);
        System.out.println("Size: " + numbers.size());

        // Convert to HashSet to remove duplicates
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        System.out.println("\nUnique numbers: " + uniqueNumbers);
        System.out.println("Size: " + uniqueNumbers.size());

        // Convert back to ArrayList if needed
        ArrayList<Integer> cleanedList = new ArrayList<>(uniqueNumbers);
        System.out.println("\nCleaned list: " + cleanedList);
    }

    /**
     * Bonus 2: Set operations (union, intersection, difference)
     */
    private static void demonstrateSetOperations() {
        System.out.println("\n\n=== SET OPERATIONS ===\n");

        // Two groups of students
        HashSet<String> mathClass = new HashSet<>();
        mathClass.add("Alice");
        mathClass.add("Bob");
        mathClass.add("Charlie");
        mathClass.add("Diana");

        HashSet<String> scienceClass = new HashSet<>();
        scienceClass.add("Charlie");
        scienceClass.add("Diana");
        scienceClass.add("Eve");
        scienceClass.add("Frank");

        System.out.println("Math class: " + mathClass);
        System.out.println("Science class: " + scienceClass);

        // UNION: Students in either class (or both)
        HashSet<String> union = new HashSet<>(mathClass);
        union.addAll(scienceClass);
        System.out.println("\nUnion (in either class): " + union);

        // INTERSECTION: Students in BOTH classes
        HashSet<String> intersection = new HashSet<>(mathClass);
        intersection.retainAll(scienceClass);
        System.out.println("Intersection (in both): " + intersection);

        // DIFFERENCE: Students in Math but NOT in Science
        HashSet<String> difference = new HashSet<>(mathClass);
        difference.removeAll(scienceClass);
        System.out.println("Difference (only in Math): " + difference);
    }
}
