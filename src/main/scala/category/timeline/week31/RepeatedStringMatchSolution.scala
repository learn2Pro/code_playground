package category.timeline.week31

/**
  * @author tang
  * @date 2019/08/03
  */
object RepeatedStringMatchSolution {

  def repeatedStringMatch(A: String, B: String): Int = {
    val aLen = A.length
    val bLen = B.length
    for (i <- 0 until aLen) {
      var j = 0
      while (j < bLen && A((i + j) % aLen) == B(j)) j += 1
      if (j == bLen) return Math.ceil((i + j).toDouble / aLen).toInt
    }
    -1
  }

}
