package category.stack

import java.util

/**
  * 456. 132 Pattern
  *
  * [1,2,3,4]
  * [3, 1, 4, 2]
  * [-1, 3, 2, 0]
  * []
  * [1,2]
  * [6,12,3,4,6,20,11]
  * [6,12,3,4,6,11,20]
  */
object _456_Solution {
  def find132pattern(nums: Array[Int]): Boolean = {
    val N = nums.length
    if (N < 3) return false
    val minArray = new Array[Int](N)
    minArray(0) = nums(0)
    for (i <- 1 until N) minArray(i) = Math.min(minArray(i - 1), nums(i))
    val stack = new util.Stack[Int]
    for (j <- Range(N - 1, -1, -1)) {
      while (!stack.isEmpty && stack.peek() <= minArray(j)) stack.pop()
      if (!stack.isEmpty && stack.peek() < nums(j)) return true
      stack.push(nums(j))
    }
    false
  }
}