package medium;

import java.util.*;

public class Medium0099RecoverBinarySearchTree {
    class Solution {
        public void recoverTree(TreeNode root) {
            List<TreeNode> originalList = new ArrayList<>();
            traverse(root, originalList);

            List<TreeNode> toSortList = new ArrayList<>(originalList);
            Collections.sort(toSortList, (a, b)-> Integer.compare(a.val, b.val) );

            TreeNode[] mistakes = new TreeNode[2];
            int idx = 0;
            for (int i = 0; i < toSortList.size(); i++){
                if (toSortList.get(i).val != originalList.get(i).val){
                    mistakes[idx++] = toSortList.get(i);
                }
            }

            int tmp = mistakes[0].val;
            mistakes[0].val = mistakes[1].val;
            mistakes[1].val = tmp;
        }

        private void traverse(TreeNode root, List<TreeNode> list){
            if (root != null){
                traverse(root.left, list);
                list.add(root);
                traverse(root.right, list);
            }
        }
    }
}