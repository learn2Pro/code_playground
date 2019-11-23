package category.dp._400_500


/**
  * 403. Frog Jump
  */
object _403_FrogJump {
  def canCross(stones: Array[Int]): Boolean = {
    val steps = scala.collection.mutable.Map.empty[Int, scala.collection.mutable.Set[Int]]
    steps += (0 -> scala.collection.mutable.Set(1))
    val last = stones(stones.length - 1)
    (0 until stones.length - 1) foreach { i =>
      val x = stones(i)
      if (steps.contains(x))
        steps(x) foreach { step =>
          val y = x + step
          if (y == last) return true
          else if (y < last) {
            val set = steps.getOrElseUpdate(y, scala.collection.mutable.Set.empty)
            if (step > 1) set += step - 1
            set += step
            set += step + 1
          }
        }
    }
    false
  }
  
  def canCrossV1(stones: Array[Int]): Boolean = {
    
    def jump(lastGap: Int, lastLocation: Int, currentLocation: Int): Boolean = {
      currentLocation - lastLocation >= lastGap - 1 && currentLocation - lastLocation <= lastGap + 1
    }
    
    if (stones(1) != 1) return false
    val dp = Array.tabulate[List[Int]](stones.length)(_ => Nil)
    dp(1) = 0 :: dp(1)
    for (i <- 2 until stones.length) {
      for (k <- 1 until i) {
        var earlyStop = false
        for (loc <- dp(k) if !earlyStop) {
          val gap = stones(k) - stones(loc)
          if (jump(gap, stones(k), stones(i))) {
            dp(i) = k :: dp(i)
            earlyStop = true
          }
        }
      }
    }
    dp.last.nonEmpty
  }
}