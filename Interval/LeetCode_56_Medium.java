/*
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> outputList = new ArrayList<>();
        //[[1,3],[2,6],[8,10],[15,18]]
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        outputList.add(intervals[0]);
        // [[1,3],]

        for(int index=1; index<intervals.length; index++){
            if(outputList.get(outputList.size()-1)[1] >= intervals[index][0] ){
                outputList.get(outputList.size()-1)[0] = Math.min(outputList.get(outputList.size()-1)[0], intervals[index][0]);
                outputList.get(outputList.size()-1)[1] = Math.max(outputList.get(outputList.size()-1)[1], intervals[index][1]);
            } else {
                outputList.add(intervals[index]);
            }
        }

        return outputList.toArray(new int[outputList.size()][]);
        
    }
}
