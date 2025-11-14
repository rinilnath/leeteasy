package datastructures;

import java.util.ArrayList;

/**
 * SCENARIO: Online Shopping Cart
 *
 * You're shopping online and adding items to your cart.
 * You don't know how many items you'll buy - maybe 2, maybe 10!
 * An ARRAYLIST is perfect because it can grow and shrink as needed.
 *
 * WHAT IS AN ARRAYLIST?
 * - Like an array, but FLEXIBLE in size
 * - Can add or remove items anytime
 * - Automatically grows when you add items
 * - Maintains order (first item added stays first)
 */
public class ArrayListExample {

    public static void main(String[] args) {

        // Step 1: Create an empty shopping cart
        // <String> means this ArrayList will hold text (product names)
        ArrayList<String> cart = new ArrayList<>();

        System.out.println("=== SHOPPING CART ===\n");

        // Step 2: Add items to the cart
        // .add() puts a new item at the end
        cart.add("Laptop");
        cart.add("Mouse");
        cart.add("Keyboard");

        System.out.println("Items in cart: " + cart.size());  // size() tells us how many items
        System.out.println("Cart contents: " + cart);

        // Step 3: Add more items (ArrayList grows automatically!)
        cart.add("Monitor");
        cart.add("USB Cable");

        System.out.println("\nAfter adding more items:");
        System.out.println("Items in cart: " + cart.size());

        // Step 4: Display all items one by one
        System.out.println("\nYour Cart:");
        for (int i = 0; i < cart.size(); i++) {
            // .get(i) retrieves the item at position i
            System.out.println((i + 1) + ". " + cart.get(i));
        }

        // Alternative way to loop (enhanced for loop - easier!)
        System.out.println("\nUsing enhanced for loop:");
        for (String item : cart) {
            System.out.println("- " + item);
        }

        // Step 5: Check if an item exists
        String searchItem = "Mouse";
        if (cart.contains(searchItem)) {
            System.out.println("\n✓ " + searchItem + " is in your cart");
        } else {
            System.out.println("\n✗ " + searchItem + " is NOT in your cart");
        }

        // Step 6: Remove an item (changed your mind!)
        String removedItem = cart.remove(1);  // Remove item at index 1 (Mouse)
        System.out.println("\nRemoved: " + removedItem);
        System.out.println("Cart after removal: " + cart);

        // You can also remove by item name
        cart.remove("USB Cable");  // Removes first occurrence of "USB Cable"
        System.out.println("After removing USB Cable: " + cart);

        // Step 7: Get a specific item
        String firstItem = cart.get(0);  // Get first item
        System.out.println("\nFirst item in cart: " + firstItem);

        // Step 8: Update an item
        cart.set(0, "Gaming Laptop");  // Replace item at index 0
        System.out.println("After updating first item: " + cart);

        // Step 9: Check if cart is empty
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty!");
        } else {
            System.out.println("\nYou have " + cart.size() + " items to checkout");
        }

        // Step 10: Clear entire cart
        cart.clear();
        System.out.println("\nAfter clearing cart: " + cart);
        System.out.println("Is cart empty? " + cart.isEmpty());

        /**
         * KEY POINTS ABOUT ARRAYLIST:
         * ✓ Dynamic size - grows and shrinks automatically
         * ✓ Maintains order - items stay in the order you added them
         * ✓ Allows duplicates - can have the same item multiple times
         * ✓ Fast access by index - like arrays
         * ✗ Slower when adding/removing from middle
         *
         * COMMON METHODS:
         * - add(item) - adds to the end
         * - add(index, item) - adds at specific position
         * - get(index) - retrieves item at position
         * - set(index, item) - replaces item at position
         * - remove(index) - removes item at position
         * - remove(item) - removes first occurrence of item
         * - size() - returns number of items
         * - contains(item) - checks if item exists
         * - clear() - removes all items
         * - isEmpty() - checks if list is empty
         *
         * WHEN TO USE ARRAYLIST:
         * - You don't know how many items you'll have
         * - You need to add/remove items frequently
         * - You want to access items by position
         */
    }
}
