class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arrList = new ArrayList<>();
        
        // sort Array
        Arrays.sort(nums);


        for(int i=0; i<nums.length-2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int l = i+1;
                int r = nums.length-1;
                int target = -nums[i];
                while(l < r){
                    if(target == nums[l] + nums[r]){
                    arrList.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    while(l < r && nums[l] == nums[l+1]){
                        l++;
                    }
                    while(r > l && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;
                } else if(target > nums[l] + nums[r]){
                    l++;
                } else {
                    r--;
                }
                }
            }
        }


 

        return arrList;
        
    }
    // public List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> arrList = new ArrayList<>();
    //     Arrays.sort(nums);
    //     for(int i=0; i<nums.length-2; i++){
    //         if(i == 0 || nums[i] != nums[i-1]){
    //             for(int j=i+1; j<nums.length-1; j++){
    //                 if(j == i+1 || nums[j] != nums[j-1]){
    //                     for(int k=j+1; k<nums.length; k++){
    //                         if(k == j+1 || nums[k] != nums[k-1]){
    //                             if(nums[i] + nums[j] + nums[k] == 0){
    //                                 // Update the list
    //                                 arrList.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
    //                             }
    //                         }
    //                     }
    //                 }
    //             }

    //         }
    //     }

    //     return arrList;
        
    // }
}
