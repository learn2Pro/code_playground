package category.timeline.week28

import scala.collection.mutable

/**
  * @author tang
  * @date 2019/07/13
  */
object LongestValidParenthesesSolution {
  def longestValidParentheses(s: String): Int = {
    val stack = new mutable.ArrayStack[Int]()
    stack.push(-1)
    var maxLen = -1
    s.zipWithIndex.foreach {
      case r@('(', idx) =>
        stack.push(idx)
      case r@(')', idx) =>
        stack.pop()
        if (stack.isEmpty) {
          stack.push(idx)
        } else {
          maxLen = Math.max(maxLen, idx - stack.top)
        }
    }
    maxLen
  }

  //  def longestValidParentheses(s: String): Int = {
  //    if (s.isEmpty) return 0
  //    var max = 0
  //    var left = 0
  //    var right = 1
  //    var last = 0
  //    val len = s.length
  //    val dp = new Array[Int](len)
  //    while (right < s.length) {
  //      // (+last+)
  //      if (last > 0 && left - 1 >= 0 && s(left - 1) == '(' && s(right) == ')') {
  //        val d = getDp(dp, left - 2)
  //        val curr = last + 2 + d
  //        dp(right) = curr
  //        last = curr
  //        if (curr > max) max = curr
  //        right += 1
  //        left = left - d - 1
  //      }
  //      // last + ()
  //      else if (last > 0 && right + 1 < len && right < len && s(right) == '(' && s(right + 1) == ')') {
  //        val d = getDp(dp, left - 1)
  //        val curr = last + 2 + d
  //        last = curr
  //        if (curr > max) max = curr
  //        left -= d
  //        dp(right) = 0
  //        dp(right + 1) = curr
  //        right += 2
  //
  //      } else {
  //        //right == '('
  //        if (s(right) == '(') {
  //          dp(right) = 0
  //          left = right
  //          right += 1
  //          last = 0
  //        }
  //        //right == ')'
  //        else {
  //          while (left < right && (s(left) == ')' || right - left % 2 == 0 || !isValid(s.substring(left, right + 1)))) {
  //            left += 1
  //          }
  //          val d = getDp(dp, left - 1)
  //          last = if (right - left == 0) {
  //            0
  //          } else {
  //            right - left + 1 + d
  //          }
  //          dp(right) = last
  //          if (last > max) max = last
  //          right += 1
  //          left -= d
  //        }
  //      }
  //    }
  //    max
  //  }
  //
  //  private def getDp(arr: Array[Int], idx: Int) = {
  //    if (idx >= 0 && idx < arr.length) {
  //      arr(idx)
  //    } else {
  //      0
  //    }
  //  }
  //
  //  private def isValid(s: String): Boolean = {
  //    val stack = new mutable.ArrayStack[Char]()
  //    s.foreach {
  //      case r@'(' =>
  //        stack.push(r)
  //      case ')' =>
  //        if (stack.nonEmpty && stack.top == '(') {
  //          stack.pop()
  //        } else {
  //          return false
  //        }
  //    }
  //    stack.isEmpty
  //  }
}
