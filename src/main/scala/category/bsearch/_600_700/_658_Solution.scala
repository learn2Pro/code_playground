package category.bsearch._600_700

/**
  * 658. Find K Closest Elements
  */
object _658_Solution {
  def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {
    def bsearch(arr: Array[Int], target: Int): Int = {
      var lo = 0
      var hi = arr.length - 1
      while (lo <= hi) {
        val mid = (lo + hi) >>> 1
        if (arr(mid) == target) return mid
        else if (arr(mid) < target) lo = mid + 1
        else hi = mid - 1
      }
      if (lo == 0) 0 else lo
    }
    
    val idx = bsearch(arr, x)
    val N = arr.length
    var ans: List[Int] = Nil
    var lo = idx - 1
    var hi = idx
    var remain = k
    while (remain > 0 && (lo >= 0 || hi < N)) {
      if (hi >= N || (lo >= 0 && x - arr(lo) <= arr(hi) - x)) {
        ans ::= arr(lo)
        remain -= 1
        lo -= 1
      }
      if (remain > 0 && (lo < 0 || (hi < N && x - arr(lo) > arr(hi) - x))) {
        ans ++= List(arr(hi))
        remain -= 1
        hi += 1
      }
    }
    ans
  }
}