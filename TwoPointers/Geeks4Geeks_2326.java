class Solution {
    // Method to calculate the sum of elements in an array
    int sum(int arr[], int n) {
        int sum=0; // Initialize the sum variable to 0
        // Traverse the array and add each element to the sum
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        // Return the sum of the elements in the array
        return sum;
    }
}