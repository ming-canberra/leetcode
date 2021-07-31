package medium;

import java.util.*;

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

    class BSTIteratorStack {
        private Stack<TreeNode> q = new Stack<>();
        public void BSTIterator(TreeNode root) {
            q.push(root);
        }
        public int next() {
            if (hasNext()){
                TreeNode top = q.pop();
                while(top.left != null || top.right != null){
                    if (top.right != null){
                        q.push(top.right);
                    }
                    q.push(new TreeNode(top.val));
                    if (top.left != null){
                        q.push(top.left);
                    }
                    top = q.pop();
                }
                return top.val;
            }
            return -1;
        }
        public boolean hasNext() {
            return q.size() > 0;
        }
    }
}