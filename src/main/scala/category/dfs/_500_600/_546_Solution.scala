package category.dfs._500_600

/**
  * 546. Remove Boxes
  */
object _546_Solution {
  def removeBoxes(boxes: Array[Int]): Int = {
    /*i,j the left,right pointer*/
    /*k the left unit same in boxes[i]*/
    if (boxes == null || boxes.isEmpty) return 0
    val N = boxes.length
    val dp = Array.ofDim[Int](N, N, N)
    for (i <- Range(N - 1, -1, -1)) {
      /*init dp(i)(i)*/
      for (k <- 0 to i) dp(i)(i)(k) = (k + 1) * (k + 1)
      for (j <- i + 1 until N)
        for (k <- 0 to i) {
          dp(i)(j)(k) = (k + 1) * (k + 1) + dp(i + 1)(j)(0)
          for (inner <- i + 1 to j) {
            /*remove the mid,concat the left and latter right*/
            if (boxes(inner) == boxes(i)) dp(i)(j)(k) = Math.max(dp(i)(j)(k), dp(i + 1)(inner - 1)(0) + dp(inner)(j)(k + 1))
          }
        }
    }
    dp(0)(N - 1)(0)
  }
}