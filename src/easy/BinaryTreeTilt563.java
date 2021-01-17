package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTilt563 {
    public static void main(String[] args) {
        BinaryTreeTilt563 thisClass = new BinaryTreeTilt563();

        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        //TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        //TreeNode node7 = new TreeNode(7);

        node3.left=node9;
        //node3.right=node20;
        node9.left = node15;
        //node20.right = node7;


        System.out.println(thisClass.findTilt(node3));
    }

    int totalTilt = 0;

    private int sumAllNodes(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftsum = sumAllNodes(root.left);
        int rightsum = sumAllNodes(root.right);
        totalTilt += Math.abs(leftsum - rightsum);

        return root.val + leftsum + rightsum;
    }

    public int findTilt(TreeNode root) {

        sumAllNodes(root);

        return totalTilt;
    }


}