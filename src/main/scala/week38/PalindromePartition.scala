package week38

import scala.collection.mutable

/**
  * 131. Palindrome Partitioning
  */
object PalindromePartition {
  def isPalin(s: String): Boolean = {
    var i = 0
    var j = s.length - 1
    
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j)) return false
      
      i += 1
      j -= 1
    }
    
    true
  }
  
  def partition(s: String): List[List[String]] = {
    val ans = mutable.ListBuffer.empty[List[String]]
    val tmp = mutable.ListBuffer.empty[String]
    
    def iterate(s: String): Unit = {
      if (s.isEmpty) {
        ans += tmp.toList
        return
      }
      for (i <- 0 until s.length if isPalin(s.substring(0, i + 1))) {
        tmp += s.substring(0, i + 1)
        iterate(s.substring(i + 1))
        tmp.remove(tmp.length - 1)
      }
    }
    
    iterate(s)
    ans.toList
  }
  
  //  def partition(s: String): List[List[String]] = {
  //
  //
  //    def backtrack(remain: String): Unit = {
  //      if (remain.length == 0) {
  //        ans += tmp.toList
  //        return
  //      }
  //
  //      for (i <- 0 until remain.length) {
  //        val pre = remain.substring(0, i + 1)
  //        if (isPalin(pre)) {
  //          tmp += pre
  //          backtrack(remain.substring(i + 1))
  //          tmp.remove(tmp.length - 1)
  //        }
  //      }
  //    }
  //
  //    backtrack(s)
  //
  //    ans.toList
  //  }
  
  //  def partition(s: String): List[List[String]] = {
  //    iterate(s, Nil)
  //  }
  //
  //  private def iterate(s: String, mid: List[List[String]]): List[List[String]] = {
  //    if (s.length == 0) {
  //      return mid
  //    }
  //    if (s.length == 1) {
  //      return if (mid == Nil) {
  //        List(List(s))
  //      } else {
  //        mid.map(s :: _)
  //      }
  //    }
  //    var updated: List[List[String]] = Nil
  //    if (isPalindrome(s)) {
  //      updated = List(List(s))
  //    }
  //    val iter = (for (i <- 1 until s.length if isPalindrome(s.substring(0, i))) yield {
  //      iterate(s.substring(i), mid).map(s.substring(0, i) :: _)
  //    }).flatten
  //    updated ++ iter
  //  }
  //
  //  private def isPalindrome(s: String): Boolean = {
  //    var l = 0
  //    var r = s.length - 1
  //    var find = false
  //    while (l <= r && !find) {
  //      if (s(l) != s(r)) {
  //        find = true
  //      }
  //      l += 1
  //      r -= 1
  //    }
  //    !find
  //  }
}