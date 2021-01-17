package easy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class RotateString796 {
    public static void main(String[] args) {
        RotateString796 thisClass = new RotateString796();
        System.out.println(thisClass.rotateString("abcde","cdeab"));
    }
    public boolean rotateString(String A, String B) {
        if (A.length() == B.length()){
            if ((A + A).contains(B)){
                return true;
            }
        }

        return false;
    }
}