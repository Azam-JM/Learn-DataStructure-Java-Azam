class Solution {
    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        
        // Array to store the next greater elements
        long[] out = new long[n];
        
        // Stack to store elements of the array
        Stack<Long> st = new Stack<Long>();
        
        // Traverse the array from right to left
        for(int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack until it's empty or the top element is greater than the current element
            while(!st.empty() && st.peek() <= arr[i]) {
                st.pop();
            }
            // If the stack is empty, assign -1 to the output array, otherwise assign the top element of the stack
            out[i] = st.empty() ? -1 : st.peek();
            
            // Push the current element onto the stack
            st.push(arr[i]);
        }
        
        // Return the array containing the next greater elements
        return out;
    } 
}
