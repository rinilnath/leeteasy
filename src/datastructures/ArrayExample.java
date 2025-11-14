package datastructures;

/**
 * SCENARIO: Teacher Managing Student Grades
 *
 * A teacher has 5 students and wants to store their test scores.
 * An ARRAY is perfect when you know the exact number of items beforehand
 * and that number won't change.
 *
 * WHAT IS AN ARRAY?
 * - Think of it like a row of boxes, numbered 0, 1, 2, 3, 4...
 * - Each box can hold one item
 * - The size is FIXED - you can't add more boxes later
 * - Very fast to access any item if you know its position (index)
 */
public class ArrayExample {

    public static void main(String[] args) {

        // Step 1: Create an array to store 5 student grades
        // This creates 5 empty boxes, numbered 0 to 4
        int[] grades = new int[5];

        // Step 2: Store grades for each student
        // Array indices start at 0 (not 1!)
        grades[0] = 85;  // First student scored 85
        grades[1] = 92;  // Second student scored 92
        grades[2] = 78;  // Third student scored 78
        grades[3] = 95;  // Fourth student scored 95
        grades[4] = 88;  // Fifth student scored 88

        // Alternative way: Create and initialize array in one line
        // int[] grades = {85, 92, 78, 95, 88};

        System.out.println("=== STUDENT GRADES ===\n");

        // Step 3: Display all grades
        // We use a loop to go through each box (index 0 to 4)
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + grades[i]);
        }

        // Step 4: Calculate average grade
        int sum = 0;  // Variable to store the total

        // Add up all the grades
        for (int i = 0; i < grades.length; i++) {
            sum = sum + grades[i];  // Add each grade to sum
        }

        // Calculate average by dividing total by number of students
        double average = (double) sum / grades.length;
        System.out.println("\nClass Average: " + average);

        // Step 5: Find the highest grade
        int highest = grades[0];  // Assume first grade is highest

        // Check each grade to see if it's higher
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > highest) {
                highest = grades[i];  // Found a higher grade!
            }
        }

        System.out.println("Highest Grade: " + highest);

        // Step 6: Access a specific grade
        System.out.println("\nStudent 3's grade: " + grades[2]);  // Remember: index 2 is the 3rd student!

        /**
         * KEY POINTS ABOUT ARRAYS:
         * ✓ Fixed size - can't grow or shrink
         * ✓ Fast access - can jump to any position instantly
         * ✓ Same type - all items must be the same type (all integers, all strings, etc.)
         * ✓ Index starts at 0 - first item is at position 0, not 1
         *
         * WHEN TO USE ARRAYS:
         * - You know exactly how many items you need
         * - The size won't change
         * - You need fast access to any item
         */
    }
}
