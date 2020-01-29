package category.bsearch._200_300

/**
  * 275. H-Index II
  */
object _275_Solution {
  def hIndex(citations: Array[Int]): Int = {
    val N = citations.length
    if (N == 0) return 0
    var lo = 0
    var hi = N - 1
    var ans = Math.min(N, citations(0))
    while (lo <= hi) {
      val mid = (lo + hi) >>> 1
      if ((N - mid) >= citations(mid)) {
        ans = Math.max(ans, citations(mid))
        lo = mid + 1
      } else {
        ans = Math.max(ans, N - mid)
        hi = mid - 1
      }
    }
    ans
  }
}