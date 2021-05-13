package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal145 {
    public static void main(String[] args) {
        BinaryTreePostorderTraversal145 thisClass = new BinaryTreePostorderTraversal145();
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    private void postorder(TreeNode node, List<Integer> result){
        if (node != null){
            postorder (node.left, result);
            postorder (node.right, result);
            result.add(node.val);
        }
    }
}