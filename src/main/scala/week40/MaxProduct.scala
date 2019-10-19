package week40

/**
  * 152. Maximum Product Subarray
  */
object MaxProduct {
  def maxProduct(nums: Array[Int]): Int = {
    var max = nums(0)
    var min = nums(0)
    var ans = nums(0)
    for (i <- 1 until nums.length) {
      val tmpMax = max
      val tmpMin = min
      max = Math.max(nums(i), Math.max(tmpMax * nums(i), tmpMin * nums(i)))
      min = Math.min(nums(i), Math.min(tmpMin * nums(i), tmpMax * nums(i)))
      ans = Math.max(max, ans)
    }
    ans
  }
  
  //  def maxProduct(nums: Array[Int]): Int = {
  //    if (nums == null || nums.isEmpty) return 0
  //    val win = Window(0, 0, nums)
  //    var ans = nums(0)
  //    var last = nums(0)
  //    while (!win.reach) {
  //      val product = win.product
  //      ans = Math.max(product, ans)
  //      if (win.left <= win.right && win.product >= last) {
  //        win.moveRight
  //      } else {
  //        win.moveLeft
  //      }
  //      last = product
  //    }
  //    ans
  //  }
  //
  //  case class Window(var left: Int, var right: Int, nums: Array[Int]) {
  //
  //    def reach: Boolean = {
  //      left > nums.length - 1 && right > nums.length - 1
  //    }
  //
  //    def moveLeft: Unit = {
  //      if (left < nums.length) {
  //        left += 1
  //      } else {
  //        right += 1
  //      }
  //    }
  //
  //    def moveRight: Unit = {
  //      if (right < nums.length) {
  //        right += 1
  //      } else {
  //        left += 1
  //      }
  //    }
  //
  //    def product: Int = {
  //      nums.slice(left, right + 1).product
  //    }
  //  }
  
}