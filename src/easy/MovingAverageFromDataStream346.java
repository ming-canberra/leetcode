package easy;

import java.util.*;

public class MovingAverageFromDataStream346 {
    class MovingAverage {

        /** Initialize your data structure here. */

        int size = 0;
        Queue<Integer> q;
        public MovingAverage(int size) {
            q = new LinkedList<>();
            this.size = size;
        }
        int sum = 0;
        public double next(int val) {
            if (q.size() < this.size){
                q.add(val);
                sum += val;
                return sum * 1.0 / q.size();
            }
            else{
                sum -= q.peek();
                sum += val;
                q.poll();
                q.add(val);
                return sum * 1.0 / q.size();
            }
        }
    }
}