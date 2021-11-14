package medium;

import java.util.*;

public class Medium1057CampusBikes {
    class Solution {
        public int[] assignBikes(int[][] workers, int[][] bikes) {
            int wLen = workers.length;
            int bLen = bikes.length;

            Set<Integer> bUsed = new HashSet<>();

            PriorityQueue<Triplet> heap = new PriorityQueue<>(new MyCom());

            for (int i = 0; i < wLen; i++){
                for (int j = 0; j < bLen; j++){
                    int curDis = Math.abs(bikes[j][0] - workers[i][0]) + Math.abs(bikes[j][1] - workers[i][1]);
                    heap.add(new Triplet(curDis, i, j));
                }
            }
            int[] result = new int[wLen];

            Arrays.fill(result, -1);

            while(!heap.isEmpty()){
                Triplet top = heap.poll();
                if (result[top.wIdx] == -1 && !bUsed.contains(top.bIdx)){
                    result[top.wIdx] = top.bIdx;
                    bUsed.add(top.bIdx);
                }
            }
            return result;
        }
        class MyCom implements Comparator<Triplet>{
            @Override
            public int compare(Triplet a, Triplet b){
                if (a.distance == b.distance){
                    if (a.wIdx == b.wIdx){
                        return a.bIdx - b.bIdx;
                    }
                    else{
                        return a.wIdx - b.wIdx;
                    }
                }
                else{
                    return a.distance - b.distance;
                }
            }
        }
        class Triplet{
            int distance = -1;
            int wIdx = -1;
            int bIdx = -1;
            public Triplet(int d, int w, int b){
                distance = d;
                wIdx = w;
                bIdx = b;
            }
        }
    }
}