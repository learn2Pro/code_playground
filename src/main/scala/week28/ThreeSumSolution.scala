package week28

import scala.collection.mutable.ArrayBuffer


/**
  * @author tang
  * @date 2019/07/13
  */
object ThreeSumSolution {
  //  def threeSum(nums: Array[Int]): List[List[Int]] = {
  //    for (xs @ List(a, b, c) <- nums.toList.combinations(3).toList if a + b + c == 0) yield {
  //      xs
  //    }
  //  }
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums == null || nums.length < 3) {
      List.empty[List[Int]]
    }else if(nums.distinct.length==1){
      if (nums(0) == 0) {
        List(List(0,0,0))
      }else{
        List.empty[List[Int]]
      }
    } else {
      val sorted = nums.sorted
      val len = nums.length
      val ans = new ArrayBuffer[List[Int]]()
      var idx = 1
      while (idx < len - 1) {
        var left = 0
        var right = len - 1
        val curr = sorted(idx)
        var notEnd = true
        while (notEnd) {
          val target = -1 * curr
          if (sorted(left) + sorted(right) == target) {
            ans.append(List(sorted(left), curr, sorted(right)))
            if (left == idx - 1 && right == idx + 1) {
              notEnd = false
            } else {
              if (left < idx - 1) {
                left += 1
              }
              if (right > idx + 1) {
                right -= 1
              }
            }
          } else if (sorted(left) + sorted(right) > target) {
            if (right == idx + 1) {
              notEnd = false
            } else {
              while (right > idx + 1 && sorted(right - 1) == sorted(right)) {
                right -= 1
              }
              if (right > idx + 1) {
                right -= 1
              }
            }
          } else {
            if (left == idx - 1) {
              notEnd = false
            } else {
              while (left < idx - 1 && sorted(left + 1) == sorted(left)) {
                left += 1
              }
              if (left < idx - 1) {
                left += 1
              }
            }
          }
        }
        idx += 1
      }
      ans.distinct.toList
    }
  }

  //  def threeSum(nums: Array[Int]): List[List[Int]] = {
  //    util.Arrays.parallelSort(nums)
  //    var idx = 1
  //    val lookUp = NumLookUp()
  //    nums.foreach(lookUp.add)
  //    lookUp.del(nums(1))
  //    var ans = List.empty[List[Int]]
  //    while (idx < nums.length - 1) {
  //      var tmp = 0
  //      val curr = nums(idx)
  //      while (tmp < idx) {
  //        val target = 0 - curr - nums(tmp)
  //        lookUp.del(nums(tmp))
  //        if (lookUp.contains(target)) {
  //          ans ::= List(nums(tmp), curr, target)
  //        }
  //        tmp += 1
  //      }
  //      tmp -= 1
  //      while (tmp >= 0) {
  //        lookUp.add(nums(tmp))
  //        tmp -= 1
  //      }
  //      //跳过相同的数
  //      while (idx < nums.length - 1 && nums(idx + 1) == nums(idx)) {
  //        lookUp.del(nums(idx + 1))
  //        lookUp.add(nums(idx))
  //        idx += 1
  //      }
  //      if (idx < nums.length - 1) {
  //        lookUp.del(nums(idx + 1))
  //        lookUp.add(nums(idx))
  //      }
  //      idx += 1
  //    }
  //    ans.distinct
  //  }
  //
  //  case class NumLookUp(loopUp: java.util.HashMap[Int, Int] = new util.HashMap[Int, Int]()) {
  //    def add(num: Int) = {
  //      if (loopUp.containsKey(num)) {
  //        loopUp.put(num, loopUp.get(num) + 1)
  //      } else {
  //        loopUp.put(num, 1)
  //      }
  //    }
  //
  //    def del(num: Int) = {
  //      if (loopUp.containsKey(num)) {
  //        val v = loopUp.get(num)
  //        if (v - 1 == 0) {
  //          loopUp.remove(num)
  //        } else {
  //          loopUp.put(num, v - 1)
  //        }
  //      }
  //    }
  //
  //    def contains(k: Int) = {
  //      loopUp.containsKey(k)
  //    }
  //
  //    override def clone(): AnyRef = {
  //      NumLookUp(loopUp.clone().asInstanceOf[java.util.HashMap[Int, Int]])
  //    }
  //  }

  //    def threeSum(nums: Array[Int]): List[List[Int]] = {
  //      if (nums == null || nums.length < 3) {
  //        List.empty[List[Int]]
  //      } else {
  //        val exists = new util.HashSet[Int]()
  //        val twoSumLookUp = TwoSumLookUp()
  //        exists.add(nums(0))
  //        exists.add(nums(1))
  //        twoSumLookUp.add(nums(0), nums(1))
  //        var idx = 2
  //        var ans = List.empty[List[Int]]
  //        while (idx < nums.length) {
  //          val curr = nums(idx)
  //          if (twoSumLookUp.contains(-1 * curr)) {
  //            twoSumLookUp.get(-1 * curr).foreach {
  //              case (n0, n1) =>
  //                ans ::= List(n0, n1, curr)
  //            }
  //          }
  //          val iter = exists.iterator()
  //          while (iter.hasNext) {
  //            twoSumLookUp.add(iter.next(), curr)
  //          }
  //          exists.add(curr)
  //          idx += 1
  //        }
  //        ans.distinct
  //      }
  //    }
  //
  //
  //    def searchTwoSum(lookUp: NumLookUp, arr: Array[Int], target: Int, limit: Int, ans: List[List[Int]]) = {
  //      var idx = 0
  //      var ans0 = ans
  //      while (idx < limit - 1) {
  //        val v = arr(idx)
  //        lookUp.del(v)
  //        if (lookUp.contains(target - v)) {
  //          ans0 ::= List(v, target - v, -1 * target)
  //        }
  //        idx += 1
  //      }
  //      idx -= 1
  //      while (idx >= 0) {
  //        lookUp.add(arr(idx))
  //        idx -= 1
  //      }
  //      ans0
  //    }
  //
  //    case class TwoSumLookUp(loopUp: util.HashMap[Int, ArrayBuffer[(Int, Int)]] = new util.HashMap[Int, ArrayBuffer[(Int, Int)]]()) {
  //      def add(num0: Int, num1: Int) = {
  //        if (loopUp.containsKey(num0 + num1)) {
  //          val buffer = loopUp.get(num0 + num1)
  //          buffer.append((num0, num1))
  //          loopUp.put(num0 + num1, buffer)
  //        } else {
  //          loopUp.put(num0 + num1, ArrayBuffer((num0, num1)))
  //        }
  //      }
  //
  //      def get(v: Int) = {
  //        loopUp.get(v)
  //      }
  //
  //      def contains(k: Int) = {
  //        loopUp.containsKey(k)
  //      }
  //    }
  //
  //    case class NumLookUp(loopUp: java.util.HashMap[Int, Int] = new util.HashMap[Int, Int]()) {
  //      def add(num: Int) = {
  //        if (loopUp.containsKey(num)) {
  //          loopUp.put(num, loopUp.get(num) + 1)
  //        } else {
  //          loopUp.put(num, 1)
  //        }
  //      }
  //
  //      def del(num: Int) = {
  //        if (loopUp.containsKey(num)) {
  //          val v = loopUp.get(num)
  //          if (v - 1 == 0) {
  //            loopUp.remove(num)
  //          } else {
  //            loopUp.put(num, v - 1)
  //          }
  //        }
  //      }
  //
  //      def contains(k: Int) = {
  //        loopUp.containsKey(k)
  //      }
  //    }

}
