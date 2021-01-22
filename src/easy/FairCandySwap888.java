package easy;

import java.util.HashSet;

public class FairCandySwap888 {
    public static void main(String[] args) {
        FairCandySwap888 thisClass = new FairCandySwap888();

        thisClass.fairCandySwap(null, null);
    }
    //do binary search
    public int[] fairCandySwap(int[] a, int[] b) {
        int sumA = 0;
        int sumB = 0;
        HashSet<Integer> setA = new HashSet<Integer>();
        HashSet<Integer> setB = new HashSet<Integer>();

        for (int i = 0; i < a.length;i++){
            sumA += a[i];
            setA.add(a[i]);
        }
        for (int i = 0; i < b.length;i++){
            sumB += b[i];
            setB.add(b[i]);
        }
        int diff = 0;
        if (sumA > sumB){
            diff = (sumA -sumB)/2;
            for (int i = 0; i < b.length;i++)
            {
                if (setA.contains(diff + b[i])){
                    return new int[]{diff + b[i], b[i]};
                }
            }
        }
        else{
            diff = (sumB -sumA)/2;
            for (int i = 0; i < a.length;i++)
            {
                if (setB.contains(diff + a[i])){
                    return new int[]{a[i], diff + a[i]};
                }
            }
        }

        return null;
    }
}