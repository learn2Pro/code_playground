/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week36

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/**
  *
  * @author derong.tdr
  * @version PermutationSequence.scala, v 0.1 2019年09月07日 13:29 tang Exp $
  */
object PermutationSequence {
  def getPermutation(n: Int, k: Int): String = {
    val used = new ArrayBuffer[Int]()
    val notUsed = ArrayBuffer.tabulate[Int](n) {
      i: Int => i + 1
    }
    stepNext(used, notUsed, n, k)
  }

  @tailrec
  private def stepNext(used: ArrayBuffer[Int], notUsed: ArrayBuffer[Int], n: Int, remain: Int): String = {
    if (remain == 0) return (used ++ notUsed).mkString("")
    val fac = factorial(n - used.length - 1)
    val idx = (remain - 1) / fac
    val mode = (remain - 1) % fac
    val toUse = notUsed(idx)
    notUsed.remove(idx)
    used += toUse
    stepNext(used, notUsed, n, if (mode > 0) {
      mode + 1
    } else mode)
  }

  private def factorial(n: Int): Int = {
    var idx = 1
    var ans = 1
    while (idx <= n) {
      ans *= idx
      idx += 1
    }
    ans
  }
}
