package medium;

import java.util.*;

public class IntegerToRoman {

    class Solution {
        public String intToRoman(int num) {
            int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < val.length; i++){
                while(num - val[i] >= 0){
                    num -= val[i];
                    sb.append(str[i]);
                }
                if (num == 0){
                    break;
                }
            }
            return sb.toString();
        }
    }

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        if (num / 1000 > 0)
        {
            for (int i = 1; i <= num / 1000; i++)
            {
                sb.append("M");
            }

            num = num % 1000;
        }

        if (num / 100 > 0)
        {
            int d = num / 100;
            if (d == 4)
            {
                sb.append("CD");
            }
            else if (d == 9)
            {
                sb.append("CM");
            }
            else{
                if (d >= 5){
                    sb.append("D");
                    d = d % 5;
                }
                for (int i = 1; i <= d; i++)
                {
                    sb.append("C");
                }
            }
            num = num % 100;
        }

        if (num / 10 > 0)
        {
            int d = num / 10;
            if (d == 4)
            {
                sb.append("XL");
            }
            else if (d == 9)
            {
                sb.append("XC");
            }
            else{
                if (d >= 5){
                    sb.append("L");
                    d = d % 5;
                }
                for (int i = 1; i <= d; i++)
                {
                    sb.append("X");
                }
            }
            num = num % 10;
        }

        if (num / 1 > 0)
        {
            int d = num / 1;
            if (d == 4)
            {
                sb.append("IV");
            }
            else if (d == 9)
            {
                sb.append("IX");
            }
            else{
                if (d >= 5){
                    sb.append("V");
                    d = d % 5;
                }
                for (int i = 1; i <= d; i++)
                {
                    sb.append("I");
                }
            }

        }

        return sb.toString();
    }
}