/*
Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
*/
class Solution {
    public int jump(int[] nums) {
        // Visualize the problem
        // at each index, mark the fartest jump
        // currentJump = 0
        // if index == current jump => the previous jump is done
        // update current = farthest
        // run till n-1

        int farthestJump = 0;
        int currentJump = 0;
        int minimumJump = 0;

        for(int index=0; index < nums.length-1; index++){ //
            farthestJump = Math.max(farthestJump, index + nums[index]); //4
            if(index == currentJump){ // 2 == 2
                currentJump = farthestJump; // 4
                minimumJump++; // 2
            }
        }
        return minimumJump;
        
    }
}
