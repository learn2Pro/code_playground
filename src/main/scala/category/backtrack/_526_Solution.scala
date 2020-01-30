package category.backtrack

import java.util

/**
  * 526. Beautiful Arrangement
  * 1
  * 2
  * 3
  * 4
  * 5
  *
  */
object _526_Solution {
  val slots = Map(
    1 -> Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
    2 -> Array(1, 2, 4, 6, 8, 10, 12, 14),
    3 -> Array(1, 3, 6, 9, 12, 15),
    4 -> Array(1, 2, 4, 8, 12),
    5 -> Array(1, 5, 10, 15),
    6 -> Array(1, 2, 3, 6, 12),
    7 -> Array(1, 7, 14),
    8 -> Array(1, 2, 4, 8),
    9 -> Array(1, 3, 9),
    10 -> Array(1, 2, 5, 10),
    11 -> Array(1, 11),
    12 -> Array(1, 2, 3, 4, 6, 12),
    13 -> Array(1, 13),
    14 -> Array(1, 2, 7, 14),
    15 -> Array(1, 3, 5, 15)
  )
  
  def countArrangement(N: Int): Int = {
    
    val remain = new util.HashSet[Int]()
    
    def backtrack(one: Int): Int = {
      if (remain.size() == 0) return 1
      val sum = slots(one).map { skip =>
        if (remain.contains(skip)) {
          remain.remove(skip)
          val count = backtrack(one + 1)
          remain.add(skip)
          count
        } else 0
      }.sum
      if (sum == 0) return 0
      sum
    }
    
    for (i <- 1 to N) remain.add(i)
    backtrack(1)
  }
}