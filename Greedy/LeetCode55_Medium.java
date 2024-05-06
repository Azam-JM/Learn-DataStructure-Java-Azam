/*
Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
*/
class Solution {
    public boolean canJump(int[] nums) {
        // Visualize the use case
        // Identify the approach to use
        // Shortlist algorithm -> Greedy (start from the last index)
        int targetIndex = nums.length-1;
        for(int index=nums.length-2; index >= 0; index--){
            if(nums[index] + index >= targetIndex){
                targetIndex = index;
            }
        }

        if(targetIndex == 0){
            return true;
        }
        return false;
        
    }
}
