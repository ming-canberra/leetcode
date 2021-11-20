package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Medium0364NestedListWeightSumII {

     // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      public interface NestedInteger {
         // Constructor initializes an empty nested list.

         // Constructor initializes a single integer.

         // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger();

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger();

          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value);

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni);

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return empty list if this NestedInteger holds a single integer
          public List<NestedInteger> getList();
      }

    class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            Queue<NestedInteger> queue = new LinkedList<>();
            int maxDepth = 0;

            for (NestedInteger ni : nestedList){
                queue.add(ni);
            }

            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    NestedInteger top = queue.poll();
                    for (NestedInteger ni : top.getList()){
                        queue.add(ni);
                    }
                }
                maxDepth++;
            }

            for (NestedInteger ni : nestedList){
                queue.add(ni);
            }
            int curDepth = 1;
            int result = 0;
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    NestedInteger top = queue.poll();
                    if (top.isInteger()){
                        result += (maxDepth - curDepth + 1) * top.getInteger();
                    }
                    else{
                        for (NestedInteger ni : top.getList()){
                            queue.add(ni);
                        }
                    }
                }
                curDepth++;
            }

            return result;
        }
    }

}