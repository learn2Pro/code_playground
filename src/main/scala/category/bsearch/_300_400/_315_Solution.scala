package category.bsearch._300_400

import java.util

/**
  * 315. Count of Smaller Numbers After Self
  */
object _315_Solution {
  def countSmaller(nums: Array[Int]): List[Int] = {
    val ans = new Array[Int](nums.length)
    val newIndex = new util.HashMap[Int, Int]()
    
    def mergeSort(nums: Array[Int], lo: Int, hi: Int): Array[Int] = {
      if (lo >= hi) return Array.tabulate(1)(_ => nums(lo))
      val mid = (lo + hi) >>> 1
      val left = mergeSort(nums, lo, mid)
      val right = mergeSort(nums, mid + 1, hi)
      var p0, p1 = 0
      var i = 0
      val sorted = new Array[Int](hi - lo + 1)
      val tmpIndex = new util.HashMap[Int, Int]()
      while (p0 < (mid - lo + 1) && p1 < (hi - mid)) {
        if (left(p0) <= right(p1)) {
          sorted(i) = left(p0)
          tmpIndex.put(lo + i, newIndex.getOrDefault(lo + p0, lo + p0))
          ans(tmpIndex.get(lo + i)) += p1
          p0 += 1
        } else {
          sorted(i) = right(p1)
          tmpIndex.put(lo + i, newIndex.getOrDefault(mid + 1 + p1, mid + 1 + p1))
          p1 += 1
        }
        i += 1
      }
      while (p0 < (mid - lo + 1)) {
        sorted(i) = left(p0)
        tmpIndex.put(lo + i, newIndex.getOrDefault(lo + p0, lo + p0))
        ans(tmpIndex.get(lo + i)) += p1
        i += 1
        p0 += 1
      }
      while (p1 < (hi - mid)) {
        sorted(i) = right(p1)
        tmpIndex.put(lo + i, newIndex.getOrDefault(mid + 1 + p1, mid + 1 + p1))
        i += 1
        p1 += 1
      }
      newIndex.putAll(tmpIndex)
      sorted
    }
    
    if (nums.isEmpty) return Nil
    mergeSort(nums, 0, nums.length - 1)
    ans.toList
  }
  
  //  import scala.collection.mutable
  //  import scala.collection.mutable.ArrayBuffer
  //  object Solution {
  //    def countSmaller(nums: Array[Int]): List[Int] = {
  //      val queue = new mutable.PriorityQueue[Int]()(new Ordering[Int] {
  //        override def compare(x: Int, y: Int): Int = y - x
  //      })
  //      val pop = new ArrayBuffer[Int]()
  //      var ans: List[Int] = Nil
  //      val N = nums.length
  //      for (i <- Range(N - 1, -1, -1)) {
  //        while (queue.nonEmpty && queue.head < nums(i)) pop += queue.dequeue()
  //        while (pop.nonEmpty && pop.last >= nums(i)) queue.enqueue(pop.remove(pop.length - 1))
  //        ans ::= pop.length
  //        queue.enqueue(nums(i))
  //      }
  //      ans
  //    }
  //  }
}

