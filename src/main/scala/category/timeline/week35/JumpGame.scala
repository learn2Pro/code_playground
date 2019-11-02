/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week35

/**
  *
  * @author derong.tdr
  * @version JumpGame.scala, v 0.1 2019年09月01日 09:42 tang Exp $
  */
object JumpGame {
  def canJump(nums: Array[Int]): Boolean = {
    val n = nums.length
    var i = 0
    var cur = 0
    while (cur < n - 1) {
      val pre = cur
      while (i <= pre) {
        cur = Math.max(cur, i + nums(i))
        i += 1
      }
      if (pre == cur && pre < n - 1) return false // May not need this
    }
    cur >= n - 1
  }
}
