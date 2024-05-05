/* Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1] */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Visualize it
        // Root from preOrder
        // Find the root index in inOrder
        // Iterate 1 -> Mid+1 for preOrder left
        // 0 - Mid + 1 -> InOrder
        //  Right -> Mid + 1 to end -> PreOrder
        // Right -> Mid + 1 to end -> Inorder
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        
        int mid = 0;
        for(int index=0; index<inorder.length; index++){
            if(root.val == inorder[index]){
                mid = index;
            }
        }

        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, mid+1),
            Arrays.copyOfRange(inorder, 0, mid+1)
        );

        root.right = buildTree(
            Arrays.copyOfRange(preorder, mid+1, preorder.length),
            Arrays.copyOfRange(inorder, mid+1, inorder.length)
        );

        return root;
        
    }
}
