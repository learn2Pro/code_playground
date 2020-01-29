package category.greedy

/**
  * 455. Assign Cookies
  */
object _455_Solution {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    val greedy = g.sorted
    val cookies = s.sorted
    var i, j, count = 0
    while (i < greedy.length && j < cookies.length) {
      while (j < cookies.length && greedy(i) > cookies(j)) j += 1
      if (j < cookies.length) {count += 1; i += 1; j += 1}
    }
    count
  }
}