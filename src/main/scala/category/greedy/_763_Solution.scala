package category.greedy

/**
  * 763. Partition Labels
  */
object _763_Solution {
  def partitionLabels(S: String): List[Int] = {
    val last = new Array[Int](26)
    for (i <- S.indices) last(S(i) - 'a') = i
    var end, anchor = 0
    var ans: List[Int] = Nil
    for (idx <- 0 until S.length) {
      end = Math.max(end, last(S(idx) - 'a'))
      if (idx == end) {ans ::= (idx - anchor + 1); anchor = idx + 1}
    }
    ans.reverse
  }
}