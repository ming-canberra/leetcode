package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
    public static void main(String[] args) {
        PascalsTriangleII119 thisClass = new PascalsTriangleII119();
        System.out.println(" " + thisClass.getRow(3));
    }
    public List<Integer> getRow(int rowIndex) {

        List<Integer> ans = new ArrayList<Integer>();
        ans.add(1);
        for (int i = 1 ; i <= rowIndex; i++){

            //do it within a row
            int lastRowMinusOneValue = 1;
            for (int j = 1; j <i;j++){
                int tmp = ans.get(j);
                ans.set(j, ans.get(j) + lastRowMinusOneValue);
                lastRowMinusOneValue = tmp;
            }

            ans.add(1);
        }

        return ans;
    }


}