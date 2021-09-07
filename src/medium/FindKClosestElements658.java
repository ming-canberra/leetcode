package medium;

import java.util.*;

public class FindKClosestElements658 {
    public static void main(String[] args) {
        FindKClosestElements658 thisClass = new FindKClosestElements658();
    }
    /**
     *O(k + logN)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        //get the single closest
        int closestIndex = findSingleClosest(arr, x);
        int start = closestIndex;
        int end = closestIndex;
        // get k of them using two pointers technique
        for (int i = 1; i < k; i++){
            if (end == arr.length - 1){
                start--;
            }
            else if (start == 0){
                end++;
            }
            else{
                if (Math.abs(arr[start - 1] - x) <= Math.abs(arr[end + 1] - x))
                {
                    start--;
                }
                else{
                    end++;
                }
            }
        }
        for (int i = start; i <= end; i++){
            result.add(arr[i]);
        }
        return result;
    }
    private int findSingleClosest(int[] arr, int x){
        int l = 0;
        int r = arr.length - 1;
        if (x >= arr[r]){
            return r;
        }
        if (x <= arr[l]){
            return l;
        }
        while (l < r){
            int m = l + (r - l) / 2;
            if (arr[m] == x){
                return m;
            }
            else if (arr[l] == x){
                return l;
            }
            else if (arr[r] == x){
                return r;
            }
            else{
                if (l == m){
                    int lDis = Math.abs(arr[l] - x);
                    int rDis = Math.abs(arr[r] - x);
                    return lDis <= rDis ? l : r;
                }
                else{
                    if (arr[l] < x && x < arr[m]){
                        r = m;
                    }
                    else{
                        l = m;
                    }
                }
            }
        }
        return r;
    }

    /***
     * heap, N*log(k)
     */
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>( new MyCom(x)  );
            for (int a : arr){
                heap.add(a);
                if (heap.size() > k){
                    heap.poll();
                }
            }
            List<Integer> result = new ArrayList<>(heap);
            Collections.sort(result);
            return result;
        }
        class MyCom implements Comparator<Integer>{
            private int target;
            public MyCom(int t){
                target = t;
            }
            @Override
            public int compare(Integer a, Integer b){
                int aDiff = Math.abs(a - target);
                int bDiff = Math.abs(b - target);
                if (aDiff == bDiff){
                    return Integer.compare(b, a);
                }
                else{
                    return Integer.compare(bDiff, aDiff);
                }
            }
        }
    }
}