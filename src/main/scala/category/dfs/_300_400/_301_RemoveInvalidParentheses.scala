package category.dfs._300_400

/**
  * 301. Remove Invalid Parentheses
  */
object _301_RemoveInvalidParentheses {
  
  
  def removeInvalidParentheses(s: String): List[String] = {
    var ans: List[String] = Nil
    
    def remove(s: String, last_i: Int, last_j: Int, par: Array[Char]): Unit = {
      var stack = 0
      for (i <- last_i until s.length) {
        if (s.charAt(i) == par(0)) stack += 1
        if (s.charAt(i) == par(1)) stack -= 1
        if (stack < 0) {
          for (j <- last_j to i) {
            if (s.charAt(j) == par(1) && (j == last_j || s.charAt(j - 1) != par(1))) {
              remove(s.substring(0, j) + s.substring(j + 1, s.length), i, j, par)
            }
          }
          return
        }
      }
      val reversed = s.reverse
      if (par(0) == '(') { // finished left to right
        remove(reversed, 0, 0, Array[Char](')', '('))
      } else { // finished right to left
        ans ::= reversed
      }
    }
    
    remove(s, 0, 0, Array[Char]('(', ')'))
    ans
  }
  
  
  //  def removeInvalidParentheses(s: String) = {
  //    var misLeft, misRight = 0
  //    s.foreach {
  //      case '(' =>
  //        misLeft += 1
  //      case ')' =>
  //        if (misLeft > 0) misLeft -= 1 else misRight += 1
  //      case _ =>
  //    }
  //    var ans = Nil
  //    val N = s.length
  //
  //    def dfs(idx: Int, input: String, l0: Int, r0: Int, l: Int, r: Int): Unit = {
  //      if (idx >= N) {
  //        if (l0 == 0 && r0 == 0) ans ::= input
  //        return
  //      }
  //      s(idx) match {
  //        case c@'(' =>
  //          if (l > 0) dfs(idx + 1, input, l0, r0, l - 1, r)
  //          dfs(idx + 1, input + c, l0 + 1, r0, l, r)
  //        case c@')' =>
  //          if (r > 0) dfs(idx + 1, input, l0, r0, l, r - 1)
  //          val newLeft = if (l0 > 0) l0 - 1 else l0
  //          val newRight = if (l0 > 0) r0 else r0 + 1
  //          dfs(idx + 1, input + c, newLeft, newRight, l, r)
  //        case c@_ =>
  //          dfs(idx + 1, input + c, l0, r0, l, r)
  //      }
  //    }
  //
  //    dfs(0, "", 0, 0, misLeft, misRight)
  //    ans.distinct
  //  }
}