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

    public class NestedIterator2 implements Iterator<Integer> {
        Stack<NestedInteger> stack;// to be filled backwards when filling a list.
        Integer nextInteger = null;
        public NestedIterator2(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; i--){
                stack.push(nestedList.get(i));
            }
            nextInteger = nextInt();
        }

        @Override
        public Integer next() {
            int tmp = nextInteger;
            nextInteger = nextInt();
            return tmp;
        }

        private Integer nextInt(){
            if (stack.isEmpty()){
                return null;
            }
            NestedInteger top = stack.pop();
            if (top.isInteger()){
                return top.getInteger();
            }
            else{
                List<NestedInteger> nestedList = top.getList();
                for (int i = nestedList.size() - 1; i >= 0; i--){
                    stack.push(nestedList.get(i));
                }
                return nextInt();
            }
        }

        @Override
        public boolean hasNext() {
            return nextInteger != null;
        }
    }
}