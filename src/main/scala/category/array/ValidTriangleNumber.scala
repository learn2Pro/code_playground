package category.array

/**
  * 611. Valid Triangle Number
  */
object ValidTriangleNumber {
  def triangleNumber(nums: Array[Int]): Int = {
    if (nums.length < 3) return 0
    val sorted = nums.sorted
    var ans = 0
    
    def isTriangle(i: Int, j: Int, k: Int) = {
      sorted(i) != 0 && sorted(j) != 0 && sorted(k) != 0 && sorted(i) + sorted(j) > sorted(k)
    }
    
    for (i <- Range(sorted.length - 1, 1, -1)) {
      var left = 0
      var right = i - 1
      while (left < right) {
        if (isTriangle(left, right, i)) {
          ans += (right - left)
          right -= 1
        } else {
          left += 1
        }
      }
    }
    ans
  }
}