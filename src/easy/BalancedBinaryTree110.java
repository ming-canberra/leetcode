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
}