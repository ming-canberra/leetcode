package medium;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal889 {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal889 thisClass = new ConstructBinaryTreeFromPreorderAndPostorderTraversal889();
    }


    private HashMap<Integer, Integer> vToIPost = new HashMap<>();

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        for (int i = 0; i < post.length; i++){
            vToIPost.put(post[i], i);
        }

        TreeNode root = build(pre, post, vToIPost, 0, 0, post.length);

        return root;
    }

    private TreeNode build(int[] pre, int[] post, HashMap<Integer, Integer> vToIPost, int rIndexPre, int start, int end){
        if ((end > start) && (rIndexPre < pre.length && rIndexPre >= 0)){
            TreeNode root = new TreeNode(pre[rIndexPre]);
            rIndexPre++;

            if (start + 1 == end){
                return root;
            }

            int nextRootIndex = vToIPost.get(pre[rIndexPre]);

            TreeNode l = build(pre, post, vToIPost, rIndexPre, start, nextRootIndex + 1);

            TreeNode r = build(pre, post, vToIPost, rIndexPre + nextRootIndex + 1 - start, nextRootIndex + 1, end - 1);

            root.left = l;
            root.right = r;

            return root;
        }
        else{
            return null;
        }
    }

    class Solution {
        Map<Integer, Integer> postValueToIndexMap;
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            postValueToIndexMap = new HashMap<>();
            for (int i = 0; i < post.length; i++){
                postValueToIndexMap.put(post[i], i);
            }
            return helper(pre, post, 0, pre.length);
        }
        private TreeNode helper(int[] pre, int[] post, int preStart, int length){
            TreeNode root = new TreeNode(pre[preStart]);
            if (length == 1){
                return root;
            }
            else{
                int leftRightEndIndex = postValueToIndexMap.get(pre[preStart + 1]);
                int rootIndex = postValueToIndexMap.get(pre[preStart]);
                if (leftRightEndIndex + 1 == rootIndex){
                    // no right tree
                    root.left = helper(pre, post, preStart + 1, length - 1);
                }
                else{
                    // both left and right tree exist
                    int rightTreeLength = rootIndex - leftRightEndIndex - 1;
                    root.left = helper(pre, post, preStart + 1, length - 1 - rightTreeLength);
                    root.right = helper(pre, post, preStart + 1 + length - 1 - rightTreeLength, rightTreeLength);
                }
                return root;
            }
        }
    }
}