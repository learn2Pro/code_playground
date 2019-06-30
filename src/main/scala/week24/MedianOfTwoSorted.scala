package week24

object MedianOfTwoSorted {

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val total = nums1.length + nums2.length
    val medianPos = total / 2
    var pos = 0
    var firstPos = 0
    var secondPos = 0
    var near0 = 0
    var near1 = 0
    //上一次移动是，第一个or第二个数组
    var odd = true
    while (pos <= medianPos) {
      if ((secondPos >= nums2.length) || (firstPos < nums1.length && nums1(firstPos) < nums2(secondPos))) {
        if (odd) {
          near0 = nums1(firstPos)
        } else {
          near1 = nums1(firstPos)
        }
        firstPos += 1
      } else {
        if (odd) {
          near0 = nums2(secondPos)
        } else {
          near1 = nums2(secondPos)
        }
        secondPos += 1
      }
      pos += 1
      odd = !odd
    }
    if (total % 2 == 0) {
      (near0 + near1) / 2.0
    } else {
      if (odd) {
        near1
      } else {
        near0
      }
    }
  }

}
