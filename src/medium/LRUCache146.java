package medium;

import java.util.*;

public class LRUCache146 {
    class LRUCache {
        private Map<Integer, Set<Integer>> frequencyToKeys = new HashMap<Integer, Set<Integer>>();
        private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        private Map<Integer, Integer> keyToFrequency = new HashMap<Integer, Integer>();
        private int minFrequency = 0;
        private int mapCapacity = 0;
        public LRUCache(int capacity) {
            mapCapacity = capacity;
        }
        /**
         *  time O(1)
        * */
        public int get(int key) {
            if (map.containsKey(key)){
                keyToFrequency.put(key, keyToFrequency.get(key) + 1);

                int frequenceyBefore = keyToFrequency.get(key) - 1;
                //handling frequency before use
                Set<Integer> beforeUseSet = frequencyToKeys.get(frequenceyBefore);
                if (beforeUseSet.size() == 1){
                    frequencyToKeys.remove(frequenceyBefore);
                    if (frequenceyBefore == minFrequency){
                        minFrequency++;
                    }
                }
                else{
                    beforeUseSet.remove(key);
                }
                // handling frequency after use
                if (frequencyToKeys.containsKey(frequenceyBefore + 1)){
                    frequencyToKeys.get(frequenceyBefore + 1).add(key);
                }
                else{
                    Set<Integer> newSet = new HashSet<Integer>();
                    newSet.add(key);
                    frequencyToKeys.put(frequenceyBefore + 1, newSet);
                }

                return map.get(key);
            }
            return -1;
        }
        /**
         *  time O(1)
         * */
        public void put(int key, int value) {
            if (map.containsKey(key)){
                map.put(key, value);
            }
            else {
                //no-eviction
                map.put(key, value);
                keyToFrequency.put(key, 0);
                if (map.size() >= mapCapacity) {
                    // eviction
                    Set<Integer> leastUsedKeys = frequencyToKeys.get(minFrequency);
                    Integer keyToEvict = leastUsedKeys.iterator().next();
                    map.remove(keyToEvict);
                    keyToFrequency.remove(keyToEvict);
                    if (leastUsedKeys.size() == 1){
                        frequencyToKeys.remove(minFrequency);
                    }
                    else{
                        leastUsedKeys.remove(keyToEvict);
                    }
                }
                if (frequencyToKeys.containsKey(0)){
                    frequencyToKeys.get(0).add(key);
                }
                else{
                    Set<Integer> set0 = new HashSet<Integer>();
                    set0.add(key);
                    frequencyToKeys.put(0, set0);
                }
                minFrequency = 0;
            }
        }
    }



}