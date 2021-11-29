package medium;

import java.util.*;

public class Medium0545BoundaryofBinaryTree {
    class Solution {
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> leaves = new ArrayList<>();


            if (root.left != null || root.right != null){
                traverseLeaves(root, leaves);
            }

            List<Integer> leftBoundary = new ArrayList<>();
            List<Integer> rightBoundary = new ArrayList<>();


            traverseLeft(root.left, leftBoundary);
            traverseRight(root.right, rightBoundary);

            Collections.reverse(rightBoundary);
            List<Integer> result = new ArrayList<>();
            result.add(root.val);
            result.addAll(leftBoundary);
            result.addAll(leaves);
            result.addAll(rightBoundary);
            return result;
        }

        private void traverseRight(TreeNode root, List<Integer> list){
            if (root != null){
                if (root.left == null && root.right == null){
                    return;
                }
                else{
                    list.add(root.val);
                    if (root.right != null){
                        traverseRight(root.right, list);
                    }
                    else{
                        traverseRight(root.left, list);
                    }
                }
            }
        }


        private void traverseLeft(TreeNode root, List<Integer> list){
            if (root != null){
                if (root.left == null && root.right == null){
                    return;
                }
                else{
                    list.add(root.val);
                    if (root.left != null){
                        traverseLeft(root.left, list);
                    }
                    else{
                        traverseLeft(root.right, list);
                    }
                }
            }
        }

        private void traverseLeaves(TreeNode root, List<Integer> list){
            if (root != null){
                if (root.left == null && root.right == null){
                    list.add(root.val);
                }
                else{
                    traverseLeaves(root.left, list);
                    traverseLeaves(root.right, list);
                }
            }
        }
    }
}