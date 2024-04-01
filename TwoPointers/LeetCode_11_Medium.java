class Solution {
    public int maxArea(int[] height) {
        // Use 2ptr approach
        int l=0, r=height.length-1;
        int area;
        int result = 0;
        while(l <= r){
            area = (r-l) * Math.min(height[l], height[r]);
            result = Math.max(result, area);
            if(height[l] < height[r]){
                l++;
            } else {
                r--;
            }
        }

        return result;
    }
}
// Brute force
//     public int maxArea(int[] height) {
//         Brute force
//         int area;
//         int ans = 0;
//         for(int l=0; l<height.length-1; l++){
//             for(int r=l+1; r<height.length; r++){
//                 area = (r-l)* Math.min(height[l], height[r]);
//                 ans = Math.max(ans, area);
//             }
//         }
//         return ans;
        
//     }
