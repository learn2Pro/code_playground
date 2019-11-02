/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week33

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @author derong.tdr
  * @version CombinationSum.scala, v 0.1 2019年08月18日 13:26 tang Exp $
  */
object CombinationSum {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val result = new ArrayBuffer[List[Int]]()
    dfs(candidates.sorted, target, 0, Nil, result)
    result.toList
  }

  private def dfs(
    candidates: Array[Int], target: Int, start: Int,
    partial: List[Int], result: ArrayBuffer[List[Int]]): Unit = {
    if (target == 0) {
      result.append(partial)
    }
    else if (target < 0) {
      //do nothing
    }
    else {
      for (i <- start until candidates.length) {
        if (i > start && candidates(i) == candidates(i - 1)) {

        } else {
          val curr = candidates(i)
          dfs(candidates, target - curr, i + 1, curr :: partial, result)
        }
      }
    }
  }

}
