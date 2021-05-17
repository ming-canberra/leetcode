package medium;

import java.util.ArrayList;
import java.util.List;

public class ConvertsortedListToBinarySearchTree109 {
    public static void main(String[] args) {
        ConvertsortedListToBinarySearchTree109 thisClass = new ConvertsortedListToBinarySearchTree109();
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int m = list.size() / 2;

        TreeNode result = new TreeNode(list.get(m));

        buildTree(result, list, 0, m);
        buildTree(result, list, m + 1, list.size());

        return result;
    }

    private void buildTree(TreeNode root, List<Integer> list, int start, int end){
        if (end > start){
            int m = start + (end - start) / 2;

            int curValue = list.get(m);

            if (curValue < root.val){
                if (root.left == null){
                    root.left = new TreeNode(curValue);
                }
                else{
                    buildTree(root.left, list, start, end);
                }

                buildTree(root.left, list, start, m);
                buildTree(root.left, list, m + 1, end);
            }
            else if (curValue > root.val){
                if (root.right == null){
                    root.right = new TreeNode(curValue);
                }
                else{
                    buildTree(root.right, list, start, end);
                }

                buildTree(root.right, list, start, m);
                buildTree(root.right, list, m + 1, end);
            }
        }
    }
}