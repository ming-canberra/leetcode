package medium;

import java.util.*;

public class FurthestBuildingYouCanReach1642 {
    /**
     * time complexity is too bad. Also it took me more than an hour to finish this
     * */
    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            // binary search for the main loop
            // heap for the private method
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{-1, 0});
            for (int i = 1; i < heights.length; i++){
                if (heights[i] > heights[i - 1]){
                    list.add(new int[]{i, heights[i] - heights[i - 1]});
                }
            }

            int l = -1;
            int r = list.size();

            while(l + 1 < r){
                int m = l + (r - l) / 2;
                boolean canReachIt = canReach(list, m, bricks, ladders);
                if (canReachIt){
                    l = m;
                }
                else{
                    r = m;
                }
            }

            if (l + 1 < list.size()){
                return list.get(l + 1)[0] - 1;
            }

            return heights.length - 1;
        }

        private boolean canReach(List<int[]> list, int m, int bricks, int ladders){

            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b)->b[1] - a[1]);

            for (int i = 0; i <= m; i++){
                maxHeap.add(list.get(i));
            }
            while(!maxHeap.isEmpty()){
                int[] top = maxHeap.poll();
                if (ladders > 0){
                    ladders--;
                }
                else if (bricks - top[1] >= 0){
                    bricks = bricks - top[1];
                }
                else{
                    return false;
                }
            }

            return true;
        }
    }
}