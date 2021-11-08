package easy;

import java.util.*;

public class Easy0359LoggerRateLimiter {
    class Logger {
        Map<String, Integer> map;
        public Logger() {
            map = new HashMap<>();
        }
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message)){
                int timeInserted  = map.get(message);
                if (timestamp < timeInserted + 10){
                    return false;
                }
                else{
                    map.put(message, timestamp);
                    return true;
                }
            }
            else{
                map.put(message, timestamp);
                return true;
            }
        }
    }
}