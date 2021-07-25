package medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
    class Solution {
        private Map<Integer, Integer> inorderValueIndexMap;
        private int postorderIndex;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            inorderValueIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++){
                inorderValueIndexMap.put(inorder[i], i);
            }
            postorderIndex = inorder.length - 1;
            return helper(inorder, postorder, 0, inorder.length - 1);
        }
        private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
            if (start <= end){
                TreeNode root = new TreeNode(postorder[postorderIndex--]);
                int rootIndexInorder = inorderValueIndexMap.get(root.val);
                root.right = helper(inorder, postorder, rootIndexInorder + 1, end);
                root.left = helper(inorder, postorder, start, rootIndexInorder - 1);
                return root;
            }
            else{
                return null;
            }
        }
    }
}