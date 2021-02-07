package easy;

import java.util.HashSet;

public class NRepeatedElementInSize2NArray961 {
    public static void main(String[] args) {
        NRepeatedElementInSize2NArray961 thisClass = new NRepeatedElementInSize2NArray961();
        int[][]input = new int[0][0];

        System.out.println(" " + thisClass.repeatedNTimes(null));
    }

    public int repeatedNTimes(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : A){
            if (set.contains(i)){
                return i;
            }
            else{
                set.add(i);
            }
        }
        return 0;
    }
}