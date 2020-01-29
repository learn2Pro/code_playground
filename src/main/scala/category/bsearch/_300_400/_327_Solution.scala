package category.bsearch._300_400

/**
  * 327. Count of Range Sum
  */
object _327_Solution {
  def countRangeSum(nums: Array[Int], lower: Int, upper: Int): Int = {
    
    def mergeSort(sums: Array[Long], lo: Int, hi: Int): Int = {
      if (lo >= hi) return 0
      val mid = (lo + hi) >>> 1
      var tmp = mergeSort(sums, lo, mid) + mergeSort(sums, mid + 1, hi)
      val cache = new Array[Long](hi - lo + 1)
      var left = lo
      var idx = 0
      var l, h, right = mid + 1
      while (left <= mid) {
        while (l <= hi && sums(l) - sums(left) < lower) l += 1
        while (h <= hi && sums(h) - sums(left) <= upper) h += 1
        while (right <= hi && sums(right) < sums(left)) {
          cache(idx) = sums(right)
          right += 1
          idx += 1
        }
        cache(idx) = sums(left)
        tmp += (h - l)
        left += 1
        idx += 1
      }
      System.arraycopy(cache, 0, sums, lo, idx)
      tmp
    }
    
    val sumArr = new Array[Long](nums.length + 1)
    for (i <- nums.indices) {
      sumArr(i + 1) = sumArr(i) + nums(i)
    }
    mergeSort(sumArr, 0, nums.length)
  }
}