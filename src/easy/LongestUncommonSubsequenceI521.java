package easy;

import java.util.HashSet;

public class LongestUncommonSubsequenceI521 {
    public static void main(String[] args) {
        LongestUncommonSubsequenceI521 thisClass = new LongestUncommonSubsequenceI521();
        System.out.println(thisClass.findLUSlength("aefawfawfawfaw", "aefawfeawfwafwaef"));
    }
    public int findLUSlength(String a, String b) {
        if (a.length() != b.length()){
            return a.length() > b.length()? a.length(): b.length();
        }
        else{
            if (a.equals(b)){
                return -1;
            }
            else{
                return a.length();
            }
        }
    }
}