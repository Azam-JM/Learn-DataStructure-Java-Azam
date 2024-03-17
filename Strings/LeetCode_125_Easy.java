import java.util.Scanner;

class Solution {
    // Method to check if a given string is a palindrome
    public boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^a-zA-Z0-9]", ""); // Remove non-alphanumeric characters using regular expression
        s = s.toLowerCase(); // Convert the string to lowercase

        // Logic to verify palindrome
        int ptr1 = 0; // Pointer to the first character of the string
        int ptr2 = s.length() - 1; // Pointer to the last character of the string
        boolean palindrome = true; // Initialize a boolean variable to store whether the string is a palindrome or not
        
        // Iterate over the string using two pointers
        while (ptr1 < ptr2) {
            // If characters at both pointers are not equal, the string is not a palindrome
            if (s.charAt(ptr1) != s.charAt(ptr2)) {
                palindrome = false; // Set palindrome flag to false
                break; // Exit the loop
            }
            ptr1++; // Move the first pointer towards the end of the string
            ptr2--; // Move the second pointer towards the start of the string
        }
        return palindrome; // Return whether the string is a palindrome or not
    }
}
