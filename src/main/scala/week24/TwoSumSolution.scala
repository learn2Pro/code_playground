package week24

import java.util

object TwoSumSolution {
  def twoSumSorted(numbers: Array[Int], target: Int): Array[Int] = {
    val size = numbers.length
    if (numbers(size - 1) + numbers(size - 2) < target) {
      throw new RuntimeException(s"not supported the targe find,because the list max sum is less than target:$target")
    }
    var left = 0
    var right = size - 1
    var resultIndexOfLeft = 0
    var resultIndexOfRight = 0
    while (left < right) {
      if (numbers(left) + numbers(right) == target) {
        resultIndexOfLeft = left
        resultIndexOfRight = right
        left = Int.MaxValue
        right = Int.MinValue
      } else if (numbers(left) + numbers(right) < target) {
        left = left + 1
      } else if (numbers(left) + numbers(right) > target) {
        right = right - 1
      }
    }
    Array(resultIndexOfLeft + 1, resultIndexOfRight + 1)
  }

  def twoSumNormal(nums: Array[Int], target: Int): Array[Int] = {
    val size = nums.length
    val numLookUp = new util.HashMap[Int, Int]()
    var idx = 0
    var result: Array[Int] = null.asInstanceOf[Array[Int]]
    while (idx < size) {
      val curr = nums(idx)
      if (numLookUp.containsKey(target - curr)) {
        result = Array(numLookUp.get(target - curr), idx)
      }
      numLookUp.put(nums(idx), idx)
      idx += 1
    }
    result
  }
}
