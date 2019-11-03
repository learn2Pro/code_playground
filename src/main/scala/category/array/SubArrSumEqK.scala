package category.array


/**
  * 560. Subarray Sum Equals K
  */
object SubArrSumEqK {
  
  //  case class Win(reduce: Array[Int], k: Int) {
  //    var sum         = reduce(0)
  //    var left, right = 0
  //    var ans         = 0
  //    /*init*/
  //
  //    def reach: Boolean = left > right || right >= reduce.length
  //
  //    def iterate: Int = {
  //      while (!reach) {
  //        if (sum < k) moveRight
  //        else {
  //          if (sum == k) ans += 1
  //          moveLeft
  //        }
  //      }
  //      ans
  //    }
  //
  //    private def moveRight = {
  //      if ((right + 1 < reduce.length && sum + reduce(right + 1) > sum) || left >= right) {
  //        sum += reduce(right + 1)
  //        right += 1
  //      } else {
  //        sum -= reduce(left)
  //        left += 1
  //      }
  //    }
  //
  //    private def moveLeft = {
  //      if (left + 1 < reduce.length && sum - reduce(left + 1) < sum) {
  //        sum -= reduce(left)
  //        left += 1
  //      } else {
  //        if (right + 1 < reduce.length) sum += reduce(right + 1)
  //        right += 1
  //      }
  //    }
  //  }
  //
  //  def subarraySum(nums: Array[Int], k: Int): Int = {
  //    if (nums == null || nums.isEmpty) return 0
  //    Win(nums, k).iterate
  //  }
  import scala.collection.mutable
  
  def subarraySum(nums: Array[Int], k: Int): Int = {
    if (nums == null || nums.isEmpty) return 0
    val map = new mutable.HashMap[Int, Int]
    map.put(0, 1)
    var sum, ans = 0
    nums.foreach { num =>
      sum += num
      if (map.contains(sum - k)) ans += map(sum - k)
      map.put(sum, map.getOrElse(sum, 0) + 1)
    }
    ans
  }
}