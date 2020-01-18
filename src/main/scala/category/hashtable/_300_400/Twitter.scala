package category.hashtable._300_400


/**
  * 355. Design _355_DesignTwitter
  */
class Twitter() {
  
  import java.util.concurrent.atomic.AtomicInteger
  
  /** Initialize your data structure here. */
  /**
    * user->list(user)
    */
  val followShip = new scala.collection.mutable.HashMap[Int, scala.collection.mutable.Set[Int]]
  /**
    * user->tweets sortby time
    */
  val tweetDatum = new scala.collection.mutable.HashMap[Int, List[(Int, Int)]]
  val counter    = new AtomicInteger(0)
  
  
  /** Compose a new tweet. */
  def postTweet(userId: Int, tweetId: Int): Unit = {
    tweetDatum.put(userId, (counter.incrementAndGet(), tweetId) :: tweetDatum.getOrElse(userId, Nil))
  }
  
  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  def getNewsFeed(userId: Int): List[Int] = {
    val retrieveUser = userId :: getFollowShip(userId).toList
    var ans: List[Int] = Nil
    val N = retrieveUser.length
    val pointers = new Array[Int](N)
    val tweets = retrieveUser.map(tweetDatum)
    while (ans.length < 10) {
      var maxIndex, maxTweet = -1
      var maxTs = 0
      for (i <- 0 until N if pointers(i) < tweets(i).length) {
        val (ts, tweet) = tweets(i)(pointers(i))
        if (ts > maxTs) {
          maxIndex = i
          maxTs = ts
          maxTweet = tweet
        }
      }
      if (maxIndex == -1) return ans
      ans ::= maxTweet
      pointers(maxIndex) += 1
    }
    ans
  }
  
  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  def follow(followerId: Int, followeeId: Int): Unit = {
    followShip.put(followerId, getFollowShip(followerId) + followeeId)
  }
  
  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  def unfollow(followerId: Int, followeeId: Int) {
    followShip.put(followerId, getFollowShip(followerId) - followeeId)
  }
  
  private def getFollowShip(userId: Int) = {
    followShip.getOrElse(userId, new scala.collection.mutable.HashSet[Int]())
  }
  
}