import heapq
from typing import List

'''
["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
[[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
["Twitter","postTweet","getNewsFeed","follow","postTweet","postTweet","getNewsFeed","unfollow","getNewsFeed"]
[[],[1,5],[1],[1,2] ,[2,6],[2,7],[1],[1,2],[1]]
["Twitter","postTweet","getNewsFeed","follow","postTweet","postTweet","follow","postTweet","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"]
[[],[1,5],[1],[1,2],[2,6],[2,7],[2,3],[3,9],[1],[1,2],[1],[2]]
["Twitter","postTweet","getNewsFeed","getNewsFeed","follow","postTweet","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"]
[[],[1,5],[1],[2],[1,2],[2,6],[1],[2],[1,2],[1],[2]]
["Twitter","getNewsFeed","getNewsFeed","follow","postTweet","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"]
[[],[1],[2],[1,2],[2,6],[1],[2],[1,2],[1],[2]]
["Twitter","follow","getNewsFeed"]
[[],[1,5],[1]]
["Twitter","postTweet","follow","getNewsFeed"]
[[],[1,5],[1,1],[1]]
["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
[[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1,22],[1,11],[1]]
["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
[[],[1,5],[2,3],[1,101],[2,13],[2,10],[1,2],[1,94],[2,505],[1,333],[2,22],[1,11],[1,205],[2,203],[1,201],[2,213],[1,200],[2,202],[1,204],[2,208],[2,233],[1,222],[2,211],[1],[1,2],[1],[1,2],[1]]
["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","postTweet","unfollow","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet","getNewsFeed","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet","getNewsFeed","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","unfollow","getNewsFeed","postTweet","postTweet","follow","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","unfollow","getNewsFeed","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","postTweet","unfollow","postTweet","postTweet","postTweet","getNewsFeed","postTweet","postTweet"]
[[],[11,994],[4,303],[1,113],[18,309],[8,905],[6,605],[1,210],[15,15],[1,88],[1,704],[8],[9,59],[4,851],[13,974],[2,133],[15,255],[15,662],[16,21],[13,227],[17],[5,603],[10,7],[5,816],[7,792],[12,260],[5],[4,586],[1,645],[20],[15,171],[16,18],[3,812],[15,153],[12,726],[6,508],[17,817],[5,6],[3,667],[5,599],[13,353],[11,282],[7,226],[18,423],[13,875],[2,738],[6,727],[7,374],[19,811],[8,418],[2,179],[3,476],[9,15],[16,8],[19,827],[17,203],[13,246],[14,8],[13,750],[4,595],[1,793],[17,995],[11,589],[2,115],[18,870],[15,426],[18,953],[10,318],[10,419],[2,164],[9],[18,854],[3,394],[17],[4,834],[4,349],[2,16],[13,534],[3,773],[4,292],[5,951],[17,554],[4,646],[6,412],[15,548],[8,188],[5,539],[18,732],[8,591],[11,733],[1,517],[8,156],[13,331],[11,889],[12,782],[11],[2,578],[16,487],[12,640],[14,112],[10,901],[8,807],[7,818],[7,627],[14,9],[4,522],[7,505],[9,13],[3],[1,971],[18,808],[1,17],[7,197],[7,361],[2,986],[17,6],[7,211],[15,342],[5,538],[1,711],[11,863],[17,339],[5,656],[4,402],[1,514],[11,566],[12,11],[12],[19,899],[19,526],[20,799],[4,1],[17,363],[7,845],[15,329],[17,369],[18,18],[15,848],[5,928],[18,105],[18],[17,785],[11,457]]
'''


class Twitter:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.ts = 0
        self.friendship = {}
        self.posts = {}

    def postTweet(self, userId: int, tweetId: int) -> None:
        """
        Compose a new tweet.
        """
        lst = self.posts.get(userId, [])
        lst.append((self.ts, tweetId))
        self.posts[userId] = lst
        self.ts += 1

    def getNewsFeed(self, userId: int) -> List[int]:
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        """
        tweets = []
        for t, v in self.posts.get(userId, [])[-10:]:
            heapq.heappush(tweets, (t, v))
        for followee in self.friendship.get(userId, []):
            for t, v in self.posts.get(followee, [])[-10:]:
                heapq.heappush(tweets, (t, v))
                if len(tweets) > 10: heapq.heappop(tweets)

        return [tweet for time, tweet in sorted(tweets, key=lambda item: -item[0])]

    def follow(self, followerId: int, followeeId: int) -> None:
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        """
        if followerId == followeeId: return
        adj = self.friendship.get(followerId, set())
        adj.add(followeeId)
        self.friendship[followerId] = adj

    def unfollow(self, followerId: int, followeeId: int) -> None:
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        """
        if followerId in self.friendship:
            adj = self.friendship[followerId]
            if followeeId in adj: adj.remove(followeeId)


'''
["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
[[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1,22],[1,11],[1]]
["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
[[],[1,5],[2,3],[1,101],[2,13],[2,10],[1,2],[1,94],[2,505],[1,333],[2,22],[1,11],[1,205],[2,203],[1,201],[2,213],[1,200],[2,202],[1,204],[2,208],[2,233],[1,222],[2,211],[1],[1,2],[1],[1,2],[1]]
'''
if __name__ == '__main__':
    instance = Twitter()
    instance.postTweet(1, 5)
    instance.postTweet(2, 3)
    instance.postTweet(1, 101)
    instance.postTweet(2, 13)
    instance.postTweet(2, 10)
    instance.postTweet(1, 2)
    instance.postTweet(1, 94)
    instance.postTweet(2, 505)
    instance.postTweet(1, 333)
    instance.postTweet(2, 22)
    instance.postTweet(1, 11)
    instance.postTweet(1, 205)
    instance.postTweet(2, 203)
    instance.postTweet(1, 201)
    instance.postTweet(2, 213)
    instance.postTweet(1, 200)
    instance.postTweet(2, 202)
    instance.postTweet(1, 204)
    instance.postTweet(2, 208)
    instance.postTweet(2, 233)
    instance.postTweet(1, 222)
    instance.postTweet(2, 211)
    assert instance.getNewsFeed(1) == [222, 204, 200, 201, 205, 11, 333, 94, 2, 101]
    instance.follow(1, 2)
    assert instance.getNewsFeed(1) == [211, 222, 233, 208, 204, 202, 200, 213, 201, 203]
    instance.unfollow(1, 2)
    assert instance.getNewsFeed(1) == [222, 204, 200, 201, 205, 11, 333, 94, 2, 101]
