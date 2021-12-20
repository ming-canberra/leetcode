package medium;

import java.util.*;

public class Medium0333LargestBSTSubtree {
    class Solution {
        int result = 1;
        public int largestBSTSubtree(TreeNode root) {
            if (root == null){
                return 0;
            }
            traverse(root);
            return result;
        }
        //0th as min element of the tree with node as the root, 1th as max element, 2th as possible result
        private int[] traverse(TreeNode node){
            if (node == null){
                return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
            }
            int[] lValue = traverse(node.left);
            int[] rValue = traverse(node.right);
            if (lValue[2] < 0 || rValue[2] < 0){
                return new int[]{0, 0, -1};
            }
            if ( node.val > lValue[1] && node.val < rValue[0]){
                result = Math.max(result, 1 + lValue[2] + rValue[2]);
                return new int[]{ Math.min(lValue[0], node.val), Math.max(rValue[1], node.val), 1 + lValue[2] + rValue[2]} ;
            }
            else{
                return new int[]{0, 0, -1};
            }
        }
    }
}