package category.dp._500_600


/**
  * 546. Remove Boxes
  */
object _546_RemoveBoxes {
  def removeBoxes(boxes: Array[Int]): Int = {
    if (boxes.isEmpty) return 0
    val N = boxes.length
    val dp = Array.tabulate(N, N, N)((_, _, _) => 0)
    for (i <- 0 until N)
      for (k <- 0 to i) {
        dp(i)(i)(k) = (k + 1) * (k + 1)
      }
    for (l <- 1 until N)
      for (j <- l until N) {
        val i = j - l
        for (k <- 0 to i) {
          var res = (k + 1) * (k + 1) + dp(i + 1)(j)(0)
          for (m <- i + 1 to j) {
            if (boxes(m) == boxes(i)) {
              res = Math.max(res, dp(i + 1)(m - 1)(0) + dp(m)(j)(k + 1))
            }
          }
          dp(i)(j)(k) = res
        }
      }
    dp(0)(N - 1)(0)
  }
  
  def removeBoxesV0(boxes: Array[Int]): Int = {
    if (boxes.isEmpty) return 0
    val N = boxes.length
    val dp = Array.tabulate(N, N)((_, _) => 0)
    for (i <- Range(N - 1, -1, -1)) {
      dp(i)(i) = 1
      for (j <- i + 1 until N) {
        var tmp = j - 1
        while (tmp >= i && boxes(tmp) != boxes(j)) tmp -= 1
        val right = tmp
        while (tmp >= i && boxes(tmp) == boxes(j)) tmp -= 1
        val left = tmp
        val combine = if (right >= i) {
          var tmp = dp(right + 1)(j - 1) + (right - left + 1) * (right - left + 1)
          if (left >= i) tmp += dp(i)(left)
          tmp
        } else {
          dp(i)(j - 1) + 1
        }
        dp(i)(j) = Math.max(dp(i)(j), Math.max(dp(i)(j - 1) + 1, combine))
      }
    }
    dp(0)(N - 1)
  }
  
  import scala.collection.mutable.ArrayBuffer
  
  def removeBoxesV1(boxes: Array[Int]): Int = {
    if (boxes.isEmpty) return 0
    val N = boxes.length
    //    val dp = Array.tabulate(2, N, N)((_, _, _) => 0)
    //    var idx = 0
    //    var stop = false
    //
    //    def accumulate(arr: Array[Int]): Int = {
    //      var tag, local, global = 0
    //      for (elem <- arr if elem != 0) {
    //        if (elem == tag) local += 1
    //        else {
    //          global += (local * local)
    //          local = 0
    //        }
    //      }
    //      global
    //    }
    
    def dfs(arr: ArrayBuffer[Int], accumulate: Int): Int = {
      if (arr.isEmpty) return accumulate
      var i = 0
      var ans = accumulate
      while (i < arr.length) {
        var j = i
        val tmp = arr(i)
        while (j < arr.length && arr(j) == tmp) j += 1
        arr.remove(i, j - i)
        ans = Math.max(ans, dfs(arr, accumulate + (j - i) * (j - i)))
        arr.insertAll(i, Array.tabulate(j - i)(_ => tmp))
        i = j
      }
      ans
    }
    
    val buffer = new ArrayBuffer[Int](N)
    buffer.insertAll(0, boxes)
    dfs(buffer, 0)
  }
}