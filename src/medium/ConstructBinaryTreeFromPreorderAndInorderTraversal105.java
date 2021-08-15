package medium;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal105 thisClass = new ConstructBinaryTreeFromPreorderAndInorderTraversal105();

        TreeNode res = thisClass.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(res);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode result = buildBranches(preorder, inorder, 0, preorder.length);
        return result;
    }

    private TreeNode buildBranches(int[] preorder, int[] inorder, int start, int end) // subTree excludes index end
    {
        if (start < preorder.length && start < end) {
            TreeNode treeNode = new TreeNode(preorder[start]);
            int curIndex = start;

            while (inorder[curIndex] != preorder[start]) {
                curIndex++;
                if (curIndex == end){
                    break;
                }
            }

            treeNode.left = buildBranches(preorder, inorder, start + 1, Math.min(curIndex + 1, end));
            treeNode.right = buildBranches(preorder, inorder, curIndex + 1, end);

            return treeNode;
        }
        return null;
    }

    class Solution {
        private Map<Integer, Integer> inorderValueToIndex;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderValueToIndex = new HashMap<>();
            for (int i = 0; i < inorder.length; i++){
                inorderValueToIndex.put(inorder[i], i);
            }
            return helper(preorder, inorder, 0, inorder.length);
        }
        private TreeNode helper(int[] preorder, int[] inorder, int preStartIndex, int length){
            if (preStartIndex >= 0 && preStartIndex < preorder.length && length > 0){
                TreeNode root = new TreeNode(preorder[preStartIndex]);
                if (length > 1){
                    int rootIndex = inorderValueToIndex.get(root.val);
                    int leftOrRightRootIndex = inorderValueToIndex.get(preorder[preStartIndex + 1]);
                    //no left tree, only right tree
                    if (leftOrRightRootIndex > rootIndex){
                        root.right = helper(preorder, inorder, preStartIndex + 1, length - 1);
                    }
                    // both left and right tree to be located
                    else{
                        int leftTreeEndIndex = 0;
                        for (int i = preStartIndex + 1; i < preStartIndex + length; i++){
                            if (inorderValueToIndex.get(preorder[i]) < rootIndex){
                                leftTreeEndIndex = i;
                            }
                        }
                        root.left = helper(preorder, inorder, preStartIndex + 1, leftTreeEndIndex - preStartIndex);
                        root.right = helper(preorder, inorder, leftTreeEndIndex + 1, length - 1 - leftTreeEndIndex + preStartIndex);
                    }
                }
                return root;
            }
            else{
                return null;
            }
        }
    }

    class SolutionOptimal {
        private int preorderRootIndex = 0;
        private Map<Integer, Integer> inorderValueIndexMap;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderValueIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++){
                inorderValueIndexMap.put(inorder[i], i);
            }
            return helper(preorder, inorder, 0, inorder.length - 1);
        }
        private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
            if (start <= end){
                TreeNode root = new TreeNode(preorder[preorderRootIndex++]);
                int curRootIndexInorder = inorderValueIndexMap.get(root.val);
                root.left = helper(preorder, inorder, start, curRootIndexInorder - 1);
                root.right = helper(preorder, inorder, curRootIndexInorder + 1, end);
                return root;
            }
            else{
                return null;
            }
        }
    }

    class Solution1 {
        Map<Integer, Integer> valueToIndexInorder = new HashMap<>();
        int preorderIdx = 0;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++){
                valueToIndexInorder.put(inorder[i], i);
            }
            return helper(preorder, inorder, 0, inorder.length - 1);
        }
        private TreeNode helper(int[] preorder, int[] inorder, int inorderStart, int inorderEnd) {
            if (preorderIdx < preorder.length && inorderStart <= inorderEnd){
                TreeNode root = new TreeNode(preorder[preorderIdx]);
                preorderIdx++;
                int rootIndexInorder = valueToIndexInorder.get(root.val);
                root.left = helper(preorder, inorder, inorderStart, rootIndexInorder - 1);
                root.right = helper(preorder, inorder, rootIndexInorder + 1, inorderEnd);
                return root;
            }
            return null;
        }
    }
}