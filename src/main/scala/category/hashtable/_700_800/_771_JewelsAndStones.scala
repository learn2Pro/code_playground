package category.hashtable._700_800

/**
  * 771. Jewels and Stones
  */
object _771_JewelsAndStones {
  def numJewelsInStones(J: String, S: String): Int = {
    val jewels = J.toSet
    S.map { c =>
      if (jewels.contains(c)) 1 else 0
    }.sum
  }
}