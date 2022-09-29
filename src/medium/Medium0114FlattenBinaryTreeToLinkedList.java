package medium;

public class Medium0114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Medium0114FlattenBinaryTreeToLinkedList thisClass = new Medium0114FlattenBinaryTreeToLinkedList();

    }

    public void flatten(TreeNode root) {
        flattenSub(root);
    }

    private TreeNode flattenSub(TreeNode root){
        if (root == null){
            return null;
        }

        if (root.left == null && root.right == null){
            return root;
        }

        TreeNode lTail = flattenSub(root.left);
        TreeNode rTail = flattenSub(root.right);

        if (lTail != null){
            lTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return rTail == null ? lTail : rTail;
    }

    class Solution {
        public void flatten(TreeNode root) {
            traverse(root);
        }
        private TreeNode traverse(TreeNode root) {
            if (root != null) {
                TreeNode leftTail = traverse(root.left);

                TreeNode rightTail = traverse(root.right);

                if (leftTail != null) {
                    leftTail.right = root.right;
                }

                if (root.left != null) {
                    root.right = root.left;
                }
                root.left = null;

                return rightTail == null ? ( leftTail == null ? root : leftTail ) : rightTail;
            }
            return null;
        }
    }
}