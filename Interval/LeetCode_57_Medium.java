/*
Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Visualize
        // cases
        // If newInterval comes after first -> Insert interval
        // new interval comes before interval -> insert new interval first - then interval - set the new interval to null
        // else overlap
        List<int []> outputInterval = new ArrayList<>();

        for(int[] interval: intervals){
            if(newInterval == null || newInterval[0] > interval[1]){
                outputInterval.add(interval);
            } else if(newInterval[1] < interval[0]){
                outputInterval.add(newInterval);
                outputInterval.add(interval);
                newInterval = null;;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if(newInterval != null){
            outputInterval.add(newInterval);
        }

        return outputInterval.toArray(new int[outputInterval.size()][]);

        
    }
}
