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

    /**
     * the trick here is to make the new element going through both heaps to balance the 2 heaps
     * */
    class MedianFinder2 {
        PriorityQueue<Integer> minH;
        PriorityQueue<Integer> maxH;
        /** initialize your data structure here. */
        public MedianFinder2() {
            minH = new PriorityQueue<>();
            maxH = new PriorityQueue<>((a, b)-> b - a);
        }
        public void addNum(int num) {
            minH.add(num);
            maxH.add(minH.poll());
            if (maxH.size() - minH.size() > 1)
            {
                minH.add(maxH.poll());
            }
        }

        public double findMedian() {
            if (maxH.size() - minH.size() > 0){
                return maxH.peek();
            }
            else{
                return (maxH.peek() + minH.peek()) * 0.5;
            }
        }
    }
}