package category.dp._400_500

/**
  * 486. Predict the Winner
  */
object _486_PredictTheWinner {
  def PredictTheWinner(nums: Array[Int]): Boolean = {
    
    def next(l: Int, h: Int, sum: Long, round: Boolean): Long = {
      if (l >= h) return sum
      if (round) {
        val move0 = next(l + 1, h, sum + nums(l), !round)
        val move1 = next(l, h - 1, sum + nums(h), !round)
        if (move0 >= move1) move0
        else move1
      } else {
        val move0 = next(l + 1, h, sum - nums(l), !round)
        val move1 = next(l, h - 1, sum - nums(h), !round)
        if (move0 < move1) move0
        else move1
      }
    }
    
    next(0, nums.length - 1, 0, round = true) >= 0
    
    
  }
  
  def PredictTheWinnerV1(nums: Array[Int]): Boolean = {
    
    var lo = 0
    var hi = nums.length - 1
    var sum = 0
    
    def nextMin(): Int = {
      val getLeft = nums(lo)
      val moveLeft = Math.max(nums(lo + 1), nums(hi))
      val getRight = nums(hi)
      val moveRight = Math.max(nums(lo), nums(hi - 1))
      if (getLeft - getRight < moveLeft - moveRight) {
        hi -= 1
        nums(hi + 1)
      } else {
        lo += 1
        nums(lo - 1)
      }
    }
    
    var round = true
    while (lo < hi) {
      if (round) sum += nextMin()
      else sum -= nextMin()
      round = !round
    }
    sum >= 0
  }
}