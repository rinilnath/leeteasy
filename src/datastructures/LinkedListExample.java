package datastructures;

import java.util.LinkedList;

/**
 * SCENARIO: Music Playlist
 *
 * You're creating a music playlist where you frequently add songs at the beginning,
 * end, or middle. You also skip forward and backward through songs.
 * A LINKEDLIST is perfect when you need to add/remove items from anywhere quickly.
 *
 * WHAT IS A LINKEDLIST?
 * - Think of it like a chain of boxes
 * - Each box contains: the item + a link to the next box
 * - Easy to insert or remove items anywhere in the chain
 * - Just break and reconnect the links!
 *
 * ARRAYLIST vs LINKEDLIST:
 * - ArrayList: Fast to ACCESS items (like jumping to page 50 in a book)
 * - LinkedList: Fast to ADD/REMOVE items (like inserting pages in a book)
 */
public class LinkedListExample {

    public static void main(String[] args) {

        // Step 1: Create an empty playlist
        LinkedList<String> playlist = new LinkedList<>();

        System.out.println("=== MUSIC PLAYLIST ===\n");

        // Step 2: Add songs to the end of playlist
        playlist.add("Song A - Happy Vibes");
        playlist.add("Song B - Chill Beat");
        playlist.add("Song C - Rock Anthem");

        System.out.println("Initial Playlist:");
        displayPlaylist(playlist);

        // Step 3: Add a song at the BEGINNING (very fast with LinkedList!)
        playlist.addFirst("Song Z - Morning Energy");
        System.out.println("\nAfter adding at the beginning:");
        displayPlaylist(playlist);

        // Step 4: Add a song at the END
        playlist.addLast("Song Y - Night Calm");
        System.out.println("\nAfter adding at the end:");
        displayPlaylist(playlist);

        // Step 5: Add a song at a SPECIFIC position
        playlist.add(2, "Song X - Workout Mix");  // Insert at index 2
        System.out.println("\nAfter inserting at position 3:");
        displayPlaylist(playlist);

        // Step 6: Get the first and last songs (without removing them)
        System.out.println("\nNow Playing (first song): " + playlist.getFirst());
        System.out.println("Last song in queue: " + playlist.getLast());

        // Step 7: Remove songs
        // Remove from beginning (like playing and moving to next song)
        String played = playlist.removeFirst();
        System.out.println("\nJust played: " + played);
        System.out.println("Updated Playlist:");
        displayPlaylist(playlist);

        // Remove from end
        String removed = playlist.removeLast();
        System.out.println("\nRemoved from end: " + removed);
        displayPlaylist(playlist);

        // Remove specific song by name
        playlist.remove("Song B - Chill Beat");
        System.out.println("\nAfter removing 'Song B - Chill Beat':");
        displayPlaylist(playlist);

        // Step 8: Access a song at specific position
        String thirdSong = playlist.get(2);  // Get song at index 2
        System.out.println("\n3rd song in playlist: " + thirdSong);

        // Step 9: Check playlist info
        System.out.println("\nPlaylist size: " + playlist.size() + " songs");
        System.out.println("Is playlist empty? " + playlist.isEmpty());

        // Step 10: Simulate playing through the playlist
        System.out.println("\n--- PLAYING PLAYLIST ---");
        while (!playlist.isEmpty()) {
            String currentSong = playlist.removeFirst();  // Play and remove
            System.out.println("♪ Now playing: " + currentSong);
        }

        System.out.println("\nPlaylist is now empty: " + playlist.isEmpty());

        /**
         * KEY POINTS ABOUT LINKEDLIST:
         * ✓ Fast add/remove at beginning or end - O(1) time
         * ✓ Fast add/remove in middle - just reconnect links
         * ✓ Good when you don't know the size beforehand
         * ✗ Slower to access by index - must traverse the chain
         * ✗ Uses more memory - stores links between items
         *
         * SPECIAL METHODS (not in ArrayList):
         * - addFirst(item) - adds to the beginning
         * - addLast(item) - adds to the end
         * - getFirst() - gets first item without removing
         * - getLast() - gets last item without removing
         * - removeFirst() - removes and returns first item
         * - removeLast() - removes and returns last item
         *
         * WHEN TO USE LINKEDLIST:
         * - Frequent adding/removing at beginning or end
         * - Frequent adding/removing in the middle
         * - You don't need fast access by index
         * - Implementing queues or stacks
         */
    }

    /**
     * Helper method to display all songs in the playlist
     * This keeps our main code cleaner!
     */
    private static void displayPlaylist(LinkedList<String> playlist) {
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }
}
