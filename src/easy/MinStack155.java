package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class MinStack155 {
    public static void main(String[] args) {
        MinStack155 thisClass = new MinStack155();
    }

    public MinStack155() {
    }

    private Integer _min = Integer.MAX_VALUE;
    private List<Integer> theList = new ArrayList<Integer>();

    public void push(int x) {
        theList.add(x);
        _min = Math.min(_min, x);
    }

    public void pop() {
        theList.remove(theList.size() - 1);
        _min = Integer.MAX_VALUE;
        for (int i : theList){
            _min = Math.min(i, _min);
        }
    }

    public int top() {
        return theList.get(theList.size() - 1);
    }

    public int getMin() {
        return _min;
    }
}