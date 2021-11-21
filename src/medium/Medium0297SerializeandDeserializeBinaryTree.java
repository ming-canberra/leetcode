package medium;

import java.util.*;

public class Medium0297SerializeandDeserializeBinaryTree {
    public class Codec {

        public String serialize(TreeNode root) {
            String result = se(root);
            result = result.substring(0, result.length() - 1);
            return result;
        }
        private String se(TreeNode root){
            // preorder
            if(root == null){
                return "#,";
            }
            return root.val + "," + se(root.left) + se(root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>();
            String[] splited = data.split(",");
            queue.addAll(Arrays.asList(splited));

            return de(queue);
        }

        private TreeNode de(Queue<String> queue){
            String top = queue.poll();
            if (top.equals("#")){
                return null;
            }
            TreeNode root = new TreeNode( Integer.valueOf(top) );
            root.left = de(queue);
            root.right = de(queue);
            return root;
        }
    }
}