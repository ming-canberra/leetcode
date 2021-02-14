package easy;

import java.util.ArrayList;
import java.util.HashMap;

public class LemonadeChange860 {
    public static void main(String[] args) {
        LemonadeChange860 thisClass = new LemonadeChange860();
        boolean a = thisClass.lemonadeChange2(new int[]{5,5,5,10,20});
            System.out.println(a);
    }

    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> changeCountMap = new HashMap<Integer, Integer>();
        for (int change : bills){
            if (change ==5){
                changeCountMap.put(5, changeCountMap.getOrDefault(5, 0) +1);
            }
            else if (change ==10){
                if (changeCountMap.containsKey(5)){
                    if (changeCountMap.get(5) == 1){
                        changeCountMap.remove(5);
                    }
                    else{
                        changeCountMap.put(5, changeCountMap.get(5) - 1);
                    }

                    changeCountMap.put(10, changeCountMap.getOrDefault(10, 0) + 1);
                }
                else{
                    return false;
                }
            }
            else{
                // handle 20 bills
                if (changeCountMap.containsKey(10) && changeCountMap.containsKey(5)){
                    if (changeCountMap.get(10) == 1){
                        changeCountMap.remove(10);
                    }
                    else{
                        changeCountMap.put(10, changeCountMap.get(10) - 1);
                    }

                    if (changeCountMap.get(5) == 1){
                        changeCountMap.remove(5);
                    }
                    else{
                        changeCountMap.put(5, changeCountMap.get(5) - 1);
                    }
                }
                else if (changeCountMap.containsKey(5) && changeCountMap.get(5) >=3){
                    if (changeCountMap.get(5) == 3){
                        changeCountMap.remove(5);
                    }
                    else{
                        changeCountMap.put(5, changeCountMap.get(5) - 3);
                    }
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }

    public boolean lemonadeChange2(int[] bills) {
        int c5 = 0;
        int c10 = 0;
        for (int change : bills){
            if (change ==5){
                c5++;
            }
            else if (change ==10){
                if (c5>=1){
                    c5--;
                }
                else{
                    return false;
                }
                c10++;
            }
            else{
                if (c10>=1 && c5>=1){
                    c10--;
                    c5--;
                }
                else if (c5 >=3){
                    c5= c5-3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}