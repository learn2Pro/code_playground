package category.dp._700_800

/**
  * 787. Cheapest Flights Within K Stops
  */
object _787_CheapestFlightsWithKStops {
  def findCheapestPrice(n: Int, flights: Array[Array[Int]], src: Int, dst: Int, K: Int): Int = {
    if (src == dst) return 0
    val dp = Array.tabulate(n, 2)((_, _) => -1)
    var ans = -1
    
    def min(route0: Int, route1: Int): Int = {
      if (route0 == -1) return route1
      if (route1 == -1) return route0
      Math.min(route0, route1)
    }
    
    val src2dst = flights.groupBy(_ (0)).map { case (src, arr) =>
      src -> arr.map(a => (a(1), a(2)))
    }
    
    dp(src)(0) = 0
    for (i <- 0 to K) {
      val last = i % 2
      val curr = (i + 1) % 2
      for (idx <- 0 until n if dp(idx)(last) != -1) {
        src2dst.get(idx).foreach { contain =>
          contain.foreach { case (mid, price) =>
            dp(mid)(curr) = min(dp(mid)(curr), dp(idx)(last) + price)
            if (mid == dst) {
              ans = min(dp(mid)(curr), ans)
              dp(mid)(curr) = -1
            }
          }
        }
        dp(idx)(last) = -1
      }
    }
    ans
  }
}