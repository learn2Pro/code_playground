package category.string._500_600

/**
  * 539. Minimum Time Difference
  */
object _539_MinimumTimeDifference {
  def findMinDifference(timePoints: List[String]): Int = {
    val sorted = timePoints.sorted
    
    def parse(p0: String): Int = {
      val splits = p0.split(":")
      splits(0).toInt * 60 + splits(1).toInt
    }
    
    def diff(p0: String, p1: String): Int = {
      val t0 = parse(p0)
      val t1 = parse(p1)
      Math.min(Math.abs(t1 - t0), Math.abs(t0 + 24 * 60 - t1))
    }
    
    var ans = diff(sorted.head, sorted.last)
    for (i <- 1 until sorted.length) {
      ans = Math.min(ans, diff(sorted(i - 1), sorted(i)))
    }
    ans
  }
}