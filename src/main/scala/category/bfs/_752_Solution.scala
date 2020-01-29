package category.bfs

import java.util

/**
  * 752. Open the Lock
  */
object _752_Solution {
  def openLock(deadends: Array[String], target: String): Int = {
    val deads = deadends.toSet
    def detour(input: String): Boolean = deads.contains(input)
    
    def add(c: Char): Char = if (c == '9') '0' else (c + 1).toChar
    
    def minus(c: Char): Char = if (c == '0') '9' else (c - 1).toChar
    
    def addStr(s: String, i: Int): String = {
      val chars = s.toCharArray
      chars(i) = add(chars(i))
      new String(chars)
    }
    
    def minusStr(s: String, i: Int): String = {
      val chars = s.toCharArray
      chars(i) = minus(chars(i))
      new String(chars)
    }
    
    val queue = new util.LinkedList[String]()
    val visited = new util.HashSet[String]()
    var depth = 0
    if (!detour("0000")) queue.add("0000")
    if (!detour("0000")) visited.add("0000")
    while (!queue.isEmpty) {
      val len = queue.size()
      for (_ <- 0 until len) {
        val str = queue.remove()
        if (str == target) return depth
        for (j <- 0 until 4) {
          val tmp0 = addStr(str, j)
          if (!detour(tmp0) && !visited.contains(tmp0)) {visited.add(tmp0); queue.add(tmp0)}
          val tmp1 = minusStr(str, j)
          if (!detour(tmp1) && !visited.contains(tmp1)) {visited.add(tmp1); queue.add(tmp1)}
        }
      }
      depth += 1
    }
    -1
  }
}