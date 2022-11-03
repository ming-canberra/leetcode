package medium;

public class Medium0449SerializeAndDeserializeBST {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }

            String lString = serialize(root.left);
            String rString = serialize(root.right);

            StringBuilder sb = new StringBuilder();
            sb.append(root.val);

            if ( !lString.equals("") ) {
                sb.append(",");
                sb.append(lString);
            }

            if ( !rString.equals("") ) {
                sb.append(",");
                sb.append(rString);
            }


            return sb.toString();
        }
        // preorder traversal
        public TreeNode deserialize(String data) {
            if (data == null || data.equals("")) {
                return null;
            }

            String[] splits = data.split(",");

            TreeNode res = traverse(splits, 0, splits.length - 1);

            return res;
        }
        private TreeNode traverse(String[] splits, int start, int end) {
            if (start < splits.length && start <= end) {
                TreeNode res = new TreeNode( Integer.valueOf( splits[start] ) );
                int resValue = res.val;

                for (int i = start + 1; i <= end; i++) {
                    if ( Integer.valueOf(  splits[i] ) > resValue) {
                        TreeNode lChild = traverse(splits, start + 1, i - 1);
                        TreeNode rChild = traverse(splits, i, end);
                        res.left = lChild;
                        res.right = rChild;
                        return res;
                    }
                }
                TreeNode lChild = traverse(splits, start + 1, end);
                res.left = lChild;
                return res;
            }
            return null;
        }
    }
}