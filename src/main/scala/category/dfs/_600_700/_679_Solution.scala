package category.dfs._600_700

/**
  * 679. 24 Game
  */
object _679_Solution {
  def judgePoint24(nums: Array[Int]): Boolean = {
    
    def judge2(sub: Array[BigDecimal], target: BigDecimal): Boolean = {
      if (sub.length != 2) return false
      for (i <- 0 until 2) {
        if (sub(i) + sub(1 - i) == target) return true
        if (sub(i) - sub(1 - i) == target) return true
        if (sub(i) * sub(1 - i) == target) return true
        if (sub(1 - i) != 0 && sub(i) / sub(1 - i) == target) return true
      }
      false
    }
    
    def judge3(sub: Array[BigDecimal], target: BigDecimal): Boolean = {
      if (sub.length != 3) return false
      for (i <- 0 until 3) {
        val curr = sub(i)
        val other = Array(sub((i + 1) % 3), sub((i + 2) % 3))
        if (judge2(other, target - curr)) return true
        if (judge2(other, curr - target)) return true
        if (judge2(other, curr + target)) return true
        if (curr == 0 & target == 0) return true
        if (curr != 0 && target != 0 && judge2(other, target / curr)) return true
        if (curr != 0 && target != 0 && judge2(other, curr / target)) return true
        if (curr != 0 && target != 0 && judge2(other, target * curr)) return true
      }
      false
    }
    
    def compute2(sub: Array[BigDecimal]): Array[BigDecimal] = {
      var ans = Array(
        sub(0) + sub(1),
        sub(0) * sub(1),
        sub(0) - sub(1),
        sub(1) - sub(0)
      )
      if (sub(0) != 0) ans ++= Array(sub(1) / sub(0))
      if (sub(1) != 0) ans ++= Array(sub(0) / sub(1))
      ans
    }
    
    def judge4(sub: Array[BigDecimal], target: BigDecimal): Boolean = {
      if (sub.length != 4) return false
      /*(1,3)*/
      for (i <- 0 until 4) {
        val curr = sub(i)
        val other = Array(sub((i + 1) % 4), sub((i + 2) % 4), sub((i + 3) % 4))
        if (judge3(other, target - curr)) return true
        if (judge3(other, curr - target)) return true
        if (judge3(other, curr + target)) return true
        if (curr == 0 & target == 0) return true
        if (curr != 0 && target != 0 && judge3(other, target / curr)) return true
        if (curr != 0 && target != 0 && judge3(other, curr / target)) return true
        if (curr != 0 && target != 0 && judge3(other, target * curr)) return true
      }
      /*(2,2)*/
      Array(
        (Array(sub(0), sub(1)), Array(sub(2), sub(3))),
        (Array(sub(0), sub(2)), Array(sub(1), sub(3))),
        (Array(sub(0), sub(3)), Array(sub(1), sub(2)))
      ).foreach { case (curr, other) =>
        compute2(curr).foreach { v =>
          val newly = other ++ Array(v)
          if (judge3(newly, target)) return true
          if (judge3(newly, target)) return true
          if (judge3(newly, target)) return true
          if (judge3(newly, target)) return true
          if (judge3(newly, target)) return true
          if (judge3(newly, target)) return true
        }
      }
      false
    }
    
    judge4(nums.map(BigDecimal.apply), 24)
  }
}