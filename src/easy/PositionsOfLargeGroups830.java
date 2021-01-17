package easy;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups830 {
    public static void main(String[] args) {
        PositionsOfLargeGroups830 thisClass = new PositionsOfLargeGroups830();

        System.out.println(thisClass.largeGroupPositions("dasd"));
    }
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        char[] chars = s.toCharArray();

        Character c = null;
        int start = -1;
        int end = -1;

        for (int i = 0; i < s.length(); i++ ){
            if (c == null){
                c = chars[i];
                start = i;
                end = i;
            }
            else{
                if (chars[i] != c){
                    // add it or not
                    if (end-start >=2){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(start);
                        l.add(end);
                        result.add(l);
                    }

                    c = chars[i];
                    start = i;
                    end = i;
                }
                else{
                    end++;
                }
            }
        }

        if (end-start >=2){
            List<Integer> l = new ArrayList<Integer>();
            l.add(start);
            l.add(end);
            result.add(l);
        }

        return result;
    }

}