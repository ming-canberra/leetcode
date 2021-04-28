package medium;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal105 thisClass = new ConstructBinaryTreeFromPreorderAndInorderTraversal105();

        TreeNode res = thisClass.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(res);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode result = buildBranches(preorder, inorder, 0, preorder.length);
        return result;
    }

    private TreeNode buildBranches(int[] preorder, int[] inorder, int start, int end) // subTree excludes index end
    {
        if (start < preorder.length && start < end) {
            TreeNode treeNode = new TreeNode(preorder[start]);
            int curIndex = start;

            while (inorder[curIndex] != preorder[start]) {
                curIndex++;
                if (curIndex == end){
                    break;
                }
            }

            treeNode.left = buildBranches(preorder, inorder, start + 1, Math.min(curIndex + 1, end));
            treeNode.right = buildBranches(preorder, inorder, curIndex + 1, end);

            return treeNode;
        }
        return null;
    }
}