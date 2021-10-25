package medium;

import java.util.*;

public class Medium1863AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        Medium1863AllNodesDistanceKInBinaryTree thisClass = new Medium1863AllNodesDistanceKInBinaryTree();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<TreeNode, TreeNode> nodeToParentMap = new HashMap<TreeNode, TreeNode>();
        fillMap(root, nodeToParentMap);
        List<Integer> result = new ArrayList<Integer>();
        if (K == 0){
            result.add(target.val);
            return result;
        }
        else{
            //countDescendants(target, K, result);
            HashSet<TreeNode> visited = new HashSet<TreeNode>();
            visited.add(target);
            if (nodeToParentMap.containsKey(target)){
                countNonDescendants(nodeToParentMap.get(target), K - 1, result, nodeToParentMap, visited);
            }
            if (target.left != null){
                countNonDescendants(target.left, K - 1, result, nodeToParentMap, visited);
            }
            if (target.right != null){
                countNonDescendants(target.right, K - 1, result, nodeToParentMap, visited);
            }
        }
        return result;
    }

    private void countNonDescendants(TreeNode node, int k, List<Integer> result, HashMap<TreeNode, TreeNode> map, HashSet<TreeNode> visited){
        if (k == 0){
            result.add(node.val);
        }
        else{
            visited.add(node);
            if (map.containsKey(node) && !visited.contains(map.get(node))){
                countNonDescendants(map.get(node), k - 1, result, map, visited);
            }
            if (node.left != null && !visited.contains(node.left) ) {
                countNonDescendants(node.left, k - 1, result, map, visited);
            }
            if (node.right != null && !visited.contains(node.right) ){
                countNonDescendants(node.right, k - 1, result, map, visited);
            }
        }
    }
    private void  fillMap(TreeNode root, HashMap<TreeNode, TreeNode> map){
        if (root != null){
            if (root.left != null){
                map.put(root.left, root);
                fillMap(root.left, map);
            }
            if (root.right != null){
                map.put(root.right, root);
                fillMap(root.right, map);
            }
        }
    }

    class Solution {
        List<Integer> result = new ArrayList<>();
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            Map<TreeNode, TreeNode> parent = new HashMap<>();
            traverseForParent(root, parent);
            Set<TreeNode> visited = new HashSet<>();
            traverseK(target, parent, k, visited);
            return result;
        }
        private void traverseK(TreeNode node, Map<TreeNode, TreeNode> map, int k, Set<TreeNode> visited){
            if (node != null && !visited.contains(node)){
                visited.add(node);
                if (k == 0){
                    result.add(node.val);
                }
                else{
                    traverseK(map.getOrDefault(node, null), map, k - 1, visited);
                    traverseK(node.left, map, k - 1, visited);
                    traverseK(node.right, map, k - 1, visited);
                }
            }
        }
        private void traverseForParent(TreeNode root, Map<TreeNode, TreeNode> parent){
            if (root != null){
                if (root.left != null){
                    parent.put(root.left, root);
                }
                if (root.right != null){
                    parent.put(root.right, root);
                }
                traverseForParent(root.right, parent);
                traverseForParent(root.left, parent);
            }
        }
    }
    class Solution1 {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            Map<TreeNode, TreeNode> map = new HashMap<>();// child to parent;
            traverse(root, map);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(target);

            Set<TreeNode> visited = new HashSet<>();
            visited.add(target);

            while(!queue.isEmpty() && k != 0){
                k--;
                for (int size = queue.size(); size > 0; size--){
                    TreeNode top = queue.poll();
                    if (top.left != null && !visited.contains(top.left)){
                        visited.add(top.left);
                        queue.add(top.left);
                    }
                    if (top.right != null && !visited.contains(top.right)){
                        visited.add(top.right);
                        queue.add(top.right);
                    }
                    if (map.containsKey(top) && !visited.contains(map.get(top))){
                        visited.add(map.get(top));
                        queue.add(map.get(top));
                    }
                }
            }
            List<Integer> result = new ArrayList<>();
            while(!queue.isEmpty()){
                result.add(queue.poll().val);
            }
            return result;
        }
        private void traverse(TreeNode root, Map<TreeNode, TreeNode> map){
            if (root.left != null){
                map.put(root.left, root);
                traverse(root.left, map);
            }
            if (root.right != null){
                map.put(root.right, root);
                traverse(root.right, map);
            }
        }
    }
}