package medium;

import java.util.*;

public class KthSmallestElementInASortedMatrix378 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b)->a[0] - b[0]);
            for (int i = 0; i < matrix.length; i++){
                heap.add(new int[]{matrix[i][0], i, 0});
            }
            for (int i = 0; i < k - 1; i++){
                int rowIndex = heap.peek()[1];
                int columnIndex = heap.poll()[2];
                if (columnIndex < matrix.length - 1){
                    columnIndex++;
                    heap.add(new int[]{matrix[rowIndex][columnIndex], rowIndex, columnIndex});
                }
            }
            return heap.peek()[0];
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((a, b)->a[2] - b[2] );// row col value
        for (int i = 0; i < matrix.length; i++){
            heap.add(new Integer[]{i, 0, matrix[i][0]});
        }
        for (int i = 1; i <= k; i++){
            Integer[] top = heap.poll();
            if (top[1] + 1 < matrix.length){
                heap.add(new Integer[]{top[0], top[1] + 1, matrix[top[0]][top[1] + 1]});
            }
            if (i == k){
                return top[2];
            }
        }
        return 0;
    }
}