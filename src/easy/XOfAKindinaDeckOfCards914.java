package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class XOfAKindinaDeckOfCards914 {
    public static void main(String[] args) {
        XOfAKindinaDeckOfCards914 thisClass = new XOfAKindinaDeckOfCards914();
        System.out.println(" " + thisClass.hasGroupsSizeX(new int[]{1,2,3,4}));
    }
    public boolean hasGroupsSizeX(int[] deck) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : deck){
            map.put(i , map.getOrDefault(i, 0) + 1);
        }

        int min = 100000;
        for (int i : map.values()){
            min = Math.min(i, min);
        }

        if (min < 2){
            return false;
        }
        for (int j =2; j <=min; j++){
            boolean allgood = true;
            for (int count : map.values()){
                if (count % j !=0){
                    allgood = false;
                    break;
                }
            }
            if (allgood){
                return true;
            }
        }

        return false;
    }
}