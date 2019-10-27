/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.time.week37

/**
  *
  * @author derong.tdr
  * @version Combinations.scala, v 0.1 2019年09月13日 19:47 tang Exp $
  */
class Combinations {
  def combine(n: Int, k: Int): List[List[Int]] = {
    if (n < k) return Nil
    List.tabulate(n)(i => i + 1).combinations(k).toList
  }
}
