package category.array._700_800

/**
  * 795. Number of Subarrays with Bounded Maximum
  */
object _795_NumberOfSubArrWithBounded {
  def numSubarrayBoundedMax(A: Array[Int], L: Int, R: Int): Int = {
    var max, start, ans = 0
    var last = -1
    for (i <- A.indices) {
      max = Math.max(max, A(i))
      if (A(i) >= L && A(i) <= R) {
        ans += Math.max(i - start + 1, 0)
        last = i
      } else if (A(i) > R) {
        start = i + 1
        last = -1
        max = 0
      } else {
        ans += Math.max(0, last - start + 1)
      }
    }
    ans
  }
}