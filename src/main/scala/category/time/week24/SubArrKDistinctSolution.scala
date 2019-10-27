package category.time.week24

import java.util

object SubArrKDistinctSolution {
  /**
    * Given an array A of positive integers, call a (contiguous, not necessarily distinct)
    * subarray of A good if the number of different integers in that subarray is exactly K.
    *
    * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
    *
    * Return the number of good subarrays of A.
    *
    * Example 1:
    *
    * Input: A = [1,2,1,2,3], K = 2
    * Output: 7
    * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
    *
    * Example 2:
    *
    * Input: A = [1,2,1,3,4], K = 3
    * Output: 3
    * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
    *
    * Note:
    *
    * 1 <= A.length <= 20000
    * 1 <= A[i] <= A.length
    * 1 <= K <= A.length
    *
    * @param A
    * @param K
    * @return
    */
  def subarraysWithKDistinct(A: Array[Int], K: Int): Int = {
    val len = A.length
    val w0 = new Window
    val w1 = new Window
    var left0 = 0
    var left1 = 0
    var right = 0
    var ans = 0

    while (right < len) {
      w0.add(A(right))
      w1.add(A(right))
      while (w0.different == K) {
        w0.minus(A(left0))
        left0 += 1
      }
      while (w1.different > K) {
        w1.minus(A(left1))
        left1 += 1
      }
      ans += (left0 - left1)
      right += 1
    }
    ans
  }

  /**
    * 查找表，如果表中miss，进行计算
    * [i,j]中distinct num = k or k-1
    *
    * 空间复杂度:
    * i->i+k
    * i->i+k+1
    * ...
    * i->j
    * i+1->j
    * i+1->j-1
    * ...
    * i+1->i+k+1
    * i+2->i+k+2
    * ...
    * i+3->j
    * 依次迭代下去 O(n)空间满足需求
    * 剪枝 如果i->i+k已经大于k，这后续不需要判断
    * 如果i->i+k+1已经小于k，则i+1->i+k+1不需要运算
    *
    * 时间复杂度:
    *
    * @param A
    * @param K
    * @param left
    * @param right
    * @param lookUp            查找表，表示数组A中从 [i,j]中，distinct num=k的数量
    * @param distinctNumLookUp distinct num -> num size 只有0到K-1的数字
    * @return
    */
  def search(A: Array[Int], K: Int, left: Int, right: Int,
             lookUp: java.util.HashMap[(Int, Int), Int],
             distinctNumLookUp: Window): Int = {
    var number = 0
    var leftOfLocal = left
    var rightOfLocal = K - 1
    var asc = true
    while (leftOfLocal <= right - K + 1) {
      //只能到k+left，保证中间slide窗口大于K
      while (rightOfLocal >= K + leftOfLocal - 1 && rightOfLocal <= right) {
        //添加元素
        if (asc) {
          distinctNumLookUp.add(A(rightOfLocal))
        }
        val size = stat(K, leftOfLocal, rightOfLocal, lookUp, distinctNumLookUp)
        if (size == K) {
          number += 1
        }
        //迭代
        if (asc) {
          rightOfLocal += 1
        } else {
          //减掉元素
          distinctNumLookUp.minus(A(rightOfLocal))
          rightOfLocal -= 1
        }
      }
      //right index 迭代升序变降序
      distinctNumLookUp.minus(A(leftOfLocal))
      leftOfLocal += 1
      if (asc) {
        rightOfLocal -= 1
      } else {
        //划窗内数字个数至少大于K
        rightOfLocal = leftOfLocal + K - 1
        for (idx <- leftOfLocal until rightOfLocal) {
          distinctNumLookUp.add(A(idx))
        }
      }
      asc = !asc

    }
    number
  }

  private def stat(K: Int, left: Int, right: Int, lookUp: util.HashMap[(Int, Int), Int],
                   distinctNumLookUp: Window): Int = {
    val size = if (
      (lookUp.containsKey((left + 1, right)) && lookUp.get((left + 1, right)) >= K + 1) ||
        (lookUp.containsKey((left, right - 1)) && lookUp.get((left, right - 1)) >= K + 1)) {
      K + 1
    } else if (
      (lookUp.containsKey((left - 1, right)) && lookUp.get((left - 1, right)) <= K - 1) ||
        (lookUp.containsKey((left, right + 1)) && lookUp.get((left, right + 1)) <= K - 1)) {
      K - 1
    } else {
      distinctNumLookUp.different
    }
    lookUp.put((left, right), size)
    size
  }

  case class Window(distinctNumLookUp: java.util.HashMap[Int, Int] = new java.util.HashMap[Int, Int](), var different: Int = 0) {
    /**
      * 添加
      *
      * @param num
      */
    def add(num: Int): Unit = {
      if (distinctNumLookUp.containsKey(num)) {
        val add = distinctNumLookUp.get(num) + 1
        distinctNumLookUp.put(num, add)
      } else {
        distinctNumLookUp.put(num, 1)
        different += 1
      }
    }

    /**
      * 删除
      *
      * @param num
      */
    def minus(num: Int): Unit = {
      if (distinctNumLookUp.containsKey(num)) {
        val minus = distinctNumLookUp.get(num) - 1
        if (minus == 0) {
          distinctNumLookUp.remove(num)
          different -= 1
        } else {
          distinctNumLookUp.put(num, minus)
        }

      }
    }
  }


}
