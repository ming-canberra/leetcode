package easy;

import java.util.ArrayList;
import java.util.List;

public class NumberofSegmentsinaString434 {
    public static void main(String[] args) {
        NumberofSegmentsinaString434 thisClass = new NumberofSegmentsinaString434();

        System.out.println(thisClass.countSegments("123"));
    }
    public int countSegments(String s) {
        int toReturn = 0;
        boolean inSequence = false;
        for (char c : s.toCharArray()){

            if (' '==c){
                inSequence = false;
            }
            else{
                if (!inSequence){
                    toReturn++;
                }
                inSequence = true;
            }
        }
        return toReturn;
    }
}