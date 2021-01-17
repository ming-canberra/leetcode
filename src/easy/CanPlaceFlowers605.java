package easy;

import java.util.ArrayList;
import java.util.HashMap;

public class CanPlaceFlowers605 {
    public static void main(String[] args) {
        CanPlaceFlowers605 thisClass = new CanPlaceFlowers605();

        int[] s1 = {1,0,0,0,1};
        int s2 = 2;
        System.out.println(thisClass.canPlaceFlowers(s1, s2));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n ==0){
            return true;
        }
        if (flowerbed.length < 2*n - 1){
            return false;
        }

        // to handle length = 1
        if (flowerbed.length == 1 && n ==1){
            return flowerbed[0] ==0;
        }

        //to handle length = 2
        if (flowerbed.length == 2 && n ==1){
            return flowerbed[0] ==0 && flowerbed[1] == 0;
        }

        //to handle length >=3
        int currentCount = n;

        // handle generic
        for (int i = 0; i < flowerbed.length; i++){
            if (i==0){
                if (flowerbed[0] ==0 && flowerbed[1] ==0){
                    currentCount--;
                    flowerbed[0] = 1;
                    i++;
                }
            }
            else if (i==flowerbed.length -1){
                if (flowerbed[flowerbed.length -1] ==0 && flowerbed[flowerbed.length -2] ==0){
                    currentCount--;
                    flowerbed[flowerbed.length -1] = 1;
                    i++;
                }
            }
            else if (flowerbed[i] ==0 && flowerbed[i-1] == 0 &&flowerbed[i+1] == 0){
                currentCount--;
                flowerbed[i] = 1;
                i++;
            }

            if (currentCount == 0){
                return true;
            }
        }

        return false;
    }
}