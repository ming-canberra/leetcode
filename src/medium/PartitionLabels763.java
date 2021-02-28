package medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {
    public static void main(String[] args) {
        PartitionLabels763 thisClass = new PartitionLabels763();
        List<Integer> f = thisClass.partitionLabels("ababcbacadefegdehijhklij");
        for (Integer i : f){
            System.out.println(i);
        }
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        int firstIndex = 0;
        while (i < s.length()){
            char current = s.charAt(i);
            int lastIndex = s.lastIndexOf(current);
            if (i == lastIndex){
                ans.add(i + 1 - firstIndex);
                firstIndex = i +1;
                i++;
            }
            else{
                for (int j = i +1; j < lastIndex; j++){
                    if (current != s.charAt(j)){
                        int i1 = s.lastIndexOf(s.charAt(j));
                        if (i1 > lastIndex){
                            lastIndex = i1;
                        }
                    }
                }
                firstIndex = lastIndex +1;
                ans.add(lastIndex + 1 - i);
                i = firstIndex;
            }
        }
        return ans;
    }
}