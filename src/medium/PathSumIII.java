package medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PathSumIII {
    public static void main(String[] args) {
        PathSumIII thisClass = new PathSumIII();
        thisClass.pathSum(null, 1);
    }
    private static int _counter = 0;
    public int pathSum(TreeNode root, int targetSum) {
        sum(root, new HashMap<Integer, Integer>(), targetSum);
        return _counter;
    }
    private void sum(TreeNode root, HashMap<Integer, Integer> map, int target){
        if (root != null){
            if (map.containsKey(root.val)){
                _counter = _counter + map.get(root.val);
            }

            HashMap<Integer, Integer> descendantMap = new HashMap<Integer, Integer>();

            for (Object key : map.keySet()){
                descendantMap.put((Integer)key - root.val, map.get(key));
            }

            int forChildren = target - root.val;
            descendantMap.put(forChildren, descendantMap.getOrDefault(forChildren, 0) + 1);

            sum(root.left, descendantMap, target);
            sum(root.right, descendantMap, target);
        }
    }
}