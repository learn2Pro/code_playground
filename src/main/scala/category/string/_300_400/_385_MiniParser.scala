package category.string._300_400


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
import java.util

import scala.collection.mutable.ArrayBuffer

class NestedInteger {
  
  val nested: ArrayBuffer[NestedInteger] = new ArrayBuffer[NestedInteger]()
  var simply: Integer                    = null
  
  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  def isInteger: Boolean = simply != null
  
  // Return the single integer that this NestedInteger holds, if it holds a single integer
  def getInteger: Int = simply
  
  // Set this NestedInteger to hold a single integer.
  def setInteger(i: Int): Unit = simply = i
  
  // Return the nested list that this NestedInteger holds, if it holds a nested list
  def getList = nested
  
  // Set this NestedInteger to hold a nested list and adds a nested integer to it.
  def add(ni: NestedInteger): Unit = nested.append(ni)
}

/**
  * 385. Mini Parser
  */
object _385_MiniParser {
  val DIGITS      = Set('-', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0')
  val lookup      = new util.HashMap[String, NestedInteger]()
  var unique: Int = 256
  
  def deserialize(s: String): NestedInteger = {
    if (s.isEmpty) return null
    if (s.forall(DIGITS.contains)) {
      var nest = new NestedInteger
      nest.setInteger(s.toInt)
      return nest
    }
    if (!s.contains("[")) {
      var nest = new NestedInteger
      s.split(",").foreach { partial =>
        if (partial.contains("_")) {nest.add(lookup.get(partial))}
        else {
          val nestedInteger = new NestedInteger
          nestedInteger.setInteger(partial.toInt)
          nest.add(nestedInteger)
        }
      }
      return nest
    }
    val stack = new java.util.Stack[Char]()
    var i = 0
    while (i < s.length) {
      s(i) match {
        case ']' =>
          var str = ""
          while (stack.peek() != '[') str = stack.pop() + str
          val partial = deserialize(str)
          stack.pop()
          s"_$unique".foreach(stack.push)
          val ans = if (partial != null && partial.isInteger) {
            val nest = new NestedInteger
            nest.add(partial)
            nest
          } else if (partial != null && !partial.isInteger) partial
                    else new NestedInteger
          lookup.put(s"_$unique", ans)
          unique += 1
        case _ =>
          stack.push(s(i))
      }
      i += 1
    }
    lookup.get(s"_${unique - 1}")
  }
}