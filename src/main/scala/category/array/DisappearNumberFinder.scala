package category.array

/**
  * 448. Find All Numbers Disappeared in an Array
  */
object DisappearNumberFinder {
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    var ans: List[Int] = Nil
    for (i <- nums.indices) {
      val idx = Math.abs(nums(i))
      if (nums(idx - 1) > 0) nums(idx - 1) *= -1
    }
    for (i <- nums.indices if nums(i) > 0) {
      ans ::= (i + 1)
    }
    ans
  }
}