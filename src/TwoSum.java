import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TwoSum {
    public static void main(String[] args) {
//prompt the user to enter an integer array 'nums'
        /*
         * constraints
         * 2 <= nums.length <= 104
         * -109 <= nums[i] <= 109
         * -109 <= target <= 109
         */

        // Prompt the user to enter the elements of the array
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the size of the array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize the array
        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // Prompt the user to enter the target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        // Find the two sum solution
        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");


        }

        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            // Return an empty array if no solution is found
            return new int[] {};
        }
}
