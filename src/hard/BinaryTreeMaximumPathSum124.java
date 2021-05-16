package hard;

import java.util.*;

public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum124 thisClass = new BinaryTreeMaximumPathSum124();
    }

    private int result;
    public int maxPathSum(TreeNode root) {
        this.result = root.val;
        maxPath(root);
        return this.result;
    }
    // return the max path that I could contribute
    private int maxPath(TreeNode node){

        int tmp = node.val;
        int lMaxPath = 0;
        if (node.left != null){
            lMaxPath = maxPath(node.left);
            tmp = Math.max(tmp, node.val + lMaxPath);
        }

        int rMaxPath = 0;
        if (node.right != null){
            rMaxPath = maxPath(node.right);
            tmp = Math.max(tmp, node.val + rMaxPath);
        }

        this.result = Math.max(this.result, tmp);

        if (node.left != null && node.right != null){
            this.result = Math.max(this.result, node.val + rMaxPath + lMaxPath);
        }

        return tmp;
    }
}