package category.dp._800_900

/**
  * 801. Minimum Swaps To Make Sequences Increasing
  */
object _801_MinimumSwapsToMakeSeqIncr {
  def minSwap(A: Array[Int], B: Array[Int]): Int = {
    val N = A.length
    var n0 = 0
    var s0 = 1
    for (i <- 1 until N) {
      var n1, s1 = Int.MaxValue
      if (A(i - 1) < A(i) && B(i - 1) < B(i)) {
        n1 = Math.min(n0, n1)
        s1 = Math.min(s1, s0 + 1)
      }
      if (A(i - 1) < B(i) && B(i - 1) < A(i)) {
        n1 = Math.min(n1, s0)
        s1 = Math.min(s1, n0 + 1)
      }
      s0 = s1
      n0 = n1
    }
    Math.min(n0, s0)
  }
}