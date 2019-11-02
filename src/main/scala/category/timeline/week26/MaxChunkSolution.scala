package category.timeline.week26

import java.util

/**
  * @author tang
  * @date 2019/06/29
  */
object MaxChunkSolution {
  //  def maxChunksToSorted(arr: Array[Int]): Int = {
  //    val len = arr.length
  //    //init condition
  //    val buffer = new Array[Int](len)
  //    val maxBuffer = new Array[Int](len)
  //    buffer(0) = 1
  //    maxBuffer(0) = arr(0)
  //    var max = arr(0)
  //    var min = arr(0)
  //    for (idx <- 1 until len) {
  //      if (arr(idx) < min && arr(idx) != max) {
  //        buffer(idx) = 1
  //      } else if (arr(idx) >= max) {
  //        buffer(idx) = buffer(idx - 1) + 1
  //      } else {
  //        var tmpLeft = 0
  //        var tmpRight = idx
  //
  //        while (tmpLeft <= tmpRight && (arr(tmpLeft) <= arr(idx) || arr(tmpRight) >= arr(idx))) {
  //          if (arr(tmpLeft) <= arr(idx)) {
  //            tmpLeft += 1
  //          }
  //          if (arr(tmpRight) >= arr(idx)) {
  //            tmpRight -= 1
  //          }
  //        }
  //
  //        buffer(idx) = if (tmpLeft >= 1 && tmpRight >= 0 && tmpLeft < tmpRight) {
  //          var tmp = tmpLeft
  //          var minInWin = arr(tmpLeft)
  //          while (tmp <= tmpRight) {
  //            if (arr(tmp) < minInWin) {
  //              minInWin = arr(tmp)
  //            }
  //            tmp += 1
  //          }
  //          tmp = 0
  //          while (arr(tmp) <= minInWin) {
  //            tmp += 1
  //          }
  //          if (tmp >= 1) {
  //            buffer(tmp - 1) + 1
  //          } else {
  //            1
  //          }
  //        } else if (tmpLeft - 1 == tmpRight && tmpRight >= 0) {
  //          buffer(tmpLeft - 1) + 1
  //        } else {
  //          1
  //        }
  //      }
  //      if (arr(idx) <= min) {
  //        min = arr(idx)
  //      }
  //      if (arr(idx) > max) {
  //        max = arr(idx)
  //      }
  //      maxBuffer(idx) = max
  //    }
  //    buffer(len - 1)
  //  }

  /**
    * 当前maxBuffer 小于 minBuffer
    *
    * 0, 4, 7, 5, 3, 6, 9, 2, 1, 8
    * 2, 0, 1, 7, 3, 4, 5, 6
    *
    * @param arr
    * @return
    */
  //  def maxChunksToSorted(arr: Array[Int]): Int = {
  //    //    val maxBuffer = arr.clone()
  //    val minBuffer = arr.clone()
  //    val len = arr.length
  //    var ans = 1
  //    //    for (idx <- 1 until len) {
  //    //      maxBuffer(idx) = Math.max(maxBuffer(idx - 1), arr(idx))
  //    //    }
  //    var max = 0
  //    var idx = len - 2
  //    while (idx >= 0) {
  //      minBuffer(idx) = Math.min(minBuffer(idx + 1), arr(idx))
  //      idx -= 1
  //    }
  //    for (i <- 0 until len - 1) {
  //      if (arr(i) > max) {
  //        max = arr(i)
  //      }
  //      if (max <= minBuffer(i + 1)) ans += 1
  //    }
  //    ans
  //  }

  def maxChunksToSorted(arr: Array[Int]): Int = {
    val maxStack = new util.Stack[Int]
    var currMax = arr(0)
    maxStack.push(currMax)
    for (i <- 1 until arr.length) {
      if (arr(i) >= maxStack.peek()) {
        maxStack.push(arr(i))
      } else {
        currMax = maxStack.peek()
        maxStack.pop()
        while (!maxStack.empty() && maxStack.peek() > arr(i)) {
          maxStack.pop()
        }
        maxStack.push(currMax)
      }
    }
    maxStack.size()
  }

  def maxChunksToSortedSpecific(arr: Array[Int]): Int = {
    var currMax = -1
    var ans = 0
    for (i <- arr.indices) {
      if (arr(i) > currMax) {
        currMax = arr(i)
      }
      if (currMax == i) ans += 1
    }
    ans

  }

}
