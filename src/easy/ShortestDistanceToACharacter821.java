package easy;

public class ShortestDistanceToACharacter821 {
    public static void main(String[] args) {
        ShortestDistanceToACharacter821 thisClass = new ShortestDistanceToACharacter821();
        System.out.println(thisClass.shortestToChar2("loveleetcode",'e'));
    }
    public int[] shortestToChar2(String s, char c) {
        int[] ans = new int[s.length()];

        int prev = Integer.MIN_VALUE/2;
        for (int i = 0; i < s.length(); i++){
            if (s.toCharArray()[i] == c){
                prev = i;
            }
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE/2;
        for (int i = s.length() -1 ; i >=0; i--){
            if (s.toCharArray()[i] == c){
                prev = i;
            }
            ans[i] = Math.min(prev - i, ans[i]);
        }

        for (int i : ans){
            System.out.println(i);
        }
        return ans;
    }
        public int[] shortestToChar(String s, char c) {

        int[] result = new int[s.length()];

        int lastZeroIndex = 0;
        boolean startingZero = true;

        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length();i++){
            if (chars[i] == c){
                result[i] = 0;
                if (startingZero == true){
                    for (int j = i - 1; j >= 0; j --){
                        result[j] = i - j;
                    }
                    startingZero = false;
                }
                else{
                    for (int j = lastZeroIndex + 1; j < i; j++){
                        if ( j <= lastZeroIndex + (i - lastZeroIndex)/2){
                            result[j] = j - lastZeroIndex;
                        }
                        else{
                            result[j] = i-j;
                        }
                    }
                }
                lastZeroIndex = i;
            }

            if (i == s.length() - 1){
                for (int j = s.length() - 1; j> lastZeroIndex; j--){
                    result[j] = j - lastZeroIndex;
                }
            }
        }

        for (int i : result){
            System.out.println(i);
        }
        return result;
    }
}