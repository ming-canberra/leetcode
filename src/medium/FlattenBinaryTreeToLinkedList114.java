package medium;

public class FlattenBinaryTreeToLinkedList114 {
    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList114 thisClass = new FlattenBinaryTreeToLinkedList114();

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
}