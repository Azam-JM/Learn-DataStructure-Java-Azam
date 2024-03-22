class Solution {
    // Function to find the maximum element in each subarray of size k
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        Deque<Integer> q = new ArrayDeque<>(); // Deque to store indices of elements
        ArrayList<Integer> list = new ArrayList<>(); // List to store maximum elements in subarrays

        // Loop through each element in the array
        for (int i = 0; i < n; i++) {
            // Remove all elements from the deque that are smaller than the current element
            while (q.size() > 0 && arr[i] >= arr[q.getLast()]) {
                q.removeLast();
            }
            q.addLast(i); // Add the current index to the deque
            
            // Remove the index from the front of the deque if it's outside the current window
            if (q.getFirst() <= i - k) {
                q.removeFirst();
            }
            
            // If the window size is greater than or equal to k, store the maximum element
            if (i >= k - 1) {
                list.add(arr[q.getFirst()]); // Store the maximum element for the current subarray
            }
        }
        return list; // Return the list containing maximum elements in each subarray
    }
}
