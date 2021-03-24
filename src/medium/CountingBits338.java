package medium;

import java.util.ArrayList;
import java.util.List;

public class CountingBits338 {
    public static void main(String[] args) {
        CountingBits338 thisClass = new CountingBits338();
        int [] a = thisClass.countBits(15);
        for (int i : a){
            System.out.println(i);
        }
    }

    public int[] countBits(int num) {
        if (num ==0){
            return new int[]{0};
        }
        if (num ==1){
            return new int[]{0,1};
        }

        List<Integer> res = new ArrayList<Integer>();

        res.add(0);
        res.add(1);

        int product = 1;
        int[] last = new int[]{1};
        while(true){
            product = product * 2;
            int[] current = new int[product];
            for (int i = 0;i < product; i++){
                if (i < last.length){
                    current[i] = last[i];
                }
                else{
                    current[i] = last[i%last.length] + 1;
                }
                if (res.size() == num +1){
                    break;
                }
                else{
                    res.add(current[i]);
                }
            }

            last = current;
            if (res.size() == num +1){
                break;
            }
        }

        int[] toReturn = new int[num + 1];

        for (int i = 0;i < res.size();i++){
            toReturn[i] = res.get(i);
        }

        return toReturn;
    }
}