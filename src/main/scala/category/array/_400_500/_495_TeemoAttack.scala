/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.array._400_500

/**
  * 495. Teemo Attacking
  */
object _495_TeemoAttack {
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
