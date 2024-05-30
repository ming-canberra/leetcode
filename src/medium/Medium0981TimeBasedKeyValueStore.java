package medium;

import java.util.*;

public class Medium0981TimeBasedKeyValueStore {
    public static void main(String[] args) {
        Medium0981TimeBasedKeyValueStore thisClass = new Medium0981TimeBasedKeyValueStore();
    }
    class TimeMap {
        class Info{
            Integer timestamp;
            String value;
            Info(Integer time, String iValue)
            {
                timestamp = time;
                value = iValue;
            }
        }

        private HashMap<String, List<Info>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<String, List<Info> >();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key))
            {
                map.put(key, new ArrayList<Info>());
            }
            map.get(key).add(new Info(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)){
                List<Info> list = map.get(key);
                if (list.get(0).timestamp > timestamp){
                    return "";
                }
                else{

                    if (list.size() == 1){
                        return list.get(0).value;
                    }

                    int l = 0;
                    int r = list.size() - 1;

                    while (l < r){
                        int m = l + (r - l) / 2;

                        if (list.get(m).timestamp == timestamp){
                            return list.get(m).value;
                        }
                        else if (list.get(m + 1).timestamp == timestamp){
                            return list.get(m + 1).value;
                        }
                        else if (list.get(m).timestamp > timestamp){
                            r = m;
                        }
                        else{
                            if (list.get(m + 1).timestamp > timestamp){
                                return list.get(m).value;
                            }
                            else{
                                l = m + 1;
                            }
                        }
                    }
                    return list.get(l).value;
                }
            }

            return "";
        }

    }
    class TimeMap1 {
        public TimeMap1() {
        }
        Map<String, List<Pair>> map = new HashMap<>();
        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Pair(timestamp, value) );
        }
        public String get(String key, int timestamp) {
            if (map.containsKey(key)){
                List<Pair> list = map.get(key);
                int left = -1;
                int right = list.size();
                while(left + 1 < right){
                    int m = (left + right) / 2;
                    if (list.get(m).time <= timestamp){
                        left = m;
                    }
                    else{
                        right = m;
                    }
                }
                if (left == -1){
                    return "";
                }
                else{
                    return list.get(left).value;
                }
            }
            return "";
        }
        class Pair{
            int time = 0;
            String value = "";
            public Pair(int t, String v){
                time = t;
                value = v;
            }
        }
    }

    private class TimeMapTreeMap {

        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        public TimeMapTreeMap() {

        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                TreeMap<Integer, String> treeMap = map.get(key);
                Integer floor = treeMap.floorKey(timestamp);
                if (floor == null) {
                    return "";
                }
                return treeMap.get(floor);
            }

            return "";
        }
    }

    class TimeMapBinarySearch {
        Map<String, List<Pair>> map = new HashMap<>();
        public TimeMapBinarySearch() {
        }
        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Pair(timestamp, value));
        }
        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                List<Pair> list = map.get(key);
                int left = -1;
                int right = list.size();
                while (left + 1 < right) {
                    int mid = left + (right - left) / 2;
                    if (list.get(mid).timestamp > timestamp) {
                        right = mid;
                    }
                    else {
                        left = mid;
                    }
                }
                if (left == -1) {
                    return "";
                }
                return list.get(left).value;
            }
            return "";
        }
        private class Pair{
            Pair(int timestamp, String value)
            {
                this.value = value;
                this.timestamp = timestamp;
            }
            int timestamp;
            String value;
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}