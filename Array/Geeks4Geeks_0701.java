class Solution {
    // Method to check if an array is sorted in non-decreasing order
    boolean arraySortedOrNot(int[] arr, int n) {
        // If the array is empty or has only one element, it is considered sorted
        if(arr.length == 0 || arr.length == 1){
            return true;
        }
        // Traverse the array and check if each element is greater than or equal to the previous element
        for(int i=1; i< arr.length; i++){
            if(arr[i] < arr[i-1]){ // If any element is smaller than the previous one, the array is not sorted
                return false;
            }
        }
        // If all elements are in non-decreasing order, the array is sorted
        return true;
    }
}
