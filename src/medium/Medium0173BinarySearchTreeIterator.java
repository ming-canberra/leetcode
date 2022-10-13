package medium;

import java.util.*;

public class Medium0173BinarySearchTreeIterator {
    public static void main(String[] args) {
        Medium0173BinarySearchTreeIterator thisClass = new Medium0173BinarySearchTreeIterator();
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

    class BSTIterator1 {

        Stack<TreeNode> stack = new Stack<>();
        public BSTIterator1(TreeNode root) {
            pushAll(root);
        }

        private void pushAll(TreeNode root){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode top = stack.pop();
            int toReturn = top.val;
            pushAll(top.right);
            return toReturn;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    class BSTIterator2 {

        Stack<TreeNode> stack = new Stack<>();
        public BSTIterator2(TreeNode root) {
            stack.push(root);
            while(stack.peek().left != null){
                stack.push(stack.peek().left);
            }
        }
        public int next() {
            TreeNode top = stack.pop();
            if (top.right != null){
                stack.push(top.right);
                while(stack.peek().left != null){
                    stack.push(stack.peek().left);
                }
            }
            return top.val;
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    class BSTIterator3 {
        Deque<TreeNode> stack = new LinkedList<>();
        public BSTIterator3(TreeNode root) {
            traverseLeft(root);
        }
        private void traverseLeft(TreeNode node) {
            if (node != null) {
                stack.addLast(node);
                traverseLeft(node.left);
            }
        }
        public int next() {
            TreeNode top = stack.removeLast();
            traverseLeft(top.right);
            return top.val;
        }
        public boolean hasNext() {
            return stack.size() > 0;
        }
    }

}