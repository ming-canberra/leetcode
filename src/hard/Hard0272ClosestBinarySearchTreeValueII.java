package hard;

import java.util.*;

public class Hard0272ClosestBinarySearchTreeValueII {
    class Solution {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            PriorityQueue<Integer> heap = new PriorityQueue<>( (a, b) -> Double.compare(Math.abs((double)a - target), Math.abs((double)b - target)) );
            traverse(root, heap);
            List<Integer> result = new ArrayList<>();
            for (; k > 0; k--){
                result.add(heap.poll());
            }
            return result;
        }
        private void traverse(TreeNode root, PriorityQueue<Integer> heap){
            if (root != null){
                traverse(root.left, heap);
                heap.add(root.val);
                traverse(root.right, heap);
            }
        }
    }
}