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

    public class Codec1 {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String sValue : strs){
                if (sValue.length() == 0){
                    sb.append(",");
                }
                for (int i = 0; i < sValue.length(); i++){
                    sb.append((int)sValue.charAt(i));
                    sb.append(",");
                }
                sb.append("#");
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> rlt = new ArrayList<>();
            String[] words = s.split("#");

            for (String sValue : words){
                StringBuilder sb = new StringBuilder();
                String[] chars = sValue.split(",");

                for (String charIntValue : chars){
                    if (charIntValue.equals("")){
                        sb.append("");
                    }
                    else{
                        Integer integerOb = Integer.valueOf(charIntValue);
                        sb.append( (char)integerOb.intValue() );
                    }
                }

                rlt.add(sb.toString());
            }



            return rlt;
        }
    }

    public class Codec3 {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String s : strs){
                int len = s.length();
                sb.append(len).append("/").append(s);
            }
            return sb.toString();
        }
        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> rlt = new ArrayList<>();
            while(s.length() > 0){
                int slashIdx = s.indexOf("/");
                int len = Integer.valueOf(s.substring(0, slashIdx));
                rlt.add(s.substring(slashIdx + 1, slashIdx + 1 + len));
                s = s.substring(slashIdx + 1 + len);
            }
            return rlt;
        }
    }
}