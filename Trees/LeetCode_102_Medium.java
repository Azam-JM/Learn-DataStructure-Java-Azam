/*

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 1. One queue to run through BFS
        // 2. One ArrayList of type ArrayList for results
        // Till queue is empty -> run for the element count in queue
        // End of elements count update the answer

        if(root == null){
            return new ArrayList<>();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> levelOrderNodes = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){ // [3]
            List<Integer> rootList = new ArrayList<>();
            int queueSize = queue.size();
            for(int queueCount=0; queueCount<queueSize; queueCount++){
                TreeNode node = queue.pollFirst(); // 3
                rootList.add(node.val); //[3]
                if(node.left != null){ 
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            levelOrderNodes.add(rootList); //[[3], [9,20], [15,7]]

        }
        return levelOrderNodes;


        
    }
}
