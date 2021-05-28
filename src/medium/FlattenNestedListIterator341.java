package medium;

import java.util.*;

public class FlattenNestedListIterator341 {
 public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
 }

    /**
     * this is not an iterator.
     * Iterator should not make a copy of the data and store it all
     *
     * */
    public class NestedIterator1 implements Iterator<Integer> {

        List<Integer> list = new ArrayList<>();
        int index = 0;
        public NestedIterator1(List<NestedInteger> nestedList) {
            for (NestedInteger n : nestedList){
                fill(n, list);
            }
        }

        private void fill(NestedInteger nestedInteger, List<Integer> list){
            if (!nestedInteger.isInteger()){
                List<NestedInteger> nestedList = nestedInteger.getList();
                for (NestedInteger n : nestedList){
                    fill(n, list);
                }
            }
            else{
                list.add(nestedInteger.getInteger());
            }
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }
    }
}