/*
Example 1:
Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
class Solution {
    public boolean checkIfBST(TreeNode root, long leftLimit, long rightLimit){ // 4, 5, i

        if(root == null){
            return true;
        }

        if(root.val <= leftLimit || root.val >= rightLimit){
            return false;
        }

        return checkIfBST(root.left, leftLimit, root.val) && checkIfBST(root.right, root.val, rightLimit);
    }
    public boolean isValidBST(TreeNode root) {
        // Visualize the tree
        if(root.left == null && root.right == null){
            return true;
        }

        return checkIfBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
}
