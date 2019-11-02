package category.timeline.week30

/**
  * @author tang
  * @date 2019/07/27
  */
object RemoveElementSolution {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    if (nums == null || nums.isEmpty) return 0
    var size = 0
    var from = 0
    for (idx <- 0 until nums.length) {
      val inner = nums(idx)
      if (inner != `val`) {
        nums(from) = nums(idx)
        from += 1
        size += 1
      }
    }
    size
  }
}
