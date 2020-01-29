package category.bsearch._700_800

import java.util

/**
  * 715. Range Module
  */
class RangeModule() {
  
  val ranges = new util.TreeMap[Integer, Array[Int]]()
  
  def addRange(left: Int, right: Int): Unit = {
    if (left >= right) return
    val inclusiveRight = right - 1
    val lo = ranges.floorKey(left)
    val hi = ranges.floorKey(inclusiveRight)
    if (hi != null && lo != null && hi == lo && ranges.get(lo).last >= left) {
      ranges.put(lo, Array(lo, Math.max(ranges.get(hi).last, inclusiveRight)))
      expand(lo)
    } else if (lo != null && hi != null && hi != lo && ranges.get(lo).last >= left) {
      val end = ranges.get(lo).last
      ranges.put(lo, Array(lo, Math.max(ranges.get(hi).last, inclusiveRight)))
      expand(lo)
      removePath(right, end)
    } else if (lo != null && hi != null && hi != lo && ranges.get(lo).last < left) {
      ranges.put(left, Array(left, Math.max(ranges.get(hi).last, inclusiveRight)))
      expand(lo)
      removePath(right, left)
    } else if (lo == null && hi != null) {
      val end = ranges.higherEntry(left).getValue.last
      ranges.put(left, Array(left, end))
      ranges.remove(ranges.higherKey(left))
      addRange(end, right)
    } else {
      ranges.put(left, Array(left, inclusiveRight))
      if (lo != null) expand(lo)
    }
  }
  
  private def expand(key: Int): Unit = {
    val last = ranges.get(key).last
    val higher = ranges.higherKey(last)
    if (higher == last + 1) {
      ranges.put(key, Array(key, ranges.get(higher).last))
      ranges.remove(higher)
    }
  }
  
  def queryRange(left: Int, right: Int): Boolean = {
    val inclusiveRight = right - 1
    val l = ranges.floorKey(left)
    val r = ranges.floorKey(inclusiveRight)
    if (l != null && r != null && l == r && ranges.get(l).last >= inclusiveRight) true else false
  }
  
  def removeRange(left: Int, right: Int): Unit = {
    val inclusiveRight = right - 1
    val lo = ranges.floorKey(left)
    val hi = ranges.floorKey(inclusiveRight)
    if (hi != null && lo != null && hi == lo && ranges.get(lo).last >= left) {
      putOrRemove(right, right, Math.max(ranges.get(lo).last, inclusiveRight))
      putOrRemove(lo, lo, left - 1)
    } else if (lo != null && hi != null && hi != lo && ranges.get(lo).last >= left) {
      val end = ranges.get(lo).last
      putOrRemove(lo, lo, Math.min(ranges.get(lo).last, left - 1))
      putOrRemove(right, right, Math.max(ranges.get(hi).last, inclusiveRight))
      removePath(right, end)
    } else if (lo != null && hi != null && hi != lo && ranges.get(lo).last < left) {
      val end = ranges.get(lo).last
      putOrRemove(right, right, Math.max(ranges.get(hi).last, inclusiveRight))
      removePath(right, end)
    } else if (lo == null && hi != null) {
      val start = ranges.higherKey(left)
      removeRange(start, right)
    }
  }
  
  def putOrRemove(key: Int, range0: Int, range1: Int): Unit = {
    if (range1 - range0 >= 0) ranges.put(key, Array(range0, range1))
    else if (range1 - range0 < 0) ranges.remove(key)
  }
  
  def removePath(right: Int, end: Int) = {
    var tmp = ranges.lowerKey(right)
    while (tmp != null && tmp > end) {
      ranges.remove(tmp)
      tmp = ranges.lowerKey(tmp)
    }
  }
  
  //  private def removeOne(input: Int): Unit = {
  //    val key = ranges.floorKey(input)
  //    if (key != null) {
  //      val lo = ranges.get(key).head
  //      val hi = ranges.get(key).last
  //      if (lo == hi && lo == input) {
  //        ranges.remove(key)
  //      } else if (input == lo) {
  //        ranges.put(lo + 1, Array(lo + 1, hi))
  //        ranges.remove(key)
  //      } else if (input == hi) {
  //        ranges.put(key, Array(lo, hi - 1))
  //      } else if (input > lo && input < hi) {
  //        ranges.put(lo, Array(lo, input - 1))
  //        ranges.put(input + 1, Array(input + 1, hi))
  //      }
  //    }
  //  }
  
  //  private def addOne(input: Int): Unit = {
  //    if (ranges.containsKey(input)) return
  //    val lo = ranges.lowerKey(input)
  //    val hi = ranges.higherKey(input)
  //    if (lo != null && hi != null && ranges.get(lo).last + 1 == input && ranges.get(hi).head == input + 1) {
  //      ranges.put(lo, Array(ranges.get(lo).head, ranges.get(hi).last))
  //      ranges.remove(hi)
  //    } else if (lo != null && ranges.get(lo).last + 1 >= input) {
  //      ranges.put(lo, Array(ranges.get(lo).head, Math.max(ranges.get(lo).last, input)))
  //    } else if (hi != null && hi == input + 1) {
  //      ranges.put(input, Array(input, ranges.get(hi).last))
  //      ranges.remove(hi)
  //    } else {
  //      ranges.put(input, Array(input, input))
  //    }
  //  }
  
}