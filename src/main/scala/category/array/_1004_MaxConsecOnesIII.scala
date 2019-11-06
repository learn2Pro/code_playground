package category.array

/**
  * 1004. Max Consecutive Ones III
  */
object _1004_MaxConsecOnesIII {
  
  case class Win(reduce: Array[Int], k: Int) {
    var sum, ans   = 0
    var remain     = k
    var start, idx = 0
    /*init*/
    moveRight
    
    def reach: Boolean = idx >= reduce.length
    
    def once = {
      /*move left*/
      while (reduce(start) != 0) {
        sum -= reduce(start)
        start += 1
      }
      start += 1
      sum -= 1
      remain += 1
      /*move right*/
      moveRight
    }
    
    def iterate: Int = {
      while (!reach) once
      ans
    }
    
    private def moveRight = {
      while (idx < reduce.length && (remain > 0 || (remain == 0 && reduce(idx) > 0))) {
        if (reduce(idx) == 0) {
          remain -= 1
          sum += 1
        } else {
          sum += reduce(idx)
        }
        idx += 1
      }
      ans = Math.max(sum, ans)
    }
  }
  
  def longestOnes(A: Array[Int], K: Int): Int = {
    if (A == null || A.isEmpty) return 0
    Win(A, K).iterate
  }
}