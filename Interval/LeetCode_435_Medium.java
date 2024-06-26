/*
Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        int lastElement = intervals[0][1];
        int count = 0;

        for(int index=1; index < intervals.length; index++){
            if(intervals[index][0] < lastElement){
                lastElement = Math.min(lastElement, intervals[index][1]);
                count++;
            } else {
                lastElement = intervals[index][1]; // 4
            }
        }

        return count;
        
    }
}
