package category.dp._600_700

/**
  * 698. Partition to K Equal Sum Subsets
  */
object _698_PartitionToKEqSumSubsets {
  
  import scala.collection.JavaConversions._
  
//  def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
//    val holder = new java.util.HashMap[Int, Int]()
//    var sum = 0
//    nums.foreach { num =>
//      sum += num
//      if (holder.containsKey(num)) holder.put(num, holder.get(num) + 1)
//      else holder.put(num, 1)
//    }
//    val avg = sum / k
//
//    def findTarget(target: Int): Boolean = {
//      if (target == 0) return true
//      if (target < 0) return false
//      if (holder.isEmpty) return true
//      if (holder.containsKey(target)) return true
//      holder.keySet().foreach { k =>
//        if (k < target && findTarget(target - k)) {
//
//        }
//      }
//    }
//  }
}