package category.math._500_600

/**
  * 593. Valid Square
  */
object _593_ValidaSquare {
  def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {
    def dist(input: Array[Int], other: Array[Int]) = {
      (input(0) - other(0)) * (input(0) - other(0)) + (input(1) - other(1)) * (input(1) - other(1))
    }
    
    val sorted = Array(p1, p2, p3, p4).sorted(new Ordering[Array[Int]] {
      override def compare(x: Array[Int], y: Array[Int]): Int = {
        if (x(0) == y(0)) {
          x(1) - y(1)
        } else {
          x(0) - y(0)
        }
      }
    })
    
    dist(sorted(0), sorted(1)) != 0 &&
            dist(sorted(0), sorted(1)) == dist(sorted(1), sorted(3)) &&
            dist(sorted(1), sorted(3)) == dist(sorted(3), sorted(2)) &&
            dist(sorted(3), sorted(2)) == dist(sorted(2), sorted(0)) &&
            dist(sorted(0), sorted(3)) == dist(sorted(1), sorted(2))
  }
}