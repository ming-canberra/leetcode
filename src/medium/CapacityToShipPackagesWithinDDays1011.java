package medium;

import java.util.HashSet;

public class CapacityToShipPackagesWithinDDays1011 {
    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays1011 thisClass = new CapacityToShipPackagesWithinDDays1011();
    }
    /**
     * O(NlogSUM)
     * */
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int maxW = 0;
        for (int i : weights){
            sum+=i;
            maxW = Math.max(maxW, i);
        }
        int l = maxW - 1;
        int r = sum + 1;
        while (l + 1 < r){
            int m = l + (r - l) / 2;
            boolean canIDo = canDo(weights, days, m);
            if (!canIDo){
                l = m;
            }
            else{
                r = m;
            }
        }
        return r;
    }

    private boolean canDo(int[] weights, int days, int capacity) {
        int index = 0;
        int dCount = 0;
        int curLoad = 0;
        while (index < weights.length){
            while(index < weights.length && curLoad + weights[index]<= capacity){
                curLoad+=weights[index];
                index++;
            }
            dCount++;
            curLoad = 0;
            if(dCount > days){
                break;
            }
        }
        if(dCount > days){
            return false;
        }
        else{
            return true;
        }
    }
}