class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // update the map with value and index
        // int ind[] = {0,0};
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                // ind[0] = i;
                // ind[1] = map.get(target-nums[i]);
                return new int[] {i, map.get(target-nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
        
    }
}
