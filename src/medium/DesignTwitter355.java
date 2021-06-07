package medium;

import java.util.*;

public class DesignTwitter355 {

    class Twitter {
        int timer = 0;
        HashMap<Integer, HashSet<Integer>> followMap = new HashMap<>();
        HashMap<Integer, Queue<int[]>> tweetMap = new HashMap<>();// int[] first element for timer;

        /** Initialize your data structure here. */
        public Twitter() {
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            Queue<int[]> q = tweetMap.getOrDefault(userId, new LinkedList<>());
            if (q.size() == 10){
                q.poll();
            }
            q.add(new int[]{timer++, tweetId});
            tweetMap.put(userId, q);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<int[]> heap = new PriorityQueue<>( (a, b) -> a[0] - b[0] );
            List<Queue<int[]>> qList = new ArrayList<>();
            if (tweetMap.containsKey(userId)){
                qList.add(tweetMap.get(userId));
            }
            if (followMap.containsKey(userId)){
                HashSet<Integer> followed = followMap.get(userId);
                for (Integer i : followed){
                    if (tweetMap.containsKey(i)){
                        qList.add(tweetMap.get(i));
                    }
                }
            }
            for (Queue<int[]> q : qList){
                Iterator<int[]> iter = q.iterator();
                while (iter.hasNext()){
                    if (heap.size() == 10){
                        heap.poll();
                    }
                    heap.add(iter.next());
                }
            }
            List<Integer> result = new ArrayList<>();
            while(!heap.isEmpty()){
                result.add(heap.poll()[1]);
            }
            Collections.reverse(result);
            return result;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            HashSet<Integer> set = followMap.getOrDefault(followerId, new HashSet<Integer>());
            set.add(followeeId);
            followMap.put(followerId, set);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (followMap.containsKey(followerId)){
                HashSet<Integer> set = followMap.get(followerId);
                if (set.contains(followeeId)){
                    set.remove(followeeId);
                }
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

}