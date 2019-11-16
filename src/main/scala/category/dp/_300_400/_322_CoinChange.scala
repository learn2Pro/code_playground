package category.dp._300_400

/**
  * 322. Coin Change
  */
object _322_CoinChange {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    if (coins.isEmpty) return -1
    val dp = Array.tabulate(amount + 1)(_ => Int.MaxValue)
    dp(0) = 0
    for (i <- 1 to amount) {
      for (coin <- coins if i >= coin && dp(i - coin) != Int.MaxValue) {
        dp(i) = Math.min(dp(i), dp(i - coin) + 1)
      }
    }
    if (dp.last == Int.MaxValue) -1 else dp.last
  }
}