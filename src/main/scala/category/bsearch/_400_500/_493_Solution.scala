package category.bsearch._400_500

/**
  * 493. Reverse Pairs
  */
object _493_Solution {
  def reversePairs(nums: Array[Int]): Int = {
    
    def mergeSort(inputs: Array[Int], lo: Int, hi: Int): Int = {
      if (lo >= hi) return 0
      val mid = (lo + hi) >>> 1
      var tmp = mergeSort(inputs, lo, mid) + mergeSort(inputs, mid + 1, hi)
      val cache = new Array[Int](hi - lo + 1)
      var left = lo
      var r0, r1 = mid + 1
      var idx = 0
      while (left <= mid) {
        while (r0 <= hi && inputs(r0).toLong * 2 < inputs(left).toLong) r0 += 1
        while (r1 <= hi && inputs(r1) < inputs(left)) {
          cache(idx) = inputs(r1)
          idx += 1
          r1 += 1
        }
        tmp += (r0 - mid - 1)
        cache(idx) = inputs(left)
        left += 1
        idx += 1
      }
      System.arraycopy(cache, 0, inputs, lo, idx)
      tmp
    }
    
    mergeSort(nums, 0, nums.length - 1)
  }
}