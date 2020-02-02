package category.backtrack

/**
  * 282. Expression Add Operators
  */
object _282_Solution {
  def addOperators(num: String, target: Int): List[String] = {
    var ans: List[String] = Nil
    
    def backtrack(pos: Int, previous: String, eval: Long, multi: Long): Unit = {
      if (pos == num.length) {if (eval == target) ans ::= previous; return}
      
      for (i <- pos until num.length) {
        /*skip leading zero*/
        if (i != pos && num(pos) == '0') {}
        else {
          val sub = num.substring(pos, i + 1)
          val curr = sub.toLong
          if (previous.isEmpty) backtrack(i + 1, sub, curr, curr)
          else {
            backtrack(i + 1, previous + "+" + sub, eval + curr, curr)
            backtrack(i + 1, previous + "-" + sub, eval - curr, -curr)
            backtrack(i + 1, previous + "*" + sub, eval - multi + multi * curr, multi * curr)
          }
        }
      }
    }
    
    backtrack(0, "", 0, 0)
    ans
  }
  
  //  def addOperators(num: String, target: Int): List[String] = {
  //
  //    def backtrack(inner: String, target: Int): List[String] = {
  //      var ans: List[String] = Nil
  //      if (inner.toInt == target) ans ::= inner
  //      for (i <- 1 until inner.length) {
  //        val left = inner.substring(0, i).toInt
  //        /* + */
  //        ans ++= backtrack(inner.substring(i), target - left).map { s =>
  //          left + "+" + s
  //        }
  //        /* - */
  //        ans ++= backtrack(inner.substring(i), left - target).map { s =>
  //          left + "-" + s
  //        }
  //        /* * */
  //        if ((left == 0 && target == 0) || (left != 0 && target / left >= 1 && target % left == 0)) {
  //          val div = if (target == 0) 0 else target / left
  //          ans ++= backtrack(inner.substring(i), div).map { s =>
  //            left + "*" + s
  //          }
  //        }
  //
  //
  //      }
  //      ans
  //    }
  //
  //    (backtrack(num, target) ++ backtrack(num.reverse, target).map(_.reverse)).distinct
  //
  //  }
}