package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Medium0787CheapestFlightsWithinKStops {
    /**
     * O(k E)
     *
     * */
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            int[]prices = new int[n];
            for (int i = k; i >= 0; i--){
                int[] curPrices = new int[n];
                for (int[] flight : flights){
                    if (i == k){
                        if (flight[0] == src){
                            prices[flight[1]] = flight[2];
                        }
                    }
                    else{
                        if (prices[flight[0]] != 0){
                            int newPrice = prices[flight[0]] + flight[2];
                            curPrices[flight[1]] = curPrices[flight[1]] == 0 ? newPrice : Math.min(newPrice, curPrices[flight[1]]);
                        }
                    }
                }
                for (int j = 0; j < n; j++){
                    if (prices[j] == 0){
                        prices[j] = curPrices[j];
                    }
                    else{
                        if (curPrices[j] != 0){
                            prices[j] = Math.min(prices[j], curPrices[j]);
                        }
                    }
                }
            }
            return prices[dst] == 0 ? -1 : prices[dst];
        }
    }
}