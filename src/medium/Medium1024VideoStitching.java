package medium;

import java.util.*;

public class Medium1024VideoStitching {
    class Solution {
        public int videoStitching(int[][] clips, int time) {
            Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]) );
            int count = 0;
            int endTime = 0;
            int clipsIdx = 0;
            while(endTime < time){
                int curMaxEndTime = endTime;
                while(clipsIdx < clips.length && clips[clipsIdx][0] <= endTime){
                    curMaxEndTime = Math.max(curMaxEndTime, clips[clipsIdx][1]);
                    clipsIdx++;
                }
                if (curMaxEndTime == endTime){
                    return -1;
                }
                endTime = curMaxEndTime;
                count++;
            }
            return count;
        }
    }

    class Solution1 {
        public int videoStitching(int[][] clips, int time) {
            Arrays.sort(clips, (a, b)-> (Integer.compare(a[0], b[0])) );
            int count = 0;
            int curEnd = 0;
            int nextEnd = 0;
            for (int i = 0; i < clips.length; i++){
                if (curEnd >= time){
                    return count;
                }
                if (nextEnd >= time){
                    return count + 1;
                }
                if (clips[i][0] <= curEnd){
                    nextEnd = Math.max(nextEnd, clips[i][1]);
                }
                else{
                    if (clips[i][0] > nextEnd){
                        return -1;
                    }
                    count++;
                    curEnd = nextEnd;
                    nextEnd = Math.max(nextEnd, clips[i][1]);
                }
            }
            if (curEnd >= time){
                return count;
            }
            if (nextEnd >= time){
                return count + 1;
            }
            return -1;
        }
    }
}