class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while(l <= r){
            if(target == numbers[l] + numbers[r]){
                return new int[] {l+1, r+1};
            } else if(target > numbers[l] + numbers[r]){
                l++;
            } else {
                r--;
            }
        }
        return new int[] {};
        
    }
}
