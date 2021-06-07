package hard;

import java.util.*;

public class FindMedianFromDataStream295 {
    class MedianFinder {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); // store big number
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b)->b - a); // store small number
        boolean even = true;
        /** initialize your data structure here. */
        public MedianFinder() {

        }
        public void addNum(int num) {
            if (!even){
                // minHeap always gets the new one due to the logic when even
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
            else{
                // maxHeap always get the extra num
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
            even = !even;
        }
        public double findMedian() {
            if (even){
                return (minHeap.peek() + maxHeap.peek()) * 0.5;
            }
            else{
                return maxHeap.peek();
            }
        }
    }
}