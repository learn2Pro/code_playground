package category.time.week20

import scala.collection.parallel.mutable.ParArray


object KnightDialer {
  val hopMapping = Map(
    0 -> Array(4, 6),
    1 -> Array(6, 8),
    2 -> Array(7, 9),
    3 -> Array(4, 8),
    4 -> Array(0, 3, 9),
    5 -> Array.emptyIntArray,
    6 -> Array(0, 1, 7),
    7 -> Array(2, 6),
    8 -> Array(1, 3),
    9 -> Array(2, 4)
  )

  def knightDialer(N: Int): Int = {
    val starts: ParArray[Int] = ParArray(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    var steps = 10
    if (N <= 0) {
      starts.length
    } else {
      for (step <- 0 until N) {
        var input: ParArray[Int] = starts
        input = call(input)
        steps = input.length
//        input = input.distinct
      }
      steps % (Math.pow(10.0, 9.0).toInt + 7)
    }
  }

  def call(start: ParArray[Int]): ParArray[Int] = {
    start.par.flatMap {
      id =>
        hopMapping.getOrElse(id, Array.emptyIntArray)
    }
  }
}
