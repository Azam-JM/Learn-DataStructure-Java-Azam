class Solution {
    // Function to find the maximum element in each sliding window of size k
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; // Length of the input array
        Deque<Integer> q = new ArrayDeque<>(); // Deque to store indices of elements
        int[] arr = new int[n - k + 1]; // Array to store maximum elements in sliding windows
        int start = 0; // Start index for the result array

        // Loop through each element in the array
        for (int i = 0; i < n; ++i) {

            // Remove all elements from the deque that are smaller than the current element
            while (q.size() > 0 && nums[i] >= nums[q.getLast()]) {
                q.removeLast();
            }
            q.addLast(i); // Add the current index to the deque

            // Remove the index from the front of the deque if it's outside the current window
            if (q.getFirst() <= i - k) {
                q.removeFirst();
            }

            // If the window size is greater than or equal to k, store the maximum element
            if (i >= k - 1) {
                arr[start] = nums[q.getFirst()]; // Store the maximum element for the current window
                start++; // Move to the next position in the result array
            }
        }

        return arr; // Return the array containing maximum elements in each sliding window
    }
}