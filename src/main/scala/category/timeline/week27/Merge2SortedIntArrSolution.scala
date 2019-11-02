package category.timeline.week27

/**
  * Created by Administrator on 2019/7/6 0006.
  */
object Merge2SortedIntArrSolution {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var p0 = 0
    var p1 = 0
    var idx = 0
    val ans = new Array[Int](m + n)
    while (idx < m + n) {
      if (getIdx(nums1, m, p0) < getIdx(nums2, n, p1)) {
        ans(idx) = nums1(p0)
        p0 += 1
      } else if (getIdx(nums1, m, p0) >= getIdx(nums2, n, p1)) {
        ans(idx) = nums2(p1)
        p1 += 1
      }
      idx += 1
    }
    if (p0 != m) {
      System.arraycopy(nums1, p0, ans, n + p0, m - p0)
    } else if (p1 != n) {
      System.arraycopy(nums2, p1, ans, m + p1, n - p1)
    }
    System.arraycopy(ans, 0, nums1, 0, m + n)

  }

  def getIdx(nums: Array[Int], m: Int, idx: Int): Int = {
    if (idx >= m) {
      Int.MaxValue
    } else {
      nums(idx)
    }
  }

  def swap(nums1: Array[Int], nums2: Array[Int], left: Int, right: Int): Unit = {
    nums1(left) = nums1(left) ^ nums2(right)
    nums2(right) = nums1(left) ^ nums2(right)
    nums1(left) = nums1(left) ^ nums2(right)
  }
}
