package category.math._400_500

/**
  * 441. Arranging Coins
  */
object _441_ArrangingCoins {
  def arrangeCoins(n: Int): Int = {
    val ans = (-1 + Math.sqrt(1 + 8L * n)) / 2
    ans.toInt
  }
}