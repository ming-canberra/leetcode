package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public static void main(String[] args) {
        PascalsTriangle118 thisClass = new PascalsTriangle118();
        System.out.println(" " + thisClass.generate(2));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++){
            List <Integer> row = new ArrayList<Integer>();
            List <Integer> prevRow =null;
            if (i >0){
                prevRow = ans.get(i - 1);
            }
            for (int j = 0; j <= i; j ++){
                if (j == 0 || j ==i){
                    row.add(1);
                }
                else{
                    row.add(prevRow.get(j) + prevRow.get(j - 1));
                }
            }
            ans.add(row);
        }
        return ans;
    }
}