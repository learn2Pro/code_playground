package week42

/**
  * 169. Majority Element
  */
object MajorityElementII {
  //  import scala.collection.JavaConversions._
  //  def majorityElement(nums: Array[Int]): List[Int] = {
  //    val counter = new util.HashMap[Int, Int]()
  //    nums.foreach { num =>
  //      if (counter.containsKey(num)) counter.put(num, counter.get(num) + 1)
  //      else counter.put(num, 1)
  //    }
  //    counter.filter(_._2)
  //  }
  
  def majorityElement(nums: Array[Int]): List[Int] = {
    var candidate0 = 0
    var candidate1 = 0
    var count0 = 0
    var count1 = 0
    for (i <- nums.indices) {
      if (nums(i) == candidate0) count0 += 1
      else if (nums(i) == candidate1) count1 += 1
      else if (count0 == 0) {
        candidate0 = nums(i)
        count0 = 1
      }
      else if (count1 == 0) {
        candidate1 = nums(i)
        count1 = 1
      }
      else {
        count0 -= 1
        count1 -= 1
      }
    }
    count0 = 0
    count1 = 0
    for (num <- nums) {
      if (num == candidate0) count0 += 1
      if (num == candidate1) count1 += 1
    }
    var ans: List[Int] = Nil
    if (count0 > nums.length / 3) ans = candidate0 :: ans
    if (count1 > nums.length / 3) ans = candidate1 :: ans
    ans.distinct
  }
}