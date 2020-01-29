package category.greedy

/**
  * 502. IPO
  */
object _502_Solution {
  def findMaximizedCapital(k: Int, W: Int, Profits: Array[Int], Capital: Array[Int]): Int = {
    val N = Profits.length
    val capitalQ = new java.util.PriorityQueue[(Int, Int)](new Ordering[(Int, Int)] {
      override def compare(x: (Int, Int), y: (Int, Int)): Int = y._1 - x._1
    })
    val profitQ = new java.util.PriorityQueue[(Int, Int)](new Ordering[(Int, Int)] {
      override def compare(x: (Int, Int), y: (Int, Int)): Int = x._2 - y._2
    })
    var ans = W
    var times = 0
    for (i <- 0 until N) {
      capitalQ.add((Capital(i), Profits(i)))
    }
    while (times < k) {
      while (!capitalQ.isEmpty && capitalQ.peek()._1 <= ans) profitQ.add(capitalQ.remove())
      if (!profitQ.isEmpty) ans += profitQ.remove()._2
      times += 1
    }
    ans
  }
}