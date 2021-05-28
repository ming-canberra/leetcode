package medium;

public class RemoveKDigits402 {
    StringBuilder sb = new StringBuilder();

    public String removeKdigits(String num, int k) {
        recur(num, k);
        String result = sb.toString();
        if (result.isEmpty()){
            return "0";
        }

        // to remove leading 0
        int i = -1;
        while(i + 1 < result.length() && result.charAt(i + 1) == '0'){
            i++;
        }
        if (i + 1 < result.length()){
            result = result.substring(i + 1);
            return result;
        }
        else{
            return "0";
        }
    }

    public void recur(String num, int k) {
        // search for the smallest during the first k + 1 char
        if (k == 0){
            sb.append(num);
            return;
        }
        int length = num.length();
        if (k >= length) {
            sb.append("");
            return;
        }
        int minIndex = 0; // first index of min if there are multiple
        int min = 9;
        for (int i = 0; i <= k; i++){
            if (num.charAt(i) == '0'){
                if (i + 1 == length){
                    sb.append("0");
                    return;
                }
                else{
                    sb.append("0");
                    recur(num.substring(i + 1), k - i);
                    return;
                }
            }
            else{
                if (num.charAt(i) - '0' < min){
                    min = num.charAt(i) - '0';
                    minIndex = i;
                }
            }
        }

        if (minIndex + 1 == length){
            sb.append(min);
        }
        else{
            sb.append(min);
            recur(num.substring(minIndex + 1), k - minIndex);
        }
    }
}