package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumOfEvenNumbersAfterQueries985 {
    public static void main(String[] args) {
        SumOfEvenNumbersAfterQueries985 thisClass = new SumOfEvenNumbersAfterQueries985();

        int[][] a = new int[6][2];
        a[0]=new int[]{-4, 2};
        a[1]=new int[]{9, 0};
        a[2]=new int[]{-8, 1};
        a[3]=new int[]{5, 4};
        a[4]=new int[]{1, 4};
        a[5]=new int[]{9, 0};



        int[] ans = thisClass.sumEvenAfterQueries(new int[]{-10,2,-4,5,-3,3}, a);
        for ( int i : ans) {
            System.out.println(i);
        }
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        for (int i : A){
            if (i % 2 ==0){
                sum+=i;
            }
        }

        int[] ans = new int[queries.length];

        for (int i =0;i < queries.length;i++){
            int index = queries[i][1];
            int val = queries[i][0];
            if (A[index] % 2 ==0){
                if (val % 2 == 0){
                    sum +=val;
                    ans[i] = sum;
                }
                else{
                    sum -=A[index];
                    ans[i] = sum;
                }
            }
            else if (A[index] % 2 !=0){
                if (val % 2 !=0){
                    sum +=(val + A[index]);
                    ans[i] = sum;
                }
                else{
                    ans[i] = sum;
                }
            }

            A[index] = A[index] + val;

        }

        return ans;
    }
}