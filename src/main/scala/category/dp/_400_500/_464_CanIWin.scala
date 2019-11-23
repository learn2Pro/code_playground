package category.dp._400_500

import scala.collection.mutable

/**
  * 464. Can I Win
  */
object _464_CanIWin {
  def canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean = {
    val usedMap = new mutable.HashMap[Int, Boolean]()
    
    def canWin(length: Int, total: Int, used: Int): Boolean = {
      if (usedMap.contains(used)) return usedMap(used)
      for (i <- 0 until length) {
        val cur = 1 << i
        if ((cur & used) == 0) {
          if (total <= i + 1 || !canWin(length, total - (i + 1), cur | used)) {
            usedMap.put(used, true)
            return true
          }
        }
      }
      usedMap.put(used, false)
      false
    }
    
    if (maxChoosableInteger >= desiredTotal) return true
    if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false
    canWin(maxChoosableInteger, desiredTotal, 0)
    
  }
  
  def canIWinV1(maxChoosableInteger: Int, desiredTotal: Int): Boolean = {
    val first = new mutable.HashSet[Int]()
    val second = new mutable.HashSet[Int]()
    for (i <- 1 to maxChoosableInteger) {
      first.add(i)
      second.add(i)
    }
    
    def backTrack(remain: Int, which: Boolean): Boolean = {
      if (remain <= 0) return which
      if (which) {
        /*first player*/
        var ans0 = false
        for (step <- first if second.forall(e => e + step < remain) && !ans0) {
          first.remove(step)
          ans0 = backTrack(remain - step, which = false)
          first.add(step)
        }
        ans0
      } else {
        /*second player*/
        var ans1 = true
        for (step <- second if first.forall(e => e + step < remain) && ans1) {
          second.remove(step)
          ans1 = backTrack(remain - step, which = true)
          second.add(step)
        }
        ans1
      }
    }
    
    backTrack(desiredTotal, which = true)
  }
}