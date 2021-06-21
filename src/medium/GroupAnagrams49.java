package medium;

import java.util.*;

public class GroupAnagrams49 {
    /**
     * N
     * */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
            for (int i = 0; i < strs.length; i++){
                char[] charArray = strs[i].toCharArray();
                Arrays.sort(charArray);
                String key = new String(charArray);
                List<Integer> value = map.getOrDefault(key, new ArrayList<Integer>());
                value.add(i);
                map.put(key, value);
            }
            List<List<String>> result = new ArrayList<List<String>>();
            for (String key : map.keySet()){
                List<String> list = new ArrayList<String>();
                List<Integer> mapValue = map.get(key);
                for (int i : mapValue){
                    list.add(strs[i]);
                }
                result.add(list);
            }
            return result;
        }
    }

    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<String, List<String>>();

            for (int i = 0; i < strs.length; i++){
                char[] charArray = strs[i].toCharArray();
                Arrays.sort(charArray);
                String key = new String(charArray);
                List<String> value = map.getOrDefault(key, new ArrayList<String>());
                value.add(strs[i]);
                map.put(key, value);
            }

            return new ArrayList<>(map.values());
        }
    }
}