/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.hashtable

import category.hashtable._200_300._274_HIndex
import category.hashtable._300_400._355_DesignTwitter
import category.hashtable._400_500._447_NumberOfBoomerangs
import category.hashtable._500_600._554_BrickWall
import category.hashtable._600_700.{_632_SmallestRangeCoveringElementsFromKLists, _648_ReplaceWords}
import category.hashtable._700_800.{_720_LongestWordInDictionary, _739_DailyTemperatures, _748_ShortestCompletingWord}
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version HashTableTest.scala, v 0.1 2020年01月11日 21:39 tang Exp $
  */
class HashTableTest extends FunSuite {
  
  test("_274_HIndex") {
    assert(_274_HIndex.hIndex(Array(1)) == 1)
  }
  
  test("_355_DesignTwitter") {
    val twitter = new _355_DesignTwitter
    twitter.postTweet(1, 1)
    var ans = twitter.getNewsFeed(1)
    twitter.follow(2, 1)
    ans = twitter.getNewsFeed(2)
    twitter.unfollow(2, 1)
    ans = twitter.getNewsFeed(2)
  }
  
  test("_447_NumberOfBoomerangs") {
    assert(_447_NumberOfBoomerangs.numberOfBoomerangs(Array(
      Array(0, 0), Array(1, 0), Array(2, 0)
    )) == 2)
  }
  
  test("_554_BrickWall") {
    assert(_554_BrickWall.leastBricks(List(
      List(2), List(1, 1), List(2)
    )) == 2)
    assert(_554_BrickWall.leastBricks(List(
      List(1), List(1), List(1)
    )) == 3)
    assert(_554_BrickWall.leastBricks(List(
      List(1, 2, 2, 1), List(3, 1, 2), List(1, 3, 2), List(2, 4), List(3, 1, 2), List(1, 3, 1, 1)
    )) == 2)
    
  }
  
  test("_632_SmallestRangeCoveringElementsFromKLists") {
    assert(_632_SmallestRangeCoveringElementsFromKLists.smallestRange(
      List(List(4, 10, 15, 24, 26), List(0, 9, 12, 20), List(5, 18, 22, 30))
    ) sameElements Array(20, 24))
  }
  
  test("_648_ReplaceWords") {
    assert(_648_ReplaceWords.replaceWords(
      List("cat", "bat", "rat"), "the cattle was rattled by the battery") == "the cat was rat by the bat"
    )
    assert(_648_ReplaceWords.replaceWords(
      List("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa") == "a a a a a a a a bbb baba a"
    )
  }
  
  test("_720_LongestWordInDictionary") {
    assert(_720_LongestWordInDictionary.longestWord(Array("w", "wo", "wor", "worl", "world")) == "world")
    assert(_720_LongestWordInDictionary.longestWord(Array("a", "banana", "app", "appl", "ap", "apply", "apple")) == "apple")
  }
  
  test("_739_DailyTemperatures") {
    assert(_739_DailyTemperatures.dailyTemperatures(Array(89, 62, 70, 58, 47, 47, 46, 76, 100, 70)).toList
            == List(8, 1, 5, 4, 3, 2, 1, 1, 0, 0))
    assert(_739_DailyTemperatures.dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)).toList
            == List(1, 1, 4, 2, 1, 1, 0, 0))
  }
  
  test("_748_ShortestCompletingWord") {
    assert(_748_ShortestCompletingWord.shortestCompletingWord("tR28607",
      Array("present", "fall", "make", "change", "everything", "performance", "owner", "beat", "name", "serve")) == "present")
    assert(_748_ShortestCompletingWord.shortestCompletingWord("1s3 PSt", Array("step", "steps", "stripe", "stepple")) == "steps")
  }
}
