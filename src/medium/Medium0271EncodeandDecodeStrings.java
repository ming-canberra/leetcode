package medium;

import java.util.*;

public class Medium0271EncodeandDecodeStrings {
    public class Codec {
        public String encode(List<String> strs) {
            String toReturn = "";
            for (String ss : strs){
                String intString = "";
                for (char cc : ss.toCharArray()){
                    intString = intString + (int)cc + "#";
                }
                if (intString.length() > 0){
                    intString = intString.substring(0, intString.length() - 1);
                }
                toReturn = toReturn + intString + ",";
            }
            String tmp = toReturn.substring(0, toReturn.length() - 1);
            return tmp;
        }
        public List<String> decode(String s) {
            String[] sItems = s.split(",", -1);
            List<String> result = new ArrayList<>();
            for (String sItem : sItems){
                String[] charItems = sItem.split("#", -1);
                StringBuilder sb = new StringBuilder("");
                for(String charItem : charItems){
                    if (charItem.equals("")){
                        sb.append("");
                    }
                    else{
                        int theInt = Integer.valueOf(charItem);
                        sb.append( (char)theInt );
                    }
                }
                result.add(sb.toString());
            }
            return result;
        }


    }
}