package category.array

/**
  * 217. Contains Duplicate
  */
object ContainsDuplicate {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    nums.toSet.size == nums.length
  }
}