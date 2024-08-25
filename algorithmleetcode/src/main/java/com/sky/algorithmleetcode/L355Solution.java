package com.sky.algorithmleetcode;

/*
设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能
：  	postTweet(userId, tweetId): 创建一条新的推文 	getNewsFeed(userId): 检索最近的十条推文。每个推文都必须
是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。 	follow(followerId, followeeId): 关注一个用户 
	unfollow(followerId, followeeId): 取消关注一个用户  示例:  Twitter twitter = new Twitter(
); // 用户1发送了一条新推文 (用户id = 1, 推文id = 5). twitter.postTweet(1, 5); // 用户1的获取推文应当返回
一个列表，其中包含一个id为5的推文. twitter.getNewsFeed(1); // 用户1关注了用户2. twitter.follow(1, 2); 
// 用户2发送了一个新推文 (推文id = 6). twitter.postTweet(2, 6); // 用户1的获取推文应当返回一个列表，其中包含两个推文
，id分别为 -> [6, 5]. // 推文id6应当在推文id5之前，因为它是在5之后发送的. twitter.getNewsFeed(1); // 用户1
取消关注了用户2. twitter.unfollow(1, 2); // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文. // 因为用户1已经不
再关注用户2. twitter.getNewsFeed(1);
*/

import java.util.*;



public class L355Solution {
    class Tweet {
        private int tweetId;
        private int timeStamp;

        public Tweet(int tweetId, int timeStamp) {
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }

        public int getTweetId() {
            return tweetId;
        }

        public int getTimeStamp() {
            return timeStamp;
        }
    }

    private Map<Integer, List<Tweet>> userTweets;
    private Map<Integer, Set<Integer>> userFollowers;
    private int timeStamp;

    /** Initialize your data structure here. */
    public L355Solution() {
        userTweets = new HashMap<>();
        userFollowers = new HashMap<>();
        timeStamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }
        userTweets.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.getTimeStamp() - t1.getTimeStamp());
        Set<Integer> followees = userFollowers.containsKey(userId) ? userFollowers.get(userId) : new HashSet<>();
        followees.add(userId);
        for (int followeeId : followees) {
            List<Tweet> tweets = userTweets.getOrDefault(followeeId, new ArrayList<>());
            for (int i = Math.max(0, tweets.size() - 10); i < tweets.size(); i++) {
                pq.offer(tweets.get(i));
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll().getTweetId());
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userFollowers.containsKey(followerId)) {
            userFollowers.put(followerId, new HashSet<>());
        }
        userFollowers.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userFollowers.containsKey(followerId)) {
            userFollowers.get(followerId).remove(followeeId);
        }
    }
} 