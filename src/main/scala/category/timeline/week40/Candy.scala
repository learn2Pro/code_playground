package category.timeline.week40

/**
  * 135. Candy
  */
object Candy {
  def candy(ratings: Array[Int]): Int = {
    if (ratings == null || ratings.isEmpty) return 0
    val dp = Array.tabulate(ratings.length)(_ => 1)
    
    def getIdx(i: Int, candy: Array[Int]): Int = {
      if (i < 0) candy(0)
      else if (i >= candy.length) candy.last
      else candy(i)
    }
    
    def iterate(i: Int) = {
      if (getIdx(i, ratings) <= getIdx(i - 1, ratings) && getIdx(i, ratings) <= getIdx(i + 1, ratings)) {
        dp(i) = 1
      } else if (getIdx(i, ratings) > getIdx(i - 1, ratings) && getIdx(i, ratings) > getIdx(i + 1, ratings)) {
        dp(i) = Math.max(getIdx(i - 1, dp), getIdx(i + 1, dp)) + 1
      } else {
        if (getIdx(i - 1, ratings) > getIdx(i + 1, ratings)) {
          dp(i) = getIdx(i + 1, dp) + 1
        } else {
          dp(i) = getIdx(i - 1, dp) + 1
        }
      }
    }
    
    for (i <- ratings.indices) {
      iterate(i)
    }
    for (i <- Range(ratings.length - 1, -1, -1)) {
      iterate(i)
    }
    dp.sum
  }
}