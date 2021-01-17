package easy;

import java.util.ArrayList;
import java.util.List;

public class AverageofLevelsinBinaryTree637 {
    public static void main(String[] args) {
        AverageofLevelsinBinaryTree637 thisClass = new AverageofLevelsinBinaryTree637();

        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left=node9;
        node3.right=node20;
        node20.left = node15;
        node20.right = node7;


        System.out.println(thisClass.averageOfLevels(node3));
    }

    List<Double> _toReturn = new ArrayList<Double>();
    List<Integer> _numNodesPerLevel = new ArrayList<Integer>();

    public List<Double> averageOfLevels(TreeNode root) {
        recursiveFun(root, 0);
        return _toReturn;
    }

    private void recursiveFun(TreeNode root, int level){
        if (root == null){
            return;
        }



        if (_toReturn.size()<= level){
            _toReturn.add(new Double (root.val));
        }
        else{
            Double valueThisLevel = _toReturn.get(level);

            _toReturn.set(level, ( (valueThisLevel * _numNodesPerLevel.get(level) + new Double (root.val)) / ( _numNodesPerLevel.get(level) + 1)  ));
        }

        if (_numNodesPerLevel.size()<= level){
            _numNodesPerLevel.add(1);
        }
        else{
            Integer numNodesThisLevel = _numNodesPerLevel.get(level);
            _numNodesPerLevel.set(level, numNodesThisLevel + 1);
        }

        recursiveFun(root.left, level + 1);
        recursiveFun(root.right, level + 1);
    }

}