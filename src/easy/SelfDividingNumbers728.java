package easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers728 {
    public static void main(String[] args) {
        SelfDividingNumbers728 thisClass = new SelfDividingNumbers728();

        System.out.println(thisClass.selfDividingNumbers(3,4));
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i= left; i <= right; i++)
        {
            String intString = ((Integer)i).toString();
            boolean toAddToResult = true;
            for (int j = 0; j < intString.length(); j++){
                Integer div = new Integer (intString.substring(j, j+1));
                if (div == 0){
                    toAddToResult = false;
                    break;
                }
                else{
                    if (i % div != 0){
                        toAddToResult = false;
                        break;
                    }
                }
            }

            if (toAddToResult){
                result.add(i);
            }
        }
        return result;
    }
}