# leetcode submit region begin(Prohibit modification and deletion)
import collections


class Twitter:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.follows = collections.defaultdict(set)
        self.tweets = collections.defaultdict(list)
        self.time = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        """
        Compose a new tweet.
        """
        self.time += 1
        self.tweets[userId].append((self.time, tweetId))
        self.follow(userId, userId)

    def getNewsFeed(self, userId: int):
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
        users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        """
        tweets = []
        for user in self.follows[userId]:
            tweets.extend(self.tweets[user])
        return [tweetId for _, tweetId in sorted(tweets, reverse=True)[:10]]

    def follow(self, followerId: int, followeeId: int) -> None:
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        """
        self.follows[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        """
        self.follows[followerId].discard(followeeId)

# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
# leetcode submit region end(Prohibit modification and deletion)
