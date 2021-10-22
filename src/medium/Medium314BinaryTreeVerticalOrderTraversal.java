package medium;

import java.util.*;

public class Medium314BinaryTreeVerticalOrderTraversal {
    class Solution {
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        int minCol = 0;
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root, 0));
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    Pair top = queue.poll();
                    minCol = Math.min(minCol, top.col);
                    List<Integer> iList = colMap.getOrDefault(top.col, new ArrayList<>());
                    iList.add(top.node.val);
                    colMap.put(top.col, iList);
                    if (top.node.left != null){
                        queue.add(new Pair(top.node.left, top.col - 1));
                    }
                    if (top.node.right != null){
                        queue.add(new Pair(top.node.right, top.col + 1));
                    }
                }
            }
            while(colMap.containsKey(minCol)){
                result.add(colMap.get(minCol));
                minCol++;
            }
            return result;
        }
        class Pair{
            TreeNode node;
            int col;
            public Pair(TreeNode n, int c){
                node = n;
                col = c;
            }
        }
    }
}