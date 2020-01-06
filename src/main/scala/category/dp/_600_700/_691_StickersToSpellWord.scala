/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.dp._600_700


/**
  *
  * 691. Stickers to Spell Word
  *
  * @author derong.tdr
  * @version _235_LcaOfBst.scala, v 0.1 2019年12月14日 14:07 tang Exp $
  */
object _691_StickersToSpellWord {
  def minStickers(stickers: Array[String], target: String): Int = {
    val N = target.length
    val M = 1 << N
    val dp = Array.tabulate(M)(_ => Int.MaxValue)
    dp(0) = 0
    for (i <- 0 until M if dp(i) != Int.MaxValue) {
      for (sticker <- stickers) {
        var curr = i
        for (c <- sticker) {
          var k = 0
          var earlyStop = false
          while (k < N && !earlyStop) {
            if (target(k) == c && (curr >> k & 1) == 0) {
              earlyStop = true
              curr |= 1 << k
            }
            k += 1
          }
        }
        dp(curr) = Math.min(dp(i) + 1, dp(curr))
      }
    }
    if (dp(M - 1) == Int.MaxValue) -1 else dp(M - 1)
  }
  
  //  import scala.collection.mutable.ArrayBuffer
  //
  //  def minStickers(stickers: Array[String], target: String): Int = {
  //    val CHAR_SIZE = 26
  //    val wordChar = new Array[Int](CHAR_SIZE)
  //    target.foreach(c => wordChar(c - 'a') += 1)
  //    val N = stickers.length
  //
  //    def decr(sticker: String, word: Array[Int]): Array[Int] = {
  //      val tmpChar = new Array[Int](CHAR_SIZE)
  //      for (c <- sticker if word(c - 'a') > 0) {
  //        tmpChar(c - 'a') += 1
  //      }
  //      tmpChar.zip(word).map { case (t0, t1) =>
  //        Math.min(t0, t1)
  //      }
  //    }
  //
  //    val dp = Array.tabulate(2, N)((_, _) => Array.empty[Array[Int]])
  //    for (i <- 0 until N) {
  //      dp(0)(i) = Array(wordChar.clone())
  //    }
  //
  //    var times = 1
  //    var earlyStop = 0
  //    while (earlyStop != N) {
  //      val curr = times % 2
  //      val last = (times - 1) % 2
  //      earlyStop = 0
  //      for (i <- 0 until N) {
  //        val sticker = stickers(i)
  //        var maxDecr = 0
  //        var minRemain = Int.MaxValue
  //        val remainArr: ArrayBuffer[(Int, Array[Int])] = new ArrayBuffer[(Int, Array[Int])]()
  //        for (j <- 0 until N if dp(last)(j).nonEmpty) {
  //          dp(last)(j).foreach { state =>
  //            val decrArr = decr(sticker, state)
  //            val tmp = decrArr.zip(state).map { case (l0, l1) => l1 - l0 }
  //            maxDecr = Math.max(maxDecr, decrArr.sum)
  //            val tmpSum = tmp.sum
  //            minRemain = Math.min(minRemain, tmpSum)
  //            if (tmpSum <= minRemain) remainArr.append((tmpSum, tmp))
  //          }
  //        }
  //
  //        if (maxDecr == 0) {
  //          earlyStop += 1
  //          dp(curr)(i) = Array.empty[Array[Int]]
  //        } else {
  //          if (minRemain == 0) return times
  //          dp(curr)(i) = remainArr.filter(_._1 == minRemain).map(_._2).toArray
  //        }
  //      }
  //      times += 1
  //    }
  //    -1
  //  }
  
  //  def minStickers(stickers: Array[String], target: String): Int = {
  //    val CHAR_SIZE = 26
  //    val wordChar = new Array[Int](CHAR_SIZE)
  //    target.foreach(c => wordChar(c - 'a') += 1)
  //
  //    def decr(sticker: String, words: Array[Int]): Array[Int] = {
  //      val tmpChar = new Array[Int](CHAR_SIZE)
  //      for (c <- sticker if words(c - 'a') > 0) {
  //        tmpChar(c - 'a') += 1
  //      }
  //      tmpChar.zip(words).map { case (t0, t1) =>
  //        Math.min(t0, t1)
  //      }
  //    }
  //
  //    def minAns(min0: Int, min1: Int): Int = {
  //      if (min0 == -1) return min1
  //      if (min1 == -1) return min0
  //      Math.min(min0, min1)
  //    }
  //
  //    def backTrack(times: Int, words: Array[Int]): Int = {
  //      if (words.forall(_ == 0)) return times
  //      var min = Int.MaxValue
  //      for (sticker <- stickers) {
  //        val tmp = decr(sticker, words)
  //        if (tmp.sum != 0) {
  //          val decrement = words.zip(tmp).map { case (l0, l1) => l0 - l1 }
  //          min = minAns(min, backTrack(times + 1, decrement))
  //        }
  //      }
  //      if (min == Int.MaxValue) -1 else min
  //    }
  //
  //    backTrack(0, wordChar)
  //  }
}
