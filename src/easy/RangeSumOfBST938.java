package easy;

public class RangeSumOfBST938 {
    public static void main(String[] args) {
        RangeSumOfBST938 thisClass = new RangeSumOfBST938();
        int a = thisClass.rangeSumBST(null, 2,3);
            System.out.println(a);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null){
            return 0;
        }
        int treeValue = 0;

        if (root.val > low && root.val < high){
            treeValue += root.val;
            treeValue += rangeSumBST(root.left, low, high);
            treeValue += rangeSumBST(root.right, low, high);
        }

        if (root.val <= low){
            if (root.val == low){
                treeValue += root.val;
            }
            treeValue += rangeSumBST(root.right, low, high);
        }

        if (root.val >= high){
            if (root.val == high) {
                treeValue += root.val;
            }
            treeValue += rangeSumBST(root.left, low, high);
        }

        return treeValue;
    }
}