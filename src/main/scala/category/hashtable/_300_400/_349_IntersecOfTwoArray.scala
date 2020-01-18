package category.hashtable._300_400


/**
  * 349. Intersection of Two Arrays
  */
object _349_IntersecOfTwoArray {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    nums1.toSet.intersect(nums2.toSet).toArray
  }
}