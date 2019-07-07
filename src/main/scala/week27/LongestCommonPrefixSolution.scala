package week27

/**
  * Created by Administrator on 2019/7/7 0007.
  */
object LongestCommonPrefixSolution {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs == null || strs.isEmpty) {
      ""
    } else if (strs.length == 1) {
      strs(0)
    } else {
      var idx = 0
      var isEnd = false
      while (!isEnd) {
        val s = strs(0)
        val c = getC(idx, s)
        for (i <- 1 until strs.length) {
          if (getC(idx, strs(i)) != c || c == null) {
            isEnd = true
          }
        }
        if (!isEnd) {
          idx += 1
        }
      }
      if (idx == 0) {
        ""
      } else {
        strs(0).substring(0, idx)
      }
    }
  }

  def getC(idx: Int, s: String) = {
    if (idx < s.length) {
      s(idx)
    } else {
      null
    }
  }

  //  def longestCommonPrefix(strs: Array[String]): String = {
  //    if (strs == null || strs.isEmpty) {
  //      ""
  //    } else if (strs.length == 1) {
  //      strs(0)
  //    } else {
  //      var longestCommon = ""
  //      val (minStr, minIndex) = strs.zipWithIndex.minBy(_._1.length)
  //      var tmp = strs(minIndex)
  //      strs(minIndex) = strs(strs.length - 1)
  //      var left = 0
  //      var right = 1
  //      while (right <= minStr.length) {
  //        if (prefixMatch(minStr.substring(left, right), strs)) {
  //          if (right - left > longestCommon.length) {
  //            longestCommon = minStr.substring(left, right)
  //          }
  //          right += 1
  //        } else {
  //          left += 1
  //          right += 2
  //        }
  //      }
  //      longestCommon
  //    }
  //
  //  }
  //
  //  def prefixMatch(prefix: String, arr: Array[String]): Boolean = {
  //    var isMatch = true
  //    for (i <- 0 until arr.length - 1) {
  //      if (!arr(i).contains(prefix)) {
  //        isMatch = false
  //      }
  //    }
  //    isMatch
  //  }
}
