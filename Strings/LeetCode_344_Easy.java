// Iterative approach to reverse a string
class Solution1 {
    // Method to reverse a string using two-pointer technique
    public void reverseString(char[] s) {
        // Initialize left pointer to the start of the array and right pointer to the end of the array
        int left = 0;
        int right = s.length - 1;
        
        // Swap characters at left and right positions until left pointer surpasses right pointer
        while (left < right){
            char temp = s[left]; // Store character at left position in a temporary variable
            s[left] = s[right]; // Replace character at left position with character at right position
            s[right] = temp; // Replace character at right position with character stored in temporary variable
            
            left++; // Move left pointer towards the right
            right--; // Move right pointer towards the left
        }
    }
}

// Recursive approach to reverse a string
class Solution2 {
    // Method to reverse a string recursively
    public void reverseString(char[] s) {
        swap(s, 0, s.length - 1); // Call the swap method to reverse the string
        System.out.println(s); // Print the reversed string
    }

    // Recursive method to swap characters at specified positions
    public void swap(char[] s, int l, int r){
        // Base case: if left pointer is greater than or equal to right pointer, return
        if(l >= r){
            return;
        }
        // Swap characters at left and right positions
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        // Recursively call swap method with updated left and right pointers
        swap(s, l + 1, r - 1);
    }
}
