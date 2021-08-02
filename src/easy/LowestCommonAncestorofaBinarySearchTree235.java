package easy;

import java.util.*;

public class LowestCommonAncestorofaBinarySearchTree235 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val < p.val && root.val < q.val){
                return lowestCommonAncestor(root.right, p, q);
            }
            else if (root.val > p.val && root.val > q.val){
                return lowestCommonAncestor(root.left, p, q);
            }
            else{
                return root;
            }
        }
    }
}