package category.dp._500_600

/**
  * 514. Freedom Trail
  */
object _514_FreedomTrail {
  def findRotateSteps(ring: String, key: String): Int = {
    val wordLocation = new Array[List[Int]](26)
    for (i <- ring.indices) {
      if (wordLocation(ring(i) - 'a') == null) {
        wordLocation(ring(i) - 'a') = List(i)
      } else {
        wordLocation(ring(i) - 'a') ++= List(i)
      }
    }
    
    def choose(x: Int, y: Int): Int = {
      if (x == -1) return y
      if (y == -1) return x
      Math.min(x, y)
    }
    
    val dp = Array.tabulate(ring.length, 2)((_, _) => -1)
    dp(0)(0) = 0
    var ans = Int.MaxValue
    for (i <- key.indices) {
      val last = i % 2
      val curr = (i + 1) % 2
      for (j <- ring.indices) {
        if (dp(j)(last) != -1) {
          wordLocation(key(i) - 'a').foreach { x =>
            val right = Math.min(x, j) + ring.length
            val left = Math.max(x, j)
            val move = Math.min(Math.abs(j - x), Math.abs(left - right) % ring.length) + 1
            dp(x)(curr) = choose(dp(x)(curr), dp(j)(last) + move)
            if (i == key.length - 1) ans = Math.min(ans, dp(x)(curr))
          }
        }
        dp(j)(last) = -1
      }
    }
    ans
  }
  
  def findRotateStepsV1(ring: String, key: String): Int = {
    val wordLocation = new Array[List[Int]](26)
    for (i <- ring.indices) {
      if (wordLocation(ring(i) - 'a') == null) {
        wordLocation(ring(i) - 'a') = List(i)
      } else {
        wordLocation(ring(i) - 'a') ++= List(i)
      }
    }
    
    def dfs(search: String, curr: Int, step: Int): Int = {
      if (search.isEmpty) return step
      val head = search(0)
      var minStep = Int.MaxValue
      wordLocation(head - 'a').foreach { loc =>
        val right = Math.min(loc, curr) + ring.length
        val left = Math.max(loc, curr)
        val move = Math.min(Math.abs(curr - loc), Math.abs(left - right) % ring.length) + 1
        minStep = Math.min(minStep, dfs(search.substring(1), loc, step + move))
      }
      minStep
    }
    
    dfs(key, 0, 0)
    
  }
}