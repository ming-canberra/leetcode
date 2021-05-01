package medium;

import java.util.HashSet;

public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman thisClass = new IntegerToRoman();

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