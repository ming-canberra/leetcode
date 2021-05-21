package medium;

import java.util.*;

public class TimeBasedKeyValueStore981 {
    public static void main(String[] args) {
        TimeBasedKeyValueStore981 thisClass = new TimeBasedKeyValueStore981();
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

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}