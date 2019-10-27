/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week35

/**
  *
  * @author derong.tdr
  * @version JumpGameII.scala, v 0.1 2019年09月01日 09:28 tang Exp $
  */
object JumpGameII {
  def jump(nums: Array[Int]): Int = {
    var res = 0
    val n = nums.length
    var i = 0
    var cur = 0
    while (cur < n - 1) {
      res += 1
      val pre = cur
      while (i <= pre) {
        cur = Math.max(cur, i + nums(i))
        i += 1
      }
      if (pre == cur) return -1 // May not need this
    }
    res
  }

  //  def jump(nums: Array[Int]): Int = {
  //    if (nums.forall(_ == 1)) return nums.length - 1
  //    val dest = nums.length
  //    val dp = Array.tabulate(dest)(_ => -1)
  //    dp(dest - 1) = 0
  //    findMinJump(nums, 0, dp)
  //    dp(0)
  //  }
  //
  //  /**
  //    * search the minimal
  //    * dp(idx) = min(dp(idx+1),dp(idx+2),..,dp(jump))+1
  //    */
  //  //  @tailrec
  //  private def findMinJump(nums: Array[Int], idx: Int, dp: Array[Int]): Unit = {
  //    if (nums(idx) == 0) return
  //    if (idx + nums(idx) >= nums.length - 1) {
  //      dp(idx) = 1
  //      return
  //    }
  //    dp(idx) = (for (i <- 1 to nums(idx)) yield {
  //      if (dp(idx + i) == -1) {
  //        findMinJump(nums, idx + i, dp)
  //      }
  //      dp(idx + i) + 1
  //    }).min
  //  }
}
