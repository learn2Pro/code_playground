package category.array

/**
  * 495. Teemo Attacking
  */
object TeemoAttack {
  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    if (timeSeries == null || timeSeries.isEmpty) return 0
    val (total, _) = timeSeries.foldLeft((0, 0)) { case ((sum, expectTime), time) =>
      if (expectTime > time) (sum + (duration - (expectTime - time)), time + duration)
      else {
        (sum + duration, time + duration)
      }
    }
    total
  }
}