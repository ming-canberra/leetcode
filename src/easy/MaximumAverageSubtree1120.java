package easy;

public class MaximumAverageSubtree1120 {
    public static void main(String[] args) {
        MaximumAverageSubtree1120 thisClass = new MaximumAverageSubtree1120();
    }
    private double result = 0.0;

    public double maximumAverageSubtree(TreeNode root) {


        getTreeInfo(root);

        return result;
    }

    private TreeInfo getTreeInfo(TreeNode root){

        if (root == null){
            return new TreeInfo(0, 0.0);
        }

        TreeInfo lInfo = getTreeInfo(root.left);
        TreeInfo rInfo = getTreeInfo(root.right);

        double totalVal = root.val + lInfo.val + rInfo.val;
        int totalNum = 1 + lInfo.num + rInfo.num;

        result = Math.max(result, totalVal/(double)totalNum );

        return new TreeInfo(totalNum, totalVal);
    }

    private class TreeInfo
    {
        int num; // number of subtree, i.e. root + all descendants
        double val; // total value of num

        TreeInfo(int num, double val)
        {
            this.num = num;
            this.val = val;
        }
    }

    class Solution {
        private double result = 0.0;
        public double maximumAverageSubtree(TreeNode root) {
            calculateTreeInfo(root);
            return result;
        }
        private Info calculateTreeInfo(TreeNode root){
            if (root == null){
                return new Info(0, 0);
            }

            Info lInfo = calculateTreeInfo(root.left);
            Info rInfo = calculateTreeInfo(root.right);

            int count = lInfo.count + rInfo.count + 1;
            int tValue = lInfo.totalValue + rInfo.totalValue + root.val;

            result = Math.max(result, tValue * 1.0 / count);

            return new Info(count, tValue);
        }

        class Info{

            int count;
            int totalValue;

            Info(int count, int totalValue){
                this.count = count;
                this.totalValue = totalValue;
            }
        }
    }
}