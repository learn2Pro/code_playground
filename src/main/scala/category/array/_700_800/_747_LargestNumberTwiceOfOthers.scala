package category.array._700_800

/**
  * 747. Largest Number At Least Twice of Others
  */
object _747_LargestNumberTwiceOfOthers {
  def dominantIndex(nums: Array[Int]): Int = {
    if (nums.length == 1) return 0
    var max0, max1 = 0
    var sum = 0
    var idx = 0
    for (i <- nums.indices) {
      /*max1>=num>max0*/
      if (nums(i) > max0 && nums(i) <= max1) max0 = nums(i)
      /*num>max1>max0*/
      else if (nums(i) > max1) {
        max0 = max1
        max1 = nums(i)
        idx = i
      }
      sum += nums(i)
    }
    if (max1 > 2 * max0 && max1 * nums.length > sum * 2 - max1) idx else -1
  }
}