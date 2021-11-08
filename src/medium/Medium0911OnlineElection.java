package medium;

import java.util.*;

public class Medium0911OnlineElection {
    class TopVotedCandidate {

        int[] topCandidate;
        int[] times;
        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            int len = times.length;
            topCandidate = new int[len];

            Map<Integer, Integer> candidatesCount = new HashMap<>();
            int maxVote = -1;
            int maxVoteCandidate = -1;
            for (int i = 0; i < len; i++){
                int curCount = candidatesCount.getOrDefault(persons[i], 0) + 1;
                candidatesCount.put(persons[i], curCount);

                if (curCount >= maxVote){
                    maxVote = curCount;
                    maxVoteCandidate = persons[i];
                }

                topCandidate[i] = maxVoteCandidate;
            }
        }

        public int q(int t) {
            // binary search, find the idx of times so that times[i] == t or closest to t and less than t
            int left = -1;
            int right = times.length;
            while(left + 1 < right){
                int m = (left + right) / 2;
                if (times[m] == t){
                    return topCandidate[m];
                }
                else if (times[m] < t){
                    left = m;
                }
                else{
                    right = m;
                }
            }
            return topCandidate[left];
        }
    }

}