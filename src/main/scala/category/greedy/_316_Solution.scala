/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2020 All Rights Reserved.
  */
package category.greedy

import scala.collection.mutable

/**
  * 316. Remove Duplicate Letters
  */
object _316_Solution {
  def removeDuplicateLetters(s: String): String = {
    val stack = new mutable.Stack[Char]()
    val count = new Array[Int](26)
    s.foreach(c => count(c - 'a') += 1)
    val visited = new Array[Boolean](26)
    val ans = new mutable.StringBuilder()
    s.foreach { c =>
      count(c - 'a') -= 1
      if (!visited(c - 'a')) {
        visited(c - 'a') = true
        while (stack.nonEmpty && c < stack.top && count(stack.top - 'a') != 0) {
          visited(stack.pop() - 'a') = false
        }
        stack.push(c)
      }
    }
    stack.foreach(ans.append)
    ans.reverse.toString()
  }
  
  //  def removeDuplicateLetters(s: String): String = {
  //    var ans = s.distinct
  //    for (i <- 0 until ans.length) {
  //      val sb = new StringBuilder
  //      val hash = new mutable.HashSet[Char]()
  //      for (j <- i until s.length if !hash.contains(s(j))) {
  //        sb.append(s(j))
  //        hash.add(s(j))
  //      }
  //      if (sb.length == ans.length && sb.toString() < ans) ans = sb.toString()
  //    }
  //    ans
  //  }
}
