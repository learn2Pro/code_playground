package category.bsearch._700_800

/**
  * 793. Preimage Size of Factorial Zeroes Function
  */
object _793_Solution {
  def preimageSizeFZF(K: Int): Int = {
    def trailingZero(num: Long): Int = {
      var ans = 0L
      var tmp = num
      while (tmp / 5 > 0) {
        ans += tmp / 5
        tmp /= 5
      }
      ans.toInt
    }
    
    def bsearch(num: Int): Long = {
      var lo: Long = 0
      var hi: Long = 5 * num
      while (lo < hi) {
        val mid = (lo + hi) >>> 1
        if (trailingZero(mid) < num) lo = mid + 1
        else hi = mid
      }
      lo
    }
    
    (bsearch(K + 1) - bsearch(K)).toInt
  }
}