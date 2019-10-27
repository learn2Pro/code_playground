package category.time.week32

/**
  * Created by Administrator on 2019/8/11 0011.
  */
object SearchInsertPosition {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    if (nums == null || nums.isEmpty) return 0
    go(nums, 0, nums.length - 1, target)
  }

  private def go(nums: Array[Int], start: Int, end: Int, target: Int): Int = {
    val mid = start + (end - start) / 2
    if (end < start || nums(mid) == target) mid
    else if (nums(mid) < target) go(nums, mid + 1, end, target)
    else go(nums, start, mid - 1, target)
  }
}
