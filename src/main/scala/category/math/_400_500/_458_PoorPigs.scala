package category.math._400_500

/**
  * 458. Poor Pigs
  */
object _458_PoorPigs {
  def poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int = {
    val step = minutesToTest / minutesToDie
    var ans = 0
    while (Math.pow(step + 1, ans) < buckets) ans += 1
    ans
  }
}