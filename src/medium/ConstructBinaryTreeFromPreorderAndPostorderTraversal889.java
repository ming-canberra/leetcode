package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

            if (rIndexPre >= pre.length){
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
}