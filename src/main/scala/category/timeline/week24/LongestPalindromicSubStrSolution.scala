package category.timeline.week24

import scala.collection.mutable.ArrayBuffer

object LongestPalindromicSubStrSolution {

  def longestPalindrome(s: String): String = {
    val insertStr = s
    var longest = ""
    var maxSize = 0
    val len = insertStr.length
    val w = Window()
    var right = 0
    var left = 0
    while (right < len) {
      if (left - 1 >= 0) {
        w.firstAdd(insertStr(left - 1))
        left -= 1
      }
      w.append(insertStr(right))
      left += w.palindromic()
      if (w.len > maxSize) {
        longest = w.chars.mkString("")
        maxSize = w.len
      }
      right += 1
    }
    longest
  }

  case class Window(chars: ArrayBuffer[Char] = new ArrayBuffer[Char](), var len: Int = 0, distinctWindow: DistinctWindow = DistinctWindow()) {

    def firstAdd(c: Char): Unit = {
      chars.insert(0, c)
      distinctWindow.add(c)
      len += 1
    }

    def append(c: Char) = {
      chars.append(c)
      distinctWindow.add(c)
      len += 1
    }

    def removeFirst(): Char = {
      val c = chars.remove(0)
      distinctWindow.minus(c)
      len -= 1
      c
    }

    def removeHalf(): Int = {
      val half = (len - 1) / 2
      for (_ <- 0 until half) {
        val c = removeFirst()
        distinctWindow.minus(c)
      }
      half
    }

    def palindromic() = {
      val expandSuccess = chars(0) == chars(len - 1)
      if (distinctWindow.different == 1) {
        0
      } else if (expandSuccess) {
        0
      } else {
        val c = removeFirst()
        //全部相同回文
        if (distinctWindow.different == 1) {
          if (chars(len - 1) == chars(0)) {
            1
          } else {
            len
          }
        }
        //特殊回文 abababababa类型
//        else if (distinctWindow.different == 2 && Math.abs(distinctWindow.distinctNumLookUp.get(chars(0)) - distinctWindow.distinctNumLookUp.get(chars(1))) == 1) {
//          1
//        }
        //normal回文
        else {
          firstAdd(c)
          var half = removeHalf()
          while (!isPalindromic()) {
            removeFirst()
            half += 1
          }
          half
        }

      }

    }

    def isPalindromic() = {
      var left = 0
      var right = len - 1
      var isPalindromic = true
      while (left < right && isPalindromic) {
        isPalindromic = chars(left) == chars(right)
        left += 1
        right -= 1
      }
      isPalindromic
    }
  }

  case class DistinctWindow(distinctNumLookUp: java.util.HashMap[Char, Int] = new java.util.HashMap[Char, Int](), var different: Int = 0) {
    /**
      * 添加
      *
      * @param num
      */
    def add(num: Char): Unit = {
      if (distinctNumLookUp.containsKey(num)) {
        val add = distinctNumLookUp.get(num) + 1
        distinctNumLookUp.put(num, add)
      } else {
        distinctNumLookUp.put(num, 1)
        different += 1
      }
    }

    /**
      * 删除
      *
      * @param num
      */
    def minus(num: Char): Unit = {
      if (distinctNumLookUp.containsKey(num)) {
        val minus = distinctNumLookUp.get(num) - 1
        if (minus == 0) {
          distinctNumLookUp.remove(num)
          different -= 1
        } else {
          distinctNumLookUp.put(num, minus)
        }

      }
    }
  }

}
