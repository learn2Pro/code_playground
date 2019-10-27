package category.time.week32

/**
  * Created by Administrator on 2019/8/11 0011.
  */
object SearchRangeInSortedArr {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val ans = Array(-1, -1)
    if (nums == null || nums.isEmpty) return ans
    findLoAndHi(nums, 0, nums.length, target, ans)
    ans
  }

  def findLoAndHi(nums: Array[Int], start: Int, end: Int, target: Int, ans: Array[Int]): Unit = {
    val mid = start + (end - start) / 2
    if (end < start) return
    if (end == start || nums(mid) == target) {
      if (start >= 0 && end >= 0 && mid < nums.length && nums(mid) == target) {
        if (ans(0) == -1 || mid < ans(0)) ans(0) = mid
        if (ans(1) == -1 || mid > ans(1)) ans(1) = mid
        findLoAndHi(nums, start, mid - 1, target, ans)
        findLoAndHi(nums, mid + 1, end, target, ans)
      } else {
        return
      }
    }
    else if (nums(mid) < target) findLoAndHi(nums, mid + 1, end, target, ans)
    else findLoAndHi(nums, start, mid - 1, target, ans)
  }


}
