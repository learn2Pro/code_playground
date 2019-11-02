/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week36

/**
  *
  * @author derong.tdr
  * @version InsertInterval.scala, v 0.1 2019年09月07日 12:33 tang Exp $
  */
object InsertInterval {
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    if (intervals == null || intervals.isEmpty) return Array(newInterval)
    val leftLoc = findLocation(intervals, newInterval(0), 0, intervals.length)
    val rightLoc = findLocation(intervals, newInterval(1), 0, intervals.length)
    val leftArrPart = leftLoc match {
      case i: Int =>
        intervals.slice(0, i)
      case f: Float if f > 0 =>
        intervals.slice(0, f.toInt + 1)
      case f: Float if f < 0 =>
        Array.empty[Array[Int]]
    }
    val midArrPart = {
      val leftValue = leftLoc match {
        case i: Int =>
          intervals(i)(0)
        case f: Float =>
          newInterval(0)
      }
      val rightValue = rightLoc match {
        case i: Int =>
          intervals(i)(1)
        case f: Float =>
          newInterval(1)
      }
      Array(Array(leftValue, rightValue))
    }
    val rightArrPart = rightLoc match {
      case i: Int =>
        intervals.slice(i + 1, intervals.length)
      case f: Float if f > 0 =>
        intervals.slice(f.toInt + 1, intervals.length)
      case f: Float if f < 0 =>
        intervals
    }
    leftArrPart ++ midArrPart ++ rightArrPart
  }


  /**
    * integer is mean in interval
    * float mean in gap
    *
    * @return
    */
  private def findLocation(intervals: Array[Array[Int]], value: Int, left: Int, right: Int): Any = {
    val mid = left + (right - left) / 2
    //in interval
    if (value >= intervals(mid)(0) && value <= intervals(mid)(1)) {
      mid
    } else if (mid + 1 < intervals.length && value > intervals(mid)(1) && value < intervals(mid + 1)(0)) {
      mid + 0.5F
    } else if (mid - 1 >= 0 && value < intervals(mid)(0) && value > intervals(mid - 1)(1)) {
      mid - 0.5F
    } else if (mid + 1 >= intervals.length && value > intervals(mid)(1)) {
      mid + 0.5F
    } else if (mid - 1 < 0 && value < intervals(mid)(0)) {
      mid - 0.5F
    } else if (mid + 1 < intervals.length && value >= intervals(mid + 1)(0)) {
      findLocation(intervals, value, mid, right)
    } else {
      findLocation(intervals, value, left, mid)
    }
  }

}
