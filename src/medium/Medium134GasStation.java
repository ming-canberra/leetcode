package medium;

public class Medium134GasStation {
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

    class Solution1 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int gasSum = 0;
            int costSum = 0;
            int n = gas.length;
            for (int i = 0; i < n; i++){
                gasSum += gas[i];
                costSum += cost[i];
            }
            if (gasSum < costSum){
                return -1;
            }
            int[] dp = new int[n];
            dp[0] = gas[n - 1] - cost[n - 1];
            int min = dp[0];
            int result = 0;
            for (int i = 1; i < n; i++){
                dp[i] = dp[i - 1] + gas[i - 1] - cost[i - 1];
                if (gas[i] >= cost[i]){
                    if (dp[i] < min){
                        result = i;
                        min = dp[i];
                    }
                }

            }
            return result;
        }
    }

    class Solution2 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int gasSum = 0;
            int costSum = 0;
            for (int i = 0; i < cost.length; i++){
                gasSum += gas[i];
                costSum += cost[i];
            }
            if (gasSum < costSum){
                return -1;
            }
            int len = gas.length;
            int[] gasAcc = new int[len];
            int[] costAcc = new int[len];
            gasAcc[0] = gas[0];
            costAcc[0] = cost[0];
            int min = gas[0] - cost[0];
            int rlt = 0;
            for (int i = 1; i < len; i++){
                gasAcc[i] = gasAcc[i - 1] + gas[i];
                costAcc[i] = costAcc[i - 1] + cost[i];
                if (gasAcc[i] - costAcc[i] < min){
                    min = gasAcc[i] - costAcc[i];
                    rlt = i;
                }
            }
            return rlt + 1 == len ? 0 : rlt + 1;
        }
    }
}