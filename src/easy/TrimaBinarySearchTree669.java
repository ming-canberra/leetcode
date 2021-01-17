package easy;

public class TrimaBinarySearchTree669 {
    public static void main(String[] args) {
        TrimaBinarySearchTree669 thisClass = new TrimaBinarySearchTree669();
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);

        node3.left=node2;
        node3.right=node4;

        System.out.println(thisClass.trimBST(null, 3,4));
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null){
            return null;
        }
        else if (root.val<low){
            return trimBST (root.right, low, high);
        }
        else if (root.val> high){
            return trimBST(root.left, low, high);
        }
        else {
            recursive(root, low, high);
        }

        return root;
    }

    private void recursive(TreeNode root, int low, int high){
        if (root == null){
            return;
        }

        if (root.left != null){
            if (root.left.val <low){
                root.left = root.left.right;
                recursive(root, low, high);
            }
            else{
                recursive(root.left, low, high);
            }
        }
        if (root.right != null){
            if (root.right.val >high){
                root.right = root.right.left;
                recursive(root, low, high);
            }
            else{
                recursive(root.right, low, high);
            }
        }
    }
}