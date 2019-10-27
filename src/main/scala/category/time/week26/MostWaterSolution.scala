package category.time.week26

/**
  * @author tang
  * @date 2019/06/30
  */
object MostWaterSolution {

  def maxArea(height: Array[Int]): Int = {
    var left = 0
    var right = height.length - 1
    var ans = 0
    while (left < right) {
      if (height(left) < height(right)) {
        ans = Math.max(ans, height(left) * (right - left))
        left += 1
      } else {
        ans = Math.max(ans, height(right) * (right - left))
        right -= 1
      }
    }
    ans
  }

  //  def maxArea(height: Array[Int]): Int = {
  //    var max = if (height(1) > height(0)) {
  //      height(0)
  //    } else {
  //      height(1)
  //    }
  //    //left,right,length
  //    var last: (Int, Int, Int) = (height(0), height(1), 1)
  //    var idx = 2
  //
  //    while (idx < height.length) {
  //      //i+1>=i
  //      if (height(idx) >= height(idx - 1)) {
  //        last = searchRight(idx, height, last)
  //      } else {
  //        //left<=right 从左往右搜索
  //        if (last._1 <= last._2) {
  //          if (last._1 >= height(idx)) {
  //            last = (last._1, height(idx), last._3 + 1)
  //          } else {
  //            last = searchRight(idx, height, last)
  //          }
  //        }
  //        //left>right 从左往右搜索
  //        else {
  //          last = searchLeft(idx, height, last)
  //        }
  //      }
  //      if (area(last) > max) {
  //        max = area(last)
  //      }
  //      idx += 1
  //    }
  //    max
  //  }

  def searchLeft(idx: Int, height: Array[Int], last: (Int, Int, Int)) = {
    val currLen = last._3
    var leftIdx = idx - currLen - 1
    val curr = area(last._1, height(idx), currLen + 1)
    var sift = 0
    var tmp = last
    while (leftIdx >= 0) {
      if (area(height(leftIdx), height(idx), currLen + sift + 1) >= curr) {
        tmp = (height(leftIdx), height(idx), currLen + sift + 1)
      }
      sift += 1
      leftIdx -= 1
    }
    tmp
  }

  def searchRight(idx: Int, height: Array[Int], last: (Int, Int, Int)) = {
    val currLen = last._3
    var leftIdx = idx - currLen - 1
    val curr = area(last._1, height(idx), currLen + 1)
    var sift = 0
    var tmp = last
    while (leftIdx < idx) {
      if (area(height(leftIdx), height(idx), currLen + sift + 1) >= curr) {
        tmp = (height(leftIdx), height(idx), currLen + sift + 1)
      }
      sift -= 1
      leftIdx += 1
    }
    tmp
  }

  def area(district: (Int, Int, Int)) = {
    if (district._1 > district._2) {
      district._2 * district._3
    } else {
      district._1 * district._3
    }
  }

}
