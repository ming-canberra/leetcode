package easy;

import java.util.ArrayList;
import java.util.List;

public class DiameterofBinaryTree543 {
    public static void main(String[] args) {
        DiameterofBinaryTree543 thisClass = new DiameterofBinaryTree543();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left=node2;
        node1.right=node3;
        node2.left = node4;
        node2.right = node5;


        System.out.println(thisClass.diameterOfBinaryTree(node1));
    }

    int _toReturn = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        depth(root);

        return _toReturn;
    }

    private int depth(TreeNode root){
        if (root == null || (root.left == null && root.right == null))
            return 0;
        else{
            int diameterRoot = 0;

            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);

            if (root.left != null){
                diameterRoot += leftDepth +1;
            }
            if (root.right != null){
                diameterRoot += rightDepth +1;
            }

            _toReturn = Math.max(diameterRoot, _toReturn);


            return Math.max(leftDepth, rightDepth) +1;
        }
    }


}