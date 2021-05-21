package easy;

import java.util.*;

public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes thisClass = new CountPrimes();
        System.out.println(thisClass.countPrimes(7));
    }
    public int countPrimes(int n) {
        boolean[] isDividible = new boolean[n];

        int counter = 0;
        for (int i = 2; i < n; i++){
            if (isDividible[i] == false){
                counter++;
                for (int j = 2; i * j < n; j++) {
                    isDividible[i * j] = true;
                }
            }

        }
        return counter;
    }
}