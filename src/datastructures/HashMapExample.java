package datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * SCENARIO: Phone Book / Contact List
 *
 * You want to store phone numbers with names.
 * Given a name, you want to quickly find their number.
 * A HASHMAP stores KEY-VALUE pairs for super-fast lookups!
 *
 * WHAT IS A HASHMAP?
 * - Stores data in KEY-VALUE pairs
 * - Key = unique identifier (like a name)
 * - Value = the data you want to store (like a phone number)
 * - SUPER FAST lookups - finds any item almost instantly!
 * - No specific order (items aren't sorted)
 *
 * THINK OF IT LIKE:
 * - A real dictionary: Word (key) → Definition (value)
 * - A phone book: Name (key) → Phone number (value)
 * - A locker room: Locker number (key) → Your belongings (value)
 */
public class HashMapExample {

    public static void main(String[] args) {

        // Step 1: Create a phone book
        // <String, String> means: Key is String (name), Value is String (phone)
        HashMap<String, String> phoneBook = new HashMap<>();

        System.out.println("=== PHONE BOOK ===\n");

        // Step 2: Add contacts (key-value pairs)
        // put(key, value) adds or updates an entry
        phoneBook.put("Alice", "555-1234");
        phoneBook.put("Bob", "555-5678");
        phoneBook.put("Charlie", "555-9012");
        phoneBook.put("Diana", "555-3456");

        System.out.println("Added 4 contacts");
        System.out.println("Total contacts: " + phoneBook.size());

        // Step 3: Look up a phone number (SUPER FAST!)
        // get(key) returns the value for that key
        String name = "Alice";
        String phone = phoneBook.get(name);
        System.out.println("\n" + name + "'s phone: " + phone);

        // Step 4: Check if a contact exists
        // containsKey(key) checks if the key exists
        String searchName = "Eve";
        if (phoneBook.containsKey(searchName)) {
            System.out.println("\n✓ " + searchName + " is in contacts");
        } else {
            System.out.println("\n✗ " + searchName + " is NOT in contacts");
        }

        // Step 5: Update a phone number
        // put() with existing key REPLACES the old value
        System.out.println("\n--- Updating Bob's number ---");
        System.out.println("Old number: " + phoneBook.get("Bob"));
        phoneBook.put("Bob", "555-9999");
        System.out.println("New number: " + phoneBook.get("Bob"));

        // Step 6: Display all contacts
        System.out.println("\n--- ALL CONTACTS ---");
        // Loop through all key-value pairs
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String contactName = entry.getKey();
            String contactPhone = entry.getValue();
            System.out.println(contactName + ": " + contactPhone);
        }

        // Alternative: Loop through just keys
        System.out.println("\n--- JUST NAMES ---");
        for (String contactName : phoneBook.keySet()) {
            System.out.println("- " + contactName);
        }

        // Alternative: Loop through just values
        System.out.println("\n--- JUST NUMBERS ---");
        for (String contactPhone : phoneBook.values()) {
            System.out.println("- " + contactPhone);
        }

        // Step 7: Check if a phone number exists
        // containsValue(value) checks if the value exists
        String searchPhone = "555-1234";
        if (phoneBook.containsValue(searchPhone)) {
            System.out.println("\n✓ Someone has number: " + searchPhone);
        }

        // Step 8: Remove a contact
        String removed = phoneBook.remove("Charlie");
        System.out.println("\nRemoved: Charlie (" + removed + ")");
        System.out.println("Contacts remaining: " + phoneBook.size());

        // Step 9: Safe retrieval with default value
        // getOrDefault() returns default if key doesn't exist
        String unknown = phoneBook.getOrDefault("Unknown", "No number found");
        System.out.println("\nLooking up 'Unknown': " + unknown);

        // Step 10: Check if empty
        System.out.println("\nIs phone book empty? " + phoneBook.isEmpty());

        // Demonstrate another use case - Word Counter
        demonstrateWordCounter();

        /**
         * KEY POINTS ABOUT HASHMAP:
         * ✓ KEY-VALUE pairs
         * ✓ Keys must be UNIQUE (values can duplicate)
         * ✓ SUPER FAST lookups - O(1) average time
         * ✓ No specific order (not sorted)
         * ✗ Uses more memory than lists
         *
         * MAIN METHODS:
         * - put(key, value) - adds or updates entry
         * - get(key) - retrieves value for key
         * - getOrDefault(key, default) - retrieves value or default
         * - remove(key) - removes entry and returns value
         * - containsKey(key) - checks if key exists
         * - containsValue(value) - checks if value exists
         * - keySet() - returns all keys
         * - values() - returns all values
         * - entrySet() - returns all key-value pairs
         * - size() - returns number of entries
         * - isEmpty() - checks if map is empty
         * - clear() - removes all entries
         *
         * WHEN TO USE HASHMAP:
         * - Need to look up data by a unique key
         * - Want very fast searches
         * - Storing configuration settings
         * - Counting occurrences
         * - Caching
         */
    }

    /**
     * Bonus: Count how many times each word appears in a sentence
     */
    private static void demonstrateWordCounter() {
        System.out.println("\n\n=== WORD COUNTER ===\n");

        String sentence = "java is fun and java is powerful and fun to learn";
        String[] words = sentence.split(" ");

        // HashMap to count occurrences
        // Key = word, Value = count
        HashMap<String, Integer> wordCount = new HashMap<>();

        System.out.println("Sentence: " + sentence);
        System.out.println("\nCounting words...");

        // Count each word
        for (String word : words) {
            // Get current count (0 if word not seen before)
            int count = wordCount.getOrDefault(word, 0);
            // Increment and store
            wordCount.put(word, count + 1);
        }

        // Display results
        System.out.println("\n--- Word Frequencies ---");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s)");
        }
    }
}
