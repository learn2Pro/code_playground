package category.array

import scala.collection.mutable

/**
  * 219. Contains Duplicate II
  */
object ContainsDuplicateII {
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    val num2Index = new mutable.HashMap[Int, Int]()
    nums.foldLeft(0) { case (idx, num) =>
      if (num2Index.contains(num)) {
        val diff = idx - num2Index(num)
        if (diff <= k) return true
      }
      num2Index.put(num, idx)
      idx + 1
    }
    false
  }
}