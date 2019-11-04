package category.array


/**
  * 581. Shortest Unsorted Continuous Subarray
  */
object ShortestUnsortedSubArray {
  /*using stack*/
  
  import java.util
  
  def findUnsortedSubarray(nums: Array[Int]): Int = {
    val stack = new util.Stack[Int]
    var left = nums.length
    for (i <- nums.indices) {
      if (stack.isEmpty || nums(i) > nums(stack.peek())) stack.push(i)
      else {
        while (!stack.isEmpty && nums(stack.peek()) > nums(i)) {
          left = Math.min(left, stack.pop())
        }
      }
    }
    stack.clear()
    var right = 0
    for (i <- Range(nums.length - 1, -1, -1)) {
      if (stack.isEmpty || nums(i) < nums(stack.peek())) stack.push(i)
      else {
        while (!stack.isEmpty && nums(stack.peek()) < nums(i)) {
          right = Math.max(right, stack.pop())
        }
      }
    }
    if (right > left) right - left + 1 else 0
  }
  
  /*using sort*/
  def findUnsortedSubarrayV0(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    var left = 0
    while (left < nums.length && nums(left) == sorted(left)) {
      left += 1
    }
    var right = nums.length - 1
    while (right >= 0 && nums(right) == sorted(right)) {
      right -= 1
    }
    if (right <= left) 0 else right - left + 1
  }
}