package medium;

import java.util.HashSet;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree thisClass = new LowestCommonAncestorOfABinaryTree();

        TreeNode res = thisClass.lowestCommonAncestor(null, null, null);
        System.out.println(res);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeInfo result = generateTreeInfo(root, p, q);
        return result.lca;
    }
    private TreeInfo generateTreeInfo(TreeNode root, TreeNode p, TreeNode q){
        if (root != null){
            TreeInfo leftTreeInfo = generateTreeInfo(root.left, p, q);
            TreeInfo rightTreeInfo = generateTreeInfo(root.right, p, q);
            if (leftTreeInfo.lca != null){
                return leftTreeInfo;
            }
            if (rightTreeInfo.lca != null){
                return rightTreeInfo;
            }
            if (root.val == p.val || root.val == q.val){
                TreeInfo newOne = new TreeInfo();
                if ( leftTreeInfo.numNodesFound == 1 || rightTreeInfo.numNodesFound == 1){
                    newOne.lca = root;
                }
                else{
                    newOne.numNodesFound = 1;
                }
                return newOne;
            }
            else{
                if (leftTreeInfo.numNodesFound == 1 && rightTreeInfo.numNodesFound == 1){
                    TreeInfo newOne = new TreeInfo();
                    newOne.lca = root;
                    return newOne;
                }
                else if (leftTreeInfo.numNodesFound == 1){
                    return leftTreeInfo;
                }
                else if (rightTreeInfo.numNodesFound == 1){
                    return rightTreeInfo;
                }
            }
        }
        return new TreeInfo();
    }
    class TreeInfo{
        TreeNode lca = null;
        int numNodesFound = 0;
    }
}