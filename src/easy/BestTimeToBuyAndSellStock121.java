package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock121 thisClass = new BestTimeToBuyAndSellStock121();
        int ans = thisClass.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(ans);
    }
    public int maxProfit(int[] prices) {
        int ans = 0;
        int l = 1;
        int r = prices.length - 2;
        int currentL = prices[0];
        int currentH = prices[prices.length - 1];
        if (currentH > currentL){
            ans = currentH - currentL;
        }

        while (l<=r){
            if (l==r){
                if (prices[l] > currentH){
                    ans = Math.max(ans, prices[l]  - currentL);
                }
                else if (prices[l] < currentL){
                    ans = Math.max(ans, currentH - prices[l]);
                }

                break;
            }
            else{
                if (prices[l]<currentL){
                    currentL = prices[l];
                }
                if (prices[l] > currentL){
                    ans = Math.max(ans, prices[l]  - currentL);
                }


                if (prices[r]>currentH){
                    currentH = prices[r];
                }
                if (prices[r]< currentH){
                    ans = Math.max(ans, currentH - prices[r]);
                }


                if (currentH > currentL){
                    ans = Math.max(ans, currentH - currentL);
                }
                l++;
                r--;
            }
        }

        return ans;
    }
}