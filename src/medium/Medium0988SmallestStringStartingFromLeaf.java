package medium;

import java.util.HashSet;
import java.util.Set;

public class Medium0988SmallestStringStartingFromLeaf {
    class Solution {
        String result = null;
        public String smallestFromLeaf(TreeNode root) {
            dfs(root, new StringBuilder());
            return result;
        }
        private void dfs(TreeNode root, StringBuilder sb) {
            sb.append((char)('a' + root.val));
            if (root.left != null) {
                dfs(root.left, sb);
            }
            if (root.right != null) {
                dfs(root.right, sb);
            }
            if (root.left == null && root.right == null) {
                // compare
                if (result == null) {
                    result = sb.reverse().toString();
                }
                else {
                    String cur = sb.reverse().toString();
                    if (cur.compareTo(result) < 0) {
                        result = cur;
                    }
                }
                sb.reverse();
            }
            sb.deleteCharAt(sb.length() -1 );
        }
    }
}