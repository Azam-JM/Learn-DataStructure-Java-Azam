/*
Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
*/

class Solution {
    public int findMin(int[] nums) {
        // Draw graphical representation to visualize the scenario
        // [3,4,5,1,2]
        int minNumber = nums[0];
        int leftIndex = 0;
        int rightIndex = nums.length-1;

        while(leftIndex <= rightIndex){
            int midIndex = (leftIndex + rightIndex)/2;
            minNumber = Math.min(nums[midIndex], minNumber);

            if(nums[leftIndex] < nums[rightIndex]){
                minNumber = Math.min(minNumber, nums[leftIndex]);
                break;
            }

            if(nums[midIndex] >= nums[leftIndex]){
                leftIndex = midIndex+1;
            } else {
                rightIndex = midIndex-1;
            }
        }

        return minNumber;
        
    }
}
