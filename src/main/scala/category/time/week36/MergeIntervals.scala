/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week36

/**
  *
  * @author derong.tdr
  * @version MergeIntervals.scala, v 0.1 2019年09月07日 12:23 tang Exp $
  */
class MergeIntervals {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    if (intervals == null || intervals.isEmpty) return Array.empty
    val sorted = intervals.sortBy(arr => arr(0))
    sorted.foldLeft(Array.empty[Array[Int]]) { case (last, curr) =>
      if (last.length == 0) last ++ Array(curr)
      else {
        val tailArr = last(last.length - 1)
        if (tailArr(1) >= curr(0)) {
          tailArr(1) = Math.max(curr(1), tailArr(1))
          last
        } else {
          last ++ Array(curr)
        }
      }
    }
  }
}
