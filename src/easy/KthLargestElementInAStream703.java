package easy;

import java.util.*;

public class KthLargestElementInAStream703 {
    class KthLargest {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int size = 0;
        public KthLargest(int k, int[] nums) {
            size = k;
            if (nums.length == 0){
                return;
            }
            Arrays.sort(nums);
            for (int i = 0; i < k; i++){
                if (nums.length - 1 - i >= 0 && nums.length - 1 - i < nums.length){
                    heap.add(nums[nums.length - 1 - i]);
                }

            }
        }
        public int add(int val) {
            heap.add(val);
            if (heap.size() > size){
                heap.remove();
            }

            return heap.peek();
        }
    }
}