package easy;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueEmailAddresses929 {
    public static void main(String[] args) {
        UniqueEmailAddresses929 thisClass = new UniqueEmailAddresses929();
        System.out.println(" " + thisClass.numUniqueEmails(new String[]{"test.email+alex@leetcode.com"}));
    }
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();

        for (String email : emails){
            String[] splits = email.split("@");
            String l = splits[0];
            String d = splits[1];

            String[] plusSplits = l.split("\\+");
            l = plusSplits[0];
            l=l.replaceAll("\\.", "");
            set.add(l+"@" +d);


        }

        return set.size();
    }
}