class Solution {
    public int longestConsecutive(int[] nums) {
        
        // Create Set
        HashSet<Integer> set = new HashSet<>();

        // update the hashset
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        // Check for sequence by verifying before and after
        int max = 0;
        for(int i=0; i< nums.length; i++){
            int count = 0;
            while(!set.contains(nums[i]-1) && set.contains(count + nums[i]+1)){
                count++;
                max = Math.max(max, count);
            }
        }
        return nums.length!=0 ? max+1 : max;
    }
}
