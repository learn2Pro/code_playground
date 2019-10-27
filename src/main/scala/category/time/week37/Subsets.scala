/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week37

/**
  *
  * @author derong.tdr
  * @version SubSets.scala, v 0.1 2019年09月13日 19:55 tang Exp $
  */
class Subsets {

  def subsets(nums: Array[Int]): List[List[Int]] = {
    nums.foldLeft[List[List[Int]]](List(List()))((x,y) => x ++ x.map(z => y :: z))
  }
}
