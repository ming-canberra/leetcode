package easy;

public class SecondMinimumNodeInaBinaryTree671 {
    public static void main(String[] args) {
        SecondMinimumNodeInaBinaryTree671 thisClass = new SecondMinimumNodeInaBinaryTree671();
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);

        node3.left=node2;
        node3.right=node4;

        System.out.println(thisClass.findSecondMinimumValue(node3));
    }

    public int findSecondMinimumValue(TreeNode root) {
        int rootValue = root.val;
        return locateNodeBiggerThanMe(root, rootValue);
    }

    private int locateNodeBiggerThanMe(TreeNode root, int rootValue) {

        if (root == null){
            return -1;
        }

        if (root.val != rootValue) {
            return root.val;
        }

        if (root.left != null) {
            int leftV = locateNodeBiggerThanMe(root.left, rootValue);
            int rightV = locateNodeBiggerThanMe(root.right, rootValue);
            if (leftV ==-1){
                return rightV;
            }
            if (rightV == -1){
                return leftV;
            }
            return Math.min(leftV, rightV);
        }
        return -1;
    }
}