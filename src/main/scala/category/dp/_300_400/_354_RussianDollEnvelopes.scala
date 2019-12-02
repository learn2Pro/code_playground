package category.dp._300_400


/**
  * 354. Russian Doll Envelopes
  */
object _354_RussianDollEnvelopes {
  
  import scala.collection.mutable.ArrayBuffer
  
  def maxEnvelopes(envelopes: Array[Array[Int]]): Int = {
    val sorted = envelopes.sorted(new Ordering[Array[Int]] {
      override def compare(x: Array[Int], y: Array[Int]): Int = {
        if (x(0) == y(0)) y(1) - x(1)
        else x(0) - y(0)
      }
    })
    val dp = new ArrayBuffer[Int]()
    for (i <- sorted.indices) {
      var left = 0
      var right = dp.size
      val pair = sorted(i)(1)
      while (left < right) {
        val mid = (left + right) >>> 1
        if (dp(mid) < pair) left = mid + 1
        else right = mid
      }
      if (right >= dp.length) dp.append(pair)
      else dp(right) = pair
    }
    dp.length
  }
  
  def maxEnvelopesV1(envelopes: Array[Array[Int]]): Int = {
    val sorted = envelopes.sortBy(arr => arr(0))
    val dp = Array.tabulate(envelopes.length)(_ => 1)
    
    def couldEnvelop(arr0: Array[Int], arr1: Array[Int]): Boolean = {
      arr0(0) < arr1(0) && arr0(1) < arr1(1)
    }
    
    var ans = 0
    for (i <- dp.indices) {
      for (j <- 0 until i) {
        if (couldEnvelop(sorted(j), sorted(i))) {
          dp(i) = Math.max(dp(i), dp(j) + 1)
        }
      }
      ans = Math.max(ans, dp(i))
    }
    
    ans
  }
}