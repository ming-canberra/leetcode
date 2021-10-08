package medium;
import java.util.*;

public class Hard0632SmallestRangeCoveringElementsfromKLists {
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            PriorityQueue<Triplet> heap = new PriorityQueue<Triplet>( (a, b)-> a.value == b.value ?
                    (nums.get(b.listIndex).size() - b.elementIndex) - (nums.get(a.listIndex).size() - a.elementIndex) :
                    a.value - b.value );// min
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.size(); i++){
                heap.add(new Triplet(i, 0, nums.get(i).get(0) ) );
                min = Math.min(min, nums.get(i).get(0));
                max = Math.max(max, nums.get(i).get(0));
            }
            int[] result = new int[]{min, max};
            while(!heap.isEmpty()){
                Triplet top = heap.poll();
                if ( nums.get(top.listIndex).size() - 1 ==  top.elementIndex ){
                    break;
                }
                else{
                    int nextValue = nums.get(top.listIndex).get(top.elementIndex + 1);
                    heap.add(new Triplet(top.listIndex, top.elementIndex + 1, nextValue));
                    max = Math.max(max, nextValue);
                    Triplet newTop = heap.peek();
                    int curMin = nums.get(newTop.listIndex).get(newTop.elementIndex);
                    if (max - curMin < result[1] - result[0]){
                        // new result;
                        result = new int[]{curMin, max};
                    }
                    else if (max - curMin == result[1] - result[0]){
                        if (curMin < result[0]){
                            //new result
                            result = new int[]{curMin, max};
                        }
                    }
                }
            }
            return result;
        }
        class Triplet{
            int listIndex = 0;
            int elementIndex = 0;
            int value = 0;
            public Triplet(int l, int e, int v){
                listIndex = l;
                elementIndex = e;
                value = v;
            }
        }
    }
}