package category.array._700_800

/**
  * 719. Find K-th Smallest Pair Distance
  */
object _719_FindKthSmallestPair {
  def smallestDistancePair(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    var lo = 0
    var hi = sorted.last - sorted(0)
    while (lo < hi) {
      val mid = (lo + hi) >>> 1
      var cnt, l = 0
      for (i <- sorted.indices) {
        while (sorted(i) - sorted(l) > mid) l += 1
        cnt += (i - l)
      }
      if (cnt >= k) hi = mid
      else lo = mid + 1
    }
    lo
  }
  
  def smallestDistancePairV1(nums: Array[Int], k: Int): Int = {
    val sorted = nums.sorted
    val multiplicity = new Array[Int](sorted.length)
    for (i <- 1 until sorted.length if sorted(i - 1) == sorted(i)) {
      multiplicity(i) += (multiplicity(i - 1) + 1)
    }
    val prefix = new Array[Int](sorted.last * 2)
    var left = 0
    for (i <- prefix.indices) {
      while (left < sorted.length && sorted(left) <= i) left += 1
      prefix(i) = left
    }
    var lo = 0
    var hi = sorted.last - sorted.head
    while (lo < hi) {
      val mid = (lo + hi) >>> 1
      var cnt = 0
      for (i <- sorted.indices) {
        cnt += (prefix(nums(i) + mid) - prefix(nums(i)) + multiplicity(i))
      }
      if (cnt >= k) hi = mid
      else lo = mid + 1
    }
    lo
  }
}