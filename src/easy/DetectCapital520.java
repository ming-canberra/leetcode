package easy;

import java.util.ArrayList;
import java.util.List;

public class DetectCapital520 {
    public static void main(String[] args) {
        DetectCapital520 thisClass = new DetectCapital520();
        System.out.println(thisClass.detectCapitalUse("bas"));
    }
    public boolean detectCapitalUse(String word) {
        if (word.toLowerCase().equals(word) || word.toUpperCase().equals(word)){
            return true;
        }
        if (word.length() == 1){
            return true;
        }
        else{
            if (word.substring(1).toLowerCase().equals(word.substring(1))){
                return true;
            }
        }

        return false;
    }
}