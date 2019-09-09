/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week36


/**
  *
  * @author derong.tdr
  * @version MinimumWindowSubstring.scala, v 0.1 2019年09月08日 21:07 tang Exp $
  */
object MinimumWindowSubstring {

  import java.util

  def minWindow(s: String, t: String): String = {
    if (s.length < t.length) return ""
    var left = 0
    var right = 0
    var ans: (Int, Int) = (Int.MaxValue, 0)
    val filtered = s.zipWithIndex.filter(s => t.contains(s._1))
    val window = Window()
    while (right < filtered.length) {
      window.add(s(right))
      var lastWinSize = -1
      while (window.contains(t) && left <= window.size) {
        lastWinSize = window.size
        //contract
        window.remove(s(left))
        left += 1
      }
      if (lastWinSize != -1 && lastWinSize < ans._1) {
        ans = (lastWinSize, right)
      }
      right += 1
    }
    if (ans._1 == Int.MaxValue) ""
    else s.slice(ans._2 - ans._1 + 1, ans._2 + 1)
  }

  //  def minWindow(s: String, t: String): String = {
  //    val row = t.length + 1
  //    val col = s.length + 1
  //    if (row > col) return ""
  //    val dp = Array.tabulate(row, col)((_, _) => -1)
  //    for (j <- 0 until col) dp(0)(j) = 0
  //    for (i <- 1 until row)
  //      for (j <- i until col) {
  //        //(i-1,j-1)
  //        if (t(i - 1) == s(j - 1) && dp(i - 1)(j - 1) != -1) {
  //          dp(i)(j) = dp(i - 1)(j - 1) + 1
  //        }
  //        else if (dp(i)(j - 1) != -1) {
  //          dp(i)(j) = dp(i)(j - 1) + 1
  //        }
  //        if (dp(i - 1)(j) != -1 && (dp(i - 1)(j) < dp(i)(j - 1) || dp(i - 1)(j) < dp(i - 1)(j - 1) + 1 || (dp(i)(j - 1) == -1 && dp(i - 1)(j - 1) == -1))) {
  //          val idx = findLen(j - 1 - dp(i - 1)(j), j - 1, s, t.slice(0, i))
  //          if (idx != -1 && (dp(i)(j) == -1 || idx < dp(i)(j))) {
  //            dp(i)(j) = idx
  //          }
  //        }
  //      }
  //    val ansArr = dp(row - 1).zipWithIndex.filter(_._1 != -1)
  //    if (ansArr == null || ansArr.isEmpty) ""
  //    else {
  //      val (len, idx) = ansArr.minBy(_._1)
  //      s.substring(idx - len, idx)
  //    }
  //
  //  }
  //
  //  private def findLen(start: Int, end: Int, s: String, t: String): Int = {
  //    var idx = start
  //    var find = false
  //    val win = Window()
  //    for (i <- start + 1 to end) {
  //      win.add(s(i))
  //    }
  //    while (idx >= 0 && !find) {
  //      win.add(s(idx))
  //      find = win.contains(t)
  //      idx -= 1
  //    }
  //    if (find) win.size else -1
  //  }

  case class Window(holder: util.Map[Char, Int] = new util.HashMap[Char, Int](), var size: Int = 0) {
    def add(c: Char) = {
      if (holder.containsKey(c)) holder.put(c, holder.get(c) + 1)
      else holder.put(c, 1)
      size += 1
    }

    def remove(c: Char): Unit = {
      if (holder.containsKey(c)) {
        val remain = holder.get(c) - 1
        remain match {
          case 0 =>
            holder.remove(c)
          case _ =>
            holder.put(c, remain)
        }
        size -= 1
      }
    }

    def contains(s: String): Boolean = {
      s.map(c => c -> 1).groupBy(_._1).forall { case (c, list) =>
        val sum = list.map(_._2).sum
        holder.containsKey(c) && holder.get(c) >= sum
      }
    }
  }

}
