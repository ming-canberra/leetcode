package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindTheTownJudge997 {
    public static void main(String[] args) {
        FindTheTownJudge997 thisClass = new FindTheTownJudge997();
        int[][]input = new int[0][0];


        System.out.println(" " + thisClass.findJudge(1, input));
    }
    public int findJudge(int N, int[][] trust) {
        if (N==1 && trust == null){
            return 1;
        }
        if (N==1 && trust.length ==0){
            return 1;
        }
        HashSet<Integer> notJudges = new HashSet<Integer>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int[] item : trust){
            int trusted = item[1];
            int trustee = item[0];
            notJudges.add(trustee);
            if (map.containsKey(trusted)){
                HashSet<Integer> set = map.get(trusted);
                set.add(trustee);
            }
            else{
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(trustee);
                map.put(trusted, set);
            }
        }

        int counter = 0;
        int toReturn = -1;
        for ( Integer key : map.keySet()){
            if (!notJudges.contains(key) && map.get(key).size() == N -1){
                toReturn = key;
                counter++;
            }
        }

        if (counter ==1){
            return toReturn;
        }

        return -1;
    }
}