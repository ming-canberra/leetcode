package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AddToArrayFormOfInteger989 {
    public static void main(String[] args) {
        AddToArrayFormOfInteger989 thisClass = new AddToArrayFormOfInteger989();
        List<Integer> ans = thisClass.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1);
        for ( int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
    public List<Integer> addToArrayForm(int[] A, int K) {

        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> k = new ArrayList<Integer>();

        for (int i = A.length -1; i >=0;i--){
            a.add(A[i]);
        }

        while (K /10 >0){
            k.add(K%10);
            K = K / 10;
        }
        k.add(K%10);

        List<Integer> tempAns = new ArrayList<Integer>();

        int carry = 0;
        for (int i =0; i < a.size() || i<k.size();i++)
        {
            int sum =0;

            if (carry > 0){
                sum +=1;
            }
            if (i < a.size()){
                sum+=a.get(i);
            }
            if (i<k.size()){
                sum+=k.get(i);
            }
            if (sum > 9){
                carry = 1;
            }
            else{
                carry = 0;
            }

            tempAns.add(sum % 10);

        }
        if (carry > 0){
            tempAns.add(carry);
        }

        Collections.reverse(tempAns);

        return tempAns;
    }
}