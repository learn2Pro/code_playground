/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._200_300

/**
  * 228. Summary Ranges
  */
object _228_SummaryRanges {
  def summaryRanges(nums: Array[Int]): List[String] = {
    if (nums == null || nums.isEmpty) return Nil
    
    def assembly(start: Int, expect: Int): String = {
      if (start + 1 == expect) {
        s"$start"
      } else {
        s"$start->${expect - 1}"
      }
    }
    
    var ans: List[String] = Nil
    var start: Int = nums(0)
    var idx = 0
    nums.foldLeft(start) { case (expect, curr) =>
      val next = if (curr == expect) {
        expect + 1
      } else {
        ans = ans ++ List(assembly(start, expect))
        start = curr
        start + 1
      }
      idx += 1
      /*solve tail*/
      if (idx >= nums.length) {
        ans = ans ++ List(assembly(start, next))
      }
      next
    }
    ans
  }
}
