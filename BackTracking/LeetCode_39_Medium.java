class Solution {
    public void combinationSumRecursion(int[] candidates, int target, List<List<Integer>> resultList, List<Integer> currentList, int index){
        if(target == 0){
            resultList.add(new ArrayList<>(currentList));
        } else if(target < 0 || index >= candidates.length){
            return;
        } else {
            currentList.add(candidates[index]);
            combinationSumRecursion(candidates, target - candidates[index], resultList, currentList, index);

            currentList.remove(currentList.get(currentList.size()-1));
            combinationSumRecursion(candidates, target, resultList, currentList, index+1);
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        combinationSumRecursion(candidates, target, resultList, currentList, 0);
        return resultList;
    }
}
