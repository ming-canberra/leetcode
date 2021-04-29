package easy;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {
    public static void main(String[] args) {
        ReorderDataInLogFiles thisClass = new ReorderDataInLogFiles();


    }

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myCom = new MyCom();
        Arrays.sort(logs, myCom);
        return logs;
    }

    class MyCom implements Comparator<String>{
        @Override
        public int compare(String s1, String s2){
            char charCom1 = s1.split(" ")[1].charAt(0);
            char charCom2 = s2.split(" ")[1].charAt(0);

            boolean isDigitS1 = charCom1 >= '0' && charCom1 <= '9';
            boolean isDigitS2 = charCom2 >= '0' && charCom2 <= '9';

            if (isDigitS1 && isDigitS2)
            {
                return 0;
            }
            else if (!isDigitS1 && isDigitS2)
            {
                return -1;
            }
            else if (isDigitS1 && !isDigitS2)
            {
                return 1;
            }
            else
            {
                String con1 = s1.substring(s1.indexOf(" ") + 1);
                String con2 = s2.substring(s2.indexOf(" ") + 1);

                int tempResult = con1.compareTo(con2);
                if (tempResult == 0){
                    String iden1 = s1.substring(0, s1.indexOf(" "));
                    String iden2 = s2.substring(0, s2.indexOf(" "));
                    return iden1.compareTo(iden2);
                }
                System.out.println(tempResult);
                return tempResult;
            }
        }
    }
}