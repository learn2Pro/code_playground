/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.timeline.week35

/**
  *
  * @author derong.tdr
  * @version PermutationsII.scala, v 0.1 2019年09月01日 11:13 tang Exp $
  */
object PermutationsII {

  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    nums.permutations.toList.map(_.toList).distinct
  }

}
