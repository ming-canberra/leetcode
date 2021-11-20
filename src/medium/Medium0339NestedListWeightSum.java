package medium;

import java.util.*;

public class Medium0339NestedListWeightSum {

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
        public int depthSum(List<NestedInteger> nestedList) {
            int result = 0;
            Queue<NestedInteger> queue = new LinkedList<>();
            for (NestedInteger ni : nestedList)
            {
                queue.add(ni);
            }
            int depth = 1;
            while(!queue.isEmpty()){
                for (int size = queue.size(); size > 0; size--){
                    NestedInteger top = queue.poll();
                    if (top.isInteger()){
                        result += top.getInteger() * depth;
                    }
                    else{
                        for (NestedInteger ni : top.getList())
                        {
                            queue.add(ni);
                        }
                    }
                }
                depth++;
            }
            return result;
        }
    }
}