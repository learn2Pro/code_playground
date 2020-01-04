package category.string._700_800

/**
  * 767. Reorganize String
  */
object _767_ReorganizeStr {
  def reorganizeString(S: String): String = {
    val nums = new Array[Int](26)
    S.foreach(c => nums(c - 'a') += 1)
    val N = S.length
    val sorted = nums.zipWithIndex.filter(_._1 != 0).sortBy(_._1)
    val max = sorted.last._1
    if (2 * max - N >= 2) return ""
    val ans = new StringBuilder
    var iter = 0
    val (size, char) = sorted.last
    for (_ <- 0 until size) {
      ans.insert((iter / max + 1) * (iter % max), (char + 'a').toChar)
      iter += 1
    }
    for (i <- Range(sorted.length - 2, -1, -1)) {
      val (size, char) = sorted(i)
      for (j <- 0 until size) {
        ans.insert((iter / max + 1) * (iter % max) + 1, (char + 'a').toChar)
        iter += 1
      }
    }
    ans.toString()
  }
}