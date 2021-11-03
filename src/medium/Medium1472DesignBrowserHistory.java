package medium;

import java.util.*;

public class Medium1472DesignBrowserHistory {
    class BrowserHistory {
        List<String> list = new ArrayList<>();
        int curIndex = 0;
        int maxIndex = 0;
        public BrowserHistory(String homepage) {
            list.add(homepage);
        }
        public void visit(String url) {
            curIndex++;
            maxIndex = curIndex;
            if (maxIndex < list.size()){
                list.set(maxIndex, url);
            }
            else{
                list.add(url);
            }
        }
        public String back(int steps) {
            if (curIndex - steps < 0 ){
                curIndex = 0;
            }
            else{
                curIndex -= steps;
            }
            return list.get(curIndex);
        }
        public String forward(int steps) {
            if (curIndex + steps > maxIndex ){
                curIndex = maxIndex;
            }
            else{
                curIndex += steps;
            }
            return list.get(curIndex);
        }
    }

}