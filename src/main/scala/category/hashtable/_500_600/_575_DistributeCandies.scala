package category.hashtable._500_600

/**
  * 575. Distribute Candies
  */
object _575_DistributeCandies {
  def distributeCandies(candies: Array[Int]): Int = {
    val distinct = candies.distinct
    Math.min(distinct.length, candies.length / 2)
  }
}