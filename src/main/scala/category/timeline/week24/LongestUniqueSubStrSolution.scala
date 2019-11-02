package category.timeline.week24

import java.util

object LongestUniqueSubStrSolution {

  /**
    * Max(f(0),f(1),...,f(n))
    * f(0) 从index=0开始的子串的[最长unique子串]
    * 其中 f(n)可以利用f(n-1)的unique子串长度的n-1进行skip
    * 事件复杂度 0(n)
    * 空间复杂度 0(n)
    *
    * @param s
    * @return
    */
  def lengthOfLongestSubstring(s: String): Int = {
    val uniqueSubStr = new util.HashSet[Char]()
    val len = s.length
    var remain = len
    var maxSize = 0
    //外层迭代，迭代字符串每一个index，当最大子串长度已经大于remain的字符串长度后，终止
    while (maxSize < remain) {
      val skip = uniqueSubStr.size()
      val curr = len - remain
      val startChar = s(curr)
      var idx = curr + skip
      var currMaxSize = skip
      //迭代搜索unique子串
      while (idx < len) {
        val currChar = s(idx)
        if (uniqueSubStr.contains(currChar)) {
          idx = len
        }
        //最大unique子串长度+1
        else {
          uniqueSubStr.add(currChar)
          currMaxSize += 1
          idx += 1
        }
      }
      if (currMaxSize > maxSize) {
        maxSize = currMaxSize
      }
      uniqueSubStr.remove(startChar)
      remain -= 1
    }
    maxSize
  }

}
