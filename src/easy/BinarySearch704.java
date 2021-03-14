package easy;

import java.util.HashSet;

public class BinarySearch704 {
    public static void main(String[] args) {
        BinarySearch704 thisClass = new BinarySearch704();

        int[] s1 = {1,3,5,9,10};


        System.out.println(thisClass.isHappy(13));
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        int current = n;
        while (current != 1){
            int sum = 0;
            while (current >=10){
                sum+= (current%10) * (current%10);
                current = current /10;
            }
            sum+= current*current;
            if (set.contains(sum)){
                return false;
            }
            else{
                set.add(sum);
            }
            current = sum;
        }

        return true;
    }
}