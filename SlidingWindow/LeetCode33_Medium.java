/*Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
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
