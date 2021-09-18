package medium;

public class Medium1191KConcatenationMaximumSum {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int gSum = 0;
            int cSum = 0;
            for (int i = 0; i < n; i++){
                gSum += gas[i];
                cSum += cost[i];
            }
            if (gSum >= cSum){
                int tank = 0;
                int result = 0;
                for (int i = 0; i < n; i++){
                    tank += gas[i];
                    if (tank >= cost[i]){
                        tank -= cost[i];
                        continue;
                    }
                    else{
                        tank = 0;
                        result = i + 1;
                    }
                }
                return result;
            }
            return -1;
        }
    }
}