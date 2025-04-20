import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        // prompt to enter an integer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // check if the number is a palindrome
        if (isPalindrome(number)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean isPalindrome(int number) {
        // Convert the number to a string
        String str = Integer.toString(number);

        // Initialize pointers for the start and end of the string
        int start = 0;
        int end = str.length() - 1;

        // Check if the characters at the start and end are equal
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false; // Not a palindrome
            }
            start++;
            end--;
        }

        return true; // Is a palindrome
    }
}
