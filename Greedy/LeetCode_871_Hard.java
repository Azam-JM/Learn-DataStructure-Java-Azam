/*
Example 1:
Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.
Example 2:

Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can not reach the target (or even the first gas station).
Example 3:

Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation: We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.
*/

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // Visualize the problem using notepad
        if(startFuel >= target){ // 10 >= 100
            return 0;
        }

        int refuel = 0;
        int totalDistance = startFuel; // 25
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int index=0;
        while(totalDistance < target){ // 25 < 100
            if(index < stations.length && stations[index][0] <= totalDistance){ // 1 < 3 && 25 < 100
                maxHeap.add(stations[index][1]); // 25
                index++;
            } else if(maxHeap.isEmpty()){
                return -1;
            } else {
                totalDistance = totalDistance + maxHeap.poll();
                refuel++; // 1
            }

        }

        return refuel;
        
    }
}
