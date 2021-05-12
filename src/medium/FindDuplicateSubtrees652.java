package medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees652 {
    public static void main(String[] args) {
        FindDuplicateSubtrees652 thisClass = new FindDuplicateSubtrees652();
    }

    /**
     * space O(N)
     * time O(N*N)
     * */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> result = new ArrayList<TreeNode>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        postorder(root, map, result);

        return result;
    }

    private String postorder(TreeNode node, HashMap<String, Integer> map, List<TreeNode> result){
        if (node != null){
            String serialization = node.val + "," + postorder(node.left, map, result) + "," + postorder(node.right, map, result);

            map.put(serialization, map.getOrDefault(serialization, 0) + 1);

            if (map.get(serialization) == 2){
                result.add(node);
            }
            return serialization;
        }
        return "";
    }
}