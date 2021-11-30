package medium;

import java.util.*;

public class Medium0510InorderSuccessorinBSTII {


     // Definition for a Node.
     class Node {
     public int val;
     public Node left;
     public Node right;
     public Node parent;
     }


    class Solution {
        public Node inorderSuccessor(Node node) {
            Node root = findRoot(node);
            List<Node> nodesList = new ArrayList<>();
            traverse(root, nodesList);
            for (int i = 0; i < nodesList.size(); i++){
                if (node.val == nodesList.get(i).val){
                    if (i == nodesList.size() - 1){
                        return null;
                    }
                    else{
                        return nodesList.get(i + 1);
                    }
                }
            }
            return null;
        }
        private Node findRoot(Node node){
            if (node.parent == null){
                return node;
            }
            return findRoot(node.parent);
        }

        private void traverse(Node node, List<Node> list){
            if (node != null){
                traverse(node.left, list);
                list.add(node);
                traverse(node.right, list);
            }
        }
    }
}