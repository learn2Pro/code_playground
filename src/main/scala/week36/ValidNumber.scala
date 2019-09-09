/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week36

/**
  *
  * @author derong.tdr
  * @version ValidNumber.scala, v 0.1 2019年09月07日 18:38 tang Exp $
  */
object ValidNumber {

  val NUM_REG_0 = "[+-]*[0-9]+"
  val NUM_REG_1 = "[+-]*(([0-9]+[\\.][0-9]+)|([\\.][0-9]+)|([0-9]+[\\.]))"
  val NUM_REG_2 = "[+-]*[0-9]+e[+-]*[0-9]+"
  val NUM_REG_4 = "[+-]*(([0-9]+[\\.][0-9]+)|([\\.][0-9]+)|([0-9]+[\\.]))e[+-]*[0-9]+"

  def isNumber(s: String): Boolean = {
    if (s == null || s.isEmpty) return false
    val trimed = s.trim
    trimed.matches(NUM_REG_0) ||
            trimed.matches(NUM_REG_1) ||
            trimed.matches(NUM_REG_2) ||
            trimed.matches(NUM_REG_4)
  }
}
