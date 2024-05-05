/*
Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
*/

// Inorder traversal - Recursive
class Solution {
    public void inorderTraversal(TreeNode root, List<Integer> inorderTree){
        if(root == null){
            return;
        }
        inorderTraversal(root.left, inorderTree);
        inorderTree.add(root.val);
        inorderTraversal(root.right, inorderTree);        
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderTree = new ArrayList<>();
        inorderTraversal(root, inorderTree);
        return inorderTree.get(k-1);
    }
}

// Inorder Traversal - Iterative 
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode currentNode = root; // 5
        while(!stack.isEmpty() || currentNode != null){
            while(currentNode != null){ 
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop(); // 3
            count++; // 3
            if(count == k){ // 3 == 3
                return currentNode.val;
            }
            currentNode = currentNode.right;
        }
        return -1;
    }
}
