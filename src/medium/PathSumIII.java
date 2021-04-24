package medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PathSumIII {
    public static void main(String[] args) {
        PathSumIII thisClass = new PathSumIII();
        int result = thisClass.pathSum(generteTree(), 1);
        System.out.println(result);
    }

    public static TreeNode generteTree(){
        List<Integer> list = new ArrayList<Integer>();

        Collections.addAll(list, 10,5,-3,3,2,null,11,3,-2,null,1);

        TreeNode root = new TreeNode(list.get(0));
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        nodeList.add(root);
        for (int i = 1; i < list.size(); i++){
            if (i % 2 == 1){
                // left
                if (list.get(i) != null){
                    TreeNode newNode = new TreeNode(list.get(i));
                    nodeList.get((i - 1) /2).left = newNode;
                    nodeList.add(newNode);
                }
                else {
                    nodeList.add(null);
                }
            }
            else{
                // right
                if (list.get(i) != null){
                    TreeNode newNode = new TreeNode(list.get(i));
                    nodeList.get((i - 1) /2).right = newNode;
                    nodeList.add(newNode);
                }
                else {
                    nodeList.add(null);
                }
            }
        }


        return root;
    }

    private static int _counter = 0;
    public int pathSum(TreeNode root, int targetSum) {
    }
}