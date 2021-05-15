package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BinarySearchTreeIterator173 {
    public static void main(String[] args) {
        BinarySearchTreeIterator173 thisClass = new BinarySearchTreeIterator173();
    }

    class BSTIterator {
        private List<TreeNode> nodeList = new ArrayList<>();
        private int index = -1;
        public BSTIterator(TreeNode root) {
            inorder(root, nodeList);
        }
        private void inorder(TreeNode root, List<TreeNode> list){
            if (root != null){
                inorder(root.left, list);
                list.add(root);
                inorder(root.right, list);
            }
        }
        public int next() {
            index++;
            return this.nodeList.get(this.index).val;
        }
        public boolean hasNext() {
            return this.index < this.nodeList.size() - 1;
        }
    }
}