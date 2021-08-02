package easy;

public class BalancedBinaryTree110 {
    public static void main(String[] args) {
        BalancedBinaryTree110 thisClass = new BalancedBinaryTree110();
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        TreeInfo t = getTreeInfo(root);
        return t.balanced;
    }
    private TreeInfo getTreeInfo(TreeNode root){
        if (root == null){
            return new TreeInfo(0, true);
        }
        TreeInfo lInfo = getTreeInfo(root.left);
        TreeInfo rInfo = getTreeInfo(root.right);

        if (!lInfo.balanced){
            return lInfo;
        }

        if (!rInfo.balanced){
            return rInfo;
        }

        if (Math.abs(lInfo.height - rInfo.height) > 1){
            return new TreeInfo(1, false);
        }

        return new TreeInfo(1 + Math.max(lInfo.height, rInfo.height), true);
    }
    private class TreeInfo{
        int height = 0;
        boolean balanced = true;
        TreeInfo(int h, boolean b)
        {
            this.height = h;
            this.balanced = b;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null){
                return true;
            }

            if (isBalanced(root.left)){
                if (isBalanced(root.right)){
                    int lHeight = getHeight(root.left);
                    int rHeight = getHeight(root.right);
                    return Math.abs(lHeight - rHeight) <= 1;
                }
            }
            return false;
        }
        private int getHeight(TreeNode root){
            if (root == null){
                return 0;
            }
            int lHeight = getHeight(root.left);
            int rHeight = getHeight(root.right);
            return Math.max(lHeight, rHeight) + 1;
        }
    }
}