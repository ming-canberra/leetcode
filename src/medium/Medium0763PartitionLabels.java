package medium;

import java.util.ArrayList;
import java.util.List;

public class Medium0763PartitionLabels {
    public static void main(String[] args) {
        Medium0763PartitionLabels thisClass = new Medium0763PartitionLabels();
        List<Integer> f = thisClass.partitionLabels("ababcbacadefegdehijhklij");
        for (Integer i : f){
            System.out.println(i);
        }
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
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

    class Solution {
        public List<Integer> partitionLabels(String s) {
            int left = 0;
            int[] map = new int[26];
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a'] = i;
            }

            int start = 0;
            int last = 0;

            for (int i = 0; i < s.length(); i++) {
                last = Math.max(last, map[s.charAt(i) - 'a']);
                if (i == last) {
                    res.add(last + 1 - start);
                    start = last + 1;
                }
            }

            return res;
        }
    }
}