package category.timeline.week26

import scala.util.matching.Regex

/**
  * @author tang
  * @date 2019/06/30
  */
object AtoiSolution {
  //  def myAtoi(str: String): Int = {
  //    //提前数字string
  //    val trimStr = str.trim
  //    val len = trimStr.length
  //    var ans: Long = 0L
  //    var idx = 0
  //    var doNothing = false
  //    var flag = 1
  //    var alreadyNum = false
  //    while (idx < len && !doNothing) {
  //      if ((valid(trimStr(idx)) && !alreadyNum) || (number(trimStr(idx)) && alreadyNum)) {
  //        if (!alreadyNum) {
  //          trimStr(idx) match {
  //            case '+' =>
  //              flag = 1
  //            case '-' =>
  //              flag = -1
  //            case _ =>
  //              flag = 1
  //          }
  //        }
  //        if (number(trimStr(idx))) {
  //          if (ans.asInstanceOf[Int] == ans) {
  //            ans = ans * 10 + (trimStr(idx) - 48)
  //          } else {
  //            doNothing = true
  //          }
  //        }
  //        alreadyNum = true
  //      } else {
  //        doNothing = true
  //      }
  //      idx += 1
  //    }
  //    ans = ans * flag
  //    if (ans.asInstanceOf[Int] == ans) {
  //      ans.asInstanceOf[Int]
  //    } else if (flag < 0) {
  //      Int.MinValue
  //    } else {
  //      Int.MaxValue
  //    }
  //  }

  def myAtoi(str: String): Int = {
    val re = new Regex("[-+]?\\d+")
    val numeric = re.findFirstIn(str)
    if (numeric.isEmpty || numeric.get.isEmpty) {
      0
    } else if (numeric.get.length >= 12) {
      if (numeric.get(0) == '-') {
        Int.MinValue
      } else {
        Int.MaxValue
      }
    } else {
      numeric.get.toInt
    }
  }

  def valid(c: Char): Boolean = {
    Array('+', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
      .contains(c)
  }

  def number(c: Char): Boolean = {
    Array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
      .contains(c)
  }

}
