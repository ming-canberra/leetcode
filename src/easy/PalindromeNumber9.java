package easy;

import java.util.ArrayList;

public class PalindromeNumber9 {
    public static void main(String[] args) {
        PalindromeNumber9 thisClass = new PalindromeNumber9();
        System.out.println(" " + thisClass.isPalindrome(1001));
    }
    public boolean isPalindrome(int x) {

        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }
        if (x % 10 == 0){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (x >= 10){
            list.add(x % 10);
            x = x /10;
        }
        list.add(x);
        // check list, from small to big
        int left = 0;
        int right = list.size() - 1;
        while (left < right){
            if (list.get(left) != list.get(right) ){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}