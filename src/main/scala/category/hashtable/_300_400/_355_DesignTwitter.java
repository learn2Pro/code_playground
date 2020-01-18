/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package category.hashtable._300_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 355. Design _355_DesignTwitter
 */
public class _355_DesignTwitter {

    private final AtomicInteger                              COUNTER     = new AtomicInteger(0);
    private final Map<Integer, Set<Integer>>                 FOLLOW_SHIP = new HashMap<>();
    private final Map<Integer, List<Pair<Integer, Integer>>> TWEET_DATUM = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public _355_DesignTwitter() {
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        List<Pair<Integer, Integer>> lst = TWEET_DATUM.getOrDefault(userId, new LinkedList<>());
        lst.add(0, new Pair<>(COUNTER.incrementAndGet(), tweetId));
        TWEET_DATUM.put(userId, lst);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user
     * followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> retrieveSet = FOLLOW_SHIP.getOrDefault(userId, new HashSet<>());
        retrieveSet.add(userId);
        List<Integer> retrieves = new ArrayList<>(retrieveSet);
        int N = retrieves.size();
        List<Integer> ans = new ArrayList<>();
        int[] pointers = new int[N];
        while (ans.size() < 10) {
            int maxIndex = -1, maxTweet = -1;
            int maxTs = 0;
            for (int i = 0; i < N; i++) {
                if (TWEET_DATUM.containsKey(retrieves.get(i)) && pointers[i] < TWEET_DATUM.get(retrieves.get(i)).size()) {
                    Pair<Integer, Integer> pair = TWEET_DATUM.get(retrieves.get(i)).get(pointers[i]);
                    if (pair.getFst() > maxTs) {
                        maxIndex = i;
                        maxTs = pair.getFst();
                        maxTweet = pair.getSnd();
                    }
                }
            }
            if (maxIndex == -1) { return ans; }
            ans.add(maxTweet);
            pointers[maxIndex] += 1;
        }
        return ans;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followShip = FOLLOW_SHIP.getOrDefault(followerId, new HashSet<>());
        followShip.add(followeeId);
        FOLLOW_SHIP.put(followerId, followShip);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followShip = FOLLOW_SHIP.getOrDefault(followerId, new HashSet<>());
        followShip.remove(followeeId);
        FOLLOW_SHIP.put(followerId, followShip);
    }

    static class Pair<F, S> {
        private F fst;
        private S snd;

        public Pair(F fst, S snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public F getFst() {
            return fst;
        }

        public S getSnd() {
            return snd;
        }
    }
}