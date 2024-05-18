class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // Visualize
        // sort it
        // use 2-pointers
        // if sum if greater than target, move right --
        // equal left ++, right --
        int left = 0; // 0
        int right = people.length-1; // 1
        int boatsRequired = 0;

        // Sort it
        Arrays.sort(people);

        while(left <= right){ // 1 <= 1
            if(limit >= people[left] + people[right]){ // 3 >= 2
                left++; // 1
                right--; // 1
            } else {
                right--; // 2
            }
            boatsRequired++; // 1
        }

        return boatsRequired;
        
    }
}
