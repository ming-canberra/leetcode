package medium;

import java.util.*;

public class PrisonCellsAfterNDays957 {
    public static void main(String[] args) {
        PrisonCellsAfterNDays957 thisClass = new PrisonCellsAfterNDays957();
    }

    class Solution {
        public int[] prisonAfterNDays(int[] cells, int n) {
            int[] lastDay = cells;
            HashMap<String, Integer> map = new HashMap<>();
            StringBuilder sb = null;
            boolean loopFound = false;
            for (int i = 1; i <= n; i++){
                sb = new StringBuilder();
                int[] today = new int[8];
                for (int j = 1; j <= 6; j++){
                    today[j] = checkAdjacent(j, lastDay);
                    sb.append(today[j]);
                }
                if (map.containsKey(sb.toString())){
                    // looping started, cycle length is i - x;
                    if (!loopFound){
                        int x = map.get(sb.toString());
                        i += ( (n - i) / (i - x) ) * (i - x) ;
                        loopFound = true;
                    }
                }
                else{
                    map.put(sb.toString(), i);
                }
                lastDay = today;
            }
            return lastDay;
        }
        private int checkAdjacent(int index, int[] cells){
            if (cells[index + 1] == cells[index - 1]){
                return 1;
            }
            return 0;
        }
    }
}