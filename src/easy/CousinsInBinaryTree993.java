package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree993 {
    public static void main(String[] args) {
        CousinsInBinaryTree993 thisClass = new CousinsInBinaryTree993();
        int[][]input = new int[0][0];


        System.out.println(" " + thisClass.isCousins(null, 1, 1));
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int xParent = 0;
        int yParent = 0;

        int xDepth = 0;
        int yDepth = 0;

        Queue<TreeNode> parentQ = new LinkedList<TreeNode>();
        parentQ.add(root);
        //can avoid second queue by adding a for loop within the while loop
        Queue<TreeNode> childrenQ = new LinkedList<TreeNode>();

        int currentD = 0;
        while(!parentQ.isEmpty()){
            TreeNode p = parentQ.poll();

            if (p.left != null){
                childrenQ.add(p.left);
                if (p.left.val == x){
                    xDepth = currentD +1;
                    xParent = p.val;
                }
                if (p.left.val == y){
                    yDepth = currentD +1;
                    yParent = p.val;
                }
            }
            if (p.right != null){
                childrenQ.add(p.right);
                if (p.right.val == x){
                    xDepth = currentD +1;
                    xParent = p.val;
                }
                if (p.right.val == y){
                    yDepth = currentD +1;
                    yParent = p.val;
                }
            }
            if (parentQ.isEmpty()){
                if (xDepth > 0 || yDepth >0){
                    if (xDepth == yDepth && xParent != yParent){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                currentD++;
                parentQ = childrenQ;
                childrenQ = new LinkedList<TreeNode>();
            }
        }

        return false;
    }
}