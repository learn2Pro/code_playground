package category.time.week30

/**
  * @author tang
  * @date 2019/07/27
  */
object RemoveDuplicateFromSortedSolution {

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums == null || nums.isEmpty) return 0
    var curr: Int = nums(0)
    var size = 1
    var from = 1
    for (idx <- 1 until nums.length) {
      val inner = nums(idx)
      if (inner != curr) {
        swap(nums, from, idx)
        from += 1
        size += 1
      }
      curr = inner
    }
    size
  }

  private def swap(nums: Array[Int], from: Int, to: Int): Unit = {
    nums(from) = nums(to)
  }
}
