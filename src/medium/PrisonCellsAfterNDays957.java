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

    class Solution1 {
        public int[] prisonAfterNDays(int[] cells, int n) {
            Set<String> set = new HashSet<>();
            int[] curDay = cells;
            boolean foundCircle = false;
            for (int i = 0; i < n; i++){
                curDay = nextDay(curDay);

                if (!foundCircle){
                    String curDayString = curDay[0] + "" + curDay[1] + curDay[2] + curDay[3] + curDay[4] + curDay[5] + curDay[6] + curDay[7];
                    if (set.contains(curDayString)){
                        int circleSize = set.size();
                        // add some circles to i
                        i = i + (n - 1 - i) / circleSize * circleSize;
                        foundCircle = true;
                    }
                    else{
                        set.add(curDayString);
                    }
                }
            }
            return curDay;
        }

        private int[] nextDay(int[] cells){
            int[] result = new int[8];
            result[0] = 0;
            result[7] = 0;
            for (int i = 1; i < 7; i++){
                if(cells[i - 1] == cells[i + 1]){
                    result[i] = 1;
                }
                else{
                    result[i] = 0;
                }
            }
            return result;
        }
    }
}