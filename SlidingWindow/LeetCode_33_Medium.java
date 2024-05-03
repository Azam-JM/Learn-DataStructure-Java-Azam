/*
Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
*/
class Solution {
    public int search(int[] nums, int target) {
        // Visualize it with graph for better clarity
        // [4,5,6,7,0,1,2]
        int leftIndex = 0;
        int rightIndex = nums.length-1; 
        while(leftIndex <= rightIndex){
            int midIndex = (leftIndex + rightIndex)/2;
            if(nums[midIndex] == target){
                return midIndex;
            }

            // Check if mid in left sorted array
            if(nums[midIndex] >= nums[leftIndex]){
                if(target > nums[midIndex] || target < nums[leftIndex]){
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            } else {
                if(target < nums[midIndex] || target > nums[rightIndex]){
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            }
        }

        return -1;
        
    }
}
