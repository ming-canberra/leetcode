package medium;

public class FindDistanceInABinaryTree1740 {
    public static void main(String[] args) {
        FindDistanceInABinaryTree1740 thisClass = new FindDistanceInABinaryTree1740();

    }

    public int findDistance(TreeNode root, int p, int q) {
        if (p == q){
            return 0;
        }
        TreeInfo treeInfo = getTreeInfo(root, p, q);
        return treeInfo.distance;
    }
    private TreeInfo getTreeInfo(TreeNode root, int p, int q){
        if (root == null){
            return new TreeInfo(0, 0);
        }
        TreeInfo lTreeInfo = getTreeInfo(root.left, p, q);
        if (lTreeInfo.num == 2){
            return lTreeInfo;
        }
        TreeInfo rTreeInfo = getTreeInfo(root.right, p, q);
        if (rTreeInfo.num == 2){
            return rTreeInfo;
        }
        // when one child sub tree contains one node, and the other child sub tree contains the other node
        if (lTreeInfo.num == 1 && rTreeInfo.num == 1){
            return new TreeInfo(2, lTreeInfo.distance + rTreeInfo.distance + 2);
        }
        // when one child sub tree contains one node
        if (lTreeInfo.num == 1 || rTreeInfo.num == 1){
            if (root.val == p || root.val == q){
                return new TreeInfo(2, rTreeInfo.num == 1?rTreeInfo.distance + 1 : lTreeInfo.distance + 1);
            }
            else{
                return new TreeInfo(1, rTreeInfo.num == 1?rTreeInfo.distance + 1 : lTreeInfo.distance + 1);
            }
        }
        if (root.val == p || root.val == q){
            return new TreeInfo(1, 0);
        }
        return new TreeInfo(0, 0);
    }

    private class TreeInfo{
        int num;
        int distance;
        public TreeInfo(int num, int distance){
            this.num = num;
            this.distance = distance;
        }
    }
}