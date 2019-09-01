/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week33

import scala.collection.mutable.ArrayBuffer

/**
  *
  * @author derong.tdr
  * @version CombinationSum3.scala, v 0.1 2019年08月18日 15:27 tang Exp $
  */
object CombinationSum3 {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    if (n / k >= 9 || n / k <= 1) return Nil
    val result = new ArrayBuffer[List[Int]]()
    dfs(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), n, k, 0, Nil, result)
    result.toList
  }

  def dfs(
    candidates: Array[Int], target: Int,
    remain: Int, start: Int,
    partial: List[Int], result: ArrayBuffer[List[Int]]): Unit = {
    if (remain == 1) {
      if (start < target && target <= 9) {
        result.append(target :: partial)
      }
    } else {
      for (i <- start until candidates.length if target > candidates(i)) {
        dfs(candidates, target - candidates(i), remain - 1, i + 1, candidates(i) :: partial, result)
      }
    }
  }
}
