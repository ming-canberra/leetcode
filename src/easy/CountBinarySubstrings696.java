package easy;

import java.util.Arrays;

public class CountBinarySubstrings696 {
    public static void main(String[] args) {
        CountBinarySubstrings696 thisClass = new CountBinarySubstrings696();

        System.out.println(thisClass.countBinarySubstrings("00110"));
    }

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();

        int zeroPrefix0Counter = 0;
        int zeroPrefix1Counter = 0;

        int onePrefix0Counter = 0;
        int onePrefix1Counter = 0;

        int toReturn = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '0') {
                //counting zeroPrefix String
                if (zeroPrefix0Counter > 0) {
                    if (zeroPrefix1Counter == 0) {
                        zeroPrefix0Counter++;
                    } else {
                        toReturn += Math.min(zeroPrefix0Counter, zeroPrefix1Counter) ;

                        zeroPrefix0Counter = 1;
                        zeroPrefix1Counter = 0;
                    }
                } else if (zeroPrefix0Counter == 0) {
                    zeroPrefix0Counter++;
                }

                // counting onePrefix string
                if (onePrefix1Counter > 0) {
                    onePrefix0Counter++;
                }
            } else {
                //counting zeroPrefix String
                if (zeroPrefix0Counter > 0) {
                    zeroPrefix1Counter++;
                }
                // counting onePrefix string
                if (onePrefix1Counter > 0) {
                    if (onePrefix0Counter == 0) {
                        onePrefix1Counter++;
                    } else {
                        toReturn += Math.min(onePrefix1Counter, onePrefix0Counter);

                        onePrefix1Counter = 1;
                        onePrefix0Counter = 0;
                    }
                } else if (onePrefix1Counter == 0) {
                    onePrefix1Counter++;
                }
            }

        }
        toReturn += Math.min(zeroPrefix0Counter, zeroPrefix1Counter) ;
        toReturn += Math.min(onePrefix1Counter, onePrefix0Counter);
        return toReturn;
    }
}