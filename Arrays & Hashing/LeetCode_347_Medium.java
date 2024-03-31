class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create Hashmap to count the occurances
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Create Array of type List to map the frequency
        // Traverse through the map keys
        List<Integer> arr[] = new List[nums.length + 1];
        for(int num: map.keySet()){
            int value = map.get(num);
            if(arr[value] == null){
                // Create new arraylist
                arr[value] = new ArrayList<>();
            }
            arr[value].add(num);
        }

        // System.out.println(arr);

        // Traverse in reverse direction to get k values
        List<Integer> result = new ArrayList<>();
        for(int i=arr.length-1; i>0 && result.size() < k; i--){
            if(arr[i] != null){
                for(int j=0; j<arr[i].size() && result.size() < k; j++){
                    if(result.size() < k){
                        result.add(arr[i].get(j));
                    }
                }
            }
        }


        // Convert arrlist to array
        int answer[] = new int[result.size()];
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
