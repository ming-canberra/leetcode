package medium;

public class Medium0161OneEditDistance {
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if (s.length() == t.length()){
                int charDiffs = 0;
                for (int i = 0; i < s.length(); i++){
                    if (s.charAt(i) != t.charAt(i)){
                        charDiffs++;
                    }
                }
                return charDiffs == 1;
            }
            else{
                // make sure s is the long one
                if (s.length() < t.length()){
                    return isOneEditDistance(t, s);
                }
                // make sure s is always 1 char longer than t;
                if (s.length() != t.length() + 1){
                    return false;
                }

                int sIdx = 0;
                int tIdx = 0;

                while(sIdx < s.length() && tIdx < t.length() && s.charAt(sIdx) == t.charAt(tIdx)){
                    sIdx++;
                    tIdx++;
                }

                if (tIdx >= t.length()){
                    return true;
                }
                sIdx++;

                while(sIdx < s.length() && tIdx < t.length() && s.charAt(sIdx) == t.charAt(tIdx)){
                    sIdx++;
                    tIdx++;
                }

                return sIdx == s.length() && tIdx == t.length();
            }
        }
    }
}