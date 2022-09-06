package medium;

public class Medium0043MultiplyStrings {
    class Solution {
        public String multiply(String num1, String num2) {
            if(num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int length2 = num2.length();
            int length1 = num1.length();
            int[][] arr = new int[length2][length1 + length2];

            for (int i = 0; i < length2; i++) {
                int integer2 = num2.charAt(length2 - 1 - i) - '0';

                int carry = 0;
                for (int j = 0; j < length1; j++) {
                    int integer1 = num1.charAt(length1 - 1 -j) - '0';

                    int product = (integer1 * integer2) + carry ;
                    arr[i][length1 + length2 - 1 - i - j] = product % 10;
                    carry = product / 10;

                }
                arr[i][length1 + length2 - 1 - i - length1] =  carry;
            }


            StringBuilder sb = new StringBuilder();
            //loop backwards of arr, append to sb
            int carry = 0;
            for (int i = length1 + length2 - 1; i >= 0; i--) {
                int sum = carry;
                for (int rowIdx = 0; rowIdx < length2; rowIdx++) {
                    sum += arr[rowIdx][i];
                }
                if (i == 0) {
                    if (sum == 0) {
                        continue;
                    }
                }
                sb.append(sum % 10);
                carry = sum / 10;
            }

            return sb.reverse().toString();
        }
    }
}