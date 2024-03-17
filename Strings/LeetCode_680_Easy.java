class Solution {
    // Method to check if a string is a valid palindrome after deleting at most one character
    public boolean validPalindrome(String s) {
        int ptr1 = 0; // Pointer to the start of the string
        int ptr2 = s.length() - 1; // Pointer to the end of the string
        int skip = 0; // Counter to keep track of deleted characters
        boolean palindrome = true; // Initialize a boolean variable to store whether the string is a valid palindrome
        
        // Iterate over the string using two pointers
        while (ptr1 < ptr2) {
            // If characters at both pointers are not equal
            if (s.charAt(ptr1) != s.charAt(ptr2)) {
                // Check if the string is a palindrome after deleting a character from either end
                return isPalindromeWithDeletion(s, ptr1 + 1, ptr2) || isPalindromeWithDeletion(s, ptr1, ptr2 - 1);
            } else {
                ptr1++; // Move the first pointer towards the end of the string
                ptr2--; // Move the second pointer towards the start of the string
            }
        }
        return true; // Return true if the string is a valid palindrome
    }

    // Helper method to check if a substring of the string is a palindrome
    public boolean isPalindromeWithDeletion(String s, int start, int end) {
        // Iterate over the substring using two pointers
        while (start < end) {
            // If characters at both pointers are not equal, the substring is not a palindrome
            if (s.charAt(start) != s.charAt(end)) {
                return false; // Return false
            } else {
                start++; // Move the start pointer towards the end of the substring
                end--; // Move the end pointer towards the start of the substring
            }
        }
        return true; // Return true if the substring is a palindrome
    }
}
