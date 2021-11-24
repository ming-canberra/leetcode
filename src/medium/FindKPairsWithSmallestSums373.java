package medium;

import java.util.*;

public class FindKPairsWithSmallestSums373 {

    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> result = new ArrayList<>();
            PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b)->nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]] );
            heap.add(new int[]{0 , 0});
            int m = nums1.length;
            int n = nums2.length;
            boolean[][] visited = new boolean[m][n];
            while(!heap.isEmpty() && result.size() != k){
                int[] top = heap.poll();
                result.add(Arrays.asList(nums1[top[0]], nums2[top[1]]));
                int[] cur1 = new int[]{top[0], top[1] + 1};
                int[] cur2 = new int[]{top[0] + 1, top[1]};
                if (top[0] == m - 1 && top[1] == n - 1){

                }
                else if (top[0] == m - 1){
                    addElementToHeap(cur1, visited, heap);
                }
                else if (top[1] == n - 1){
                    addElementToHeap(cur2, visited, heap);
                }
                else {
                    addElementToHeap(cur1, visited, heap);
                    addElementToHeap(cur2, visited, heap);
                }
            }
            return result;
        }
        private void addElementToHeap(int[] cur, boolean[][] visited, PriorityQueue<int[]> heap){
            if (!visited[cur[0]][cur[1]]){
                visited[cur[0]][cur[1]] = true;
                heap.add(cur);
            }
        }
    }

    class SolutionNotOptimal {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> result = new ArrayList<>();
            PriorityQueue<Integer[]> heap = new PriorityQueue<>( (a, b)->b[0] + b[1] - a[0] - a[1] );
            for (int i = 0; i < nums1.length && i <= k; i++){
                for (int j = 0; j < nums2.length && j <= k; j++){
                    heap.add(new Integer[]{nums1[i], nums2[j]});
                    if (heap.size() > k){
                        heap.poll();
                    }
                }
            }
            while(!heap.isEmpty()){
                result.add(Arrays.asList(heap.poll()));
            }
            return result;
        }
    }

    class Solution1 {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> result = new ArrayList<>();
            PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b)-> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]) );
            heap.add(new int[]{0, 0});
            Set<Long> visited = new HashSet<>();
            long numOfRows = nums1.length;
            while(!heap.isEmpty()){
                int[] top = heap.poll();
                int idx1 = top[0];
                int idx2 = top[1];
                if (!visited.contains(new Long(idx2 * numOfRows + idx1))){
                    visited.add(new Long(idx2 * numOfRows + idx1));
                    result.add( Arrays.asList(new Integer[]{nums1[top[0]], nums2[top[1]]})  );
                    if (result.size() == k){
                        return result;
                    }
                    if (top[1] + 1 < nums2.length){
                        heap.add(new int[]{top[0],  top[1] + 1});
                    }
                    if (top[0] + 1 < nums1.length){
                        heap.add(new int[]{top[0] + 1,  top[1]});
                    }
                }
            }
            return result;
        }
    }
}