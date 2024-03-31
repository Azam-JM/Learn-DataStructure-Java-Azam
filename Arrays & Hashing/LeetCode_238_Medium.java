class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];
        int prodPref[] = new int[nums.length];
        int prodSuff[] = new int[nums.length];


        // Calculate the output using prefixProd
        ans[0] = 1;
        for(int i=1; i<nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        // Calculate postProd and update the output
        int post = 1;
        for(int i=nums.length-2; i>=0; i--){
            post = post * nums[i+1];
            ans[i] = ans[i] * post;
        }

        return ans;

    }
}
