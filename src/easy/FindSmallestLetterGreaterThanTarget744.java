package easy;

import java.util.ArrayList;
import java.util.List;

public class FindSmallestLetterGreaterThanTarget744 {
    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget744 thisClass = new FindSmallestLetterGreaterThanTarget744();

        System.out.println(thisClass.nextGreatestLetter("cfj".toCharArray(),'c'));

        System.out.println('z' - 'a');
    }
    public char nextGreatestLetter(char[] letters, char target) {

        int l =0;
        int r = letters.length -1;
        // no need to wrap around
        if (letters[r] > target){
            while(r > l){
                int m = l + (r-l)/2;
                if (letters[l] > target){
                    return  letters[l];
                }
                else if (letters[m] > target){
                    r = m;
                }
                else{
                    if (l == m){
                        return letters[r];
                    }
                    l = m;
                }
            }
            return letters[r];
        }
        // need to wrap around
        else{
            return letters[0];
        }

    }
}