package category.string._500_600

/**
  * 556. Next Greater Element III
  */
object _556_NextGreaterElementIII {
  def nextGreaterElement(n: Int): Int = {
    val chars = n.toString.toCharArray
    val N = chars.length
    
    def swap(curr: Int, other: Int): Unit = {
      val tmp = chars(curr)
      chars(curr) = chars(other)
      chars(other) = tmp
    }
    
    Int.MaxValue
    var outer = N - 1
    var earlyStop = false
    while (outer >= 0 && !earlyStop) {
      var inner = N - 1
      while (inner > outer && chars(inner) <= chars(outer)) inner -= 1
      if (inner > outer) {
        swap(outer, inner)
        earlyStop = true
        java.util.Arrays.sort(chars, outer + 1, N)
      }
      outer -= 1
    }
    val ans = new String(chars).toLong
    if (earlyStop && ans <= Int.MaxValue) ans.toInt else -1
  }
}