package hard;

public class Hard0124BinaryTreeMaximumPathSum {

    private int result;
    public int maxPathSum(TreeNode root) {
        this.result = root.val;
        maxPath(root);
        return this.result;
    }
    // return the max path that I could contribute
    private int maxPath(TreeNode node){

        int tmp = node.val;
        int lMaxPath = 0;
        if (node.left != null){
            lMaxPath = maxPath(node.left);
            tmp = Math.max(tmp, node.val + lMaxPath);
        }

        int rMaxPath = 0;
        if (node.right != null){
            rMaxPath = maxPath(node.right);
            tmp = Math.max(tmp, node.val + rMaxPath);
        }

        this.result = Math.max(this.result, tmp);

        if (node.left != null && node.right != null){
            this.result = Math.max(this.result, node.val + rMaxPath + lMaxPath);
        }

        return tmp;
    }

    class Solution {
        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            traverse(root);
            return result;
        }
        private int traverse(TreeNode root){
            result = Math.max(result, root.val);
            if (root.left == null && root.right == null){
                return root.val;
            }
            else if (root.left == null){
                int rMax = traverse(root.right);

                result = Math.max(result, rMax);
                int tmp = Math.max(root.val + rMax, root.val);
                result = Math.max(result, tmp);
                return  tmp;
            }
            else if (root.right == null){
                int lMax = traverse(root.left);

                result = Math.max(result, lMax);
                int tmp = Math.max(root.val + lMax, root.val);
                result = Math.max(result, tmp);
                return  tmp;
            }
            else{
                int lMax = traverse(root.left);
                int rMax = traverse(root.right);
                result = Math.max(result, lMax);
                result = Math.max(result, rMax);

                int tmp = Math.max( root.val + lMax + rMax, Math.max(root.val + rMax, root.val + lMax) );
                result = Math.max(result, tmp);

                return Math.max( root.val,  Math.max(root.val + rMax, root.val + lMax) );
            }


        }
    }

    class Solution2 {
        int result = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            recurse(root);
            return result;
        }
        // maxValue of path ending with root
        private int recurse(TreeNode root){
            int rootValue = root.val;
            Integer lValue = null;
            Integer rValue = null;
            int toReturn = rootValue;
            if (root.left != null){
                lValue = recurse(root.left);
                result = Math.max(result, lValue);
                toReturn = Math.max(toReturn, rootValue + lValue);
            }
            if (root.right != null){
                rValue = recurse(root.right);
                result = Math.max(result, rValue);
                toReturn = Math.max(toReturn, rootValue + rValue);
            }
            if (root.left != null && root.right != null){
                result = Math.max(result, rValue + lValue + rootValue);
            }
            result = Math.max(result, toReturn);
            return toReturn;
        }
    }
}