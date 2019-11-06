package category.array._700_800

/**
  * 713. Subarray Product Less Than K
  */
object _713_SubArrayProductLTK {
  
  
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    val n = nums.length
    case class LTWindow(var start: Int, var end: Int, k: Int) {
      var product: Int = 1
      var ans    : Int = if (product < k) 1 else 0
      for (i <- start to end) {
        product *= nums(i)
      }
      
      def moveLeft(): Unit = {
        /*early stop*/
        if (end >= n - 1 && product < k) {
          start = n
          return
        }
        /*normal move*/
        product /= nums(start)
        if (product < k && end < n - 1) {
          ans += (end - start)
        }
        start += 1
      }
      
      def moveRight(): Unit = {
        end += 1
        product *= nums(end)
        if (product < k) {
          ans += (end - start + 1)
        }
      }
      
      def oneStep = {
        if (product < k && end < n - 1) {
          moveRight()
        } else {
          moveLeft()
        }
      }
      
      def reach = end >= n || start > end
      
      def iterate: Int = {
        while (!reach) {
          oneStep
        }
        ans
      }
    }
    
    LTWindow(0, 0, k).iterate
  }
}