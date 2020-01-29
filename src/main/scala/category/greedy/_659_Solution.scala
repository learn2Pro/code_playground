package category.greedy

import java.util

/**
  * 659. Split Array into Consecutive Subsequences
  */
object _659_Solution {
  def isPossible(nums: Array[Int]): Boolean = {
    var pre = Integer.MIN_VALUE
    var p1 = 0
    var p2 = 0
    var p3 = 0
    var cur = 0
    var cnt = 0
    var c1 = 0
    var c2 = 0
    var c3 = 0
    var i = 0
    while ( {i < nums.length}) {
      cur = nums(i)
      cnt = 0
      while ( {i < nums.length && cur == nums(i)}) {
        cnt += 1
        
        {i += 1; i - 1}
      }
      if (cur != pre + 1) {
        if (p1 != 0 || p2 != 0) return false
        c1 = cnt
        c2 = 0
        c3 = 0
      }
      else {
        if (cnt < p1 + p2) return false
        c1 = Math.max(0, cnt - (p1 + p2 + p3))
        c2 = p1
        c3 = p2 + Math.min(p3, cnt - (p1 + p2))
      }
      
      pre = cur
      p1 = c1
      p2 = c2
      p3 = c3
    }
    p1 == 0 && p2 == 0
  }
  
//  def isPossible(nums: Array[Int]): Boolean = {
//    val freq = new util.HashMap[Int, Int]()
//    val tobeAppend = new util.HashMap[Int, Int]()
//    for (i <- nums) {freq.put(i, freq.getOrDefault(i, 0) + 1)}
//    for (i <- nums if freq.get(i) != 0) {
//      if (tobeAppend.getOrDefault(i, 0) > 0) {
//        tobeAppend.put(i, tobeAppend.get(i) - 1)
//        tobeAppend.put(i + 1, tobeAppend.getOrDefault(i + 1, 0) + 1)
//      } else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
//        freq.put(i + 1, freq.get(i + 1) - 1)
//        freq.put(i + 2, freq.get(i + 2) - 1)
//        tobeAppend.put(i + 3, tobeAppend.getOrDefault(i + 3, 0) + 1)
//      } else return false
//      freq.put(i, freq.get(i) - 1)
//    }
//    true
//  }
  
  //  def isPossible(nums: Array[Int]): Boolean = {
  //    if (nums.length < 3) return false
  //    val buffer = new ArrayBuffer[java.util.LinkedList[Int]]()
  //
  //    def addList(i: Int): Unit = {
  //      val newly = new util.LinkedList[Int]()
  //      newly.add(i)
  //      buffer.append(newly)
  //    }
  //
  //    def find(input: Int): Unit = {
  //      var minIdx = -1
  //      var minSz = Int.MaxValue
  //      for (i <- buffer.indices if buffer(i).getLast + 1 == input && buffer(i).size() < minSz) {
  //        minSz = buffer(i).size()
  //        minIdx = i
  //      }
  //      if (minIdx != -1) buffer(minIdx).add(input)
  //      else addList(input)
  //    }
  //
  //    nums.foreach(find)
  //    buffer.forall(_.size() >= 3)
  //  }
}