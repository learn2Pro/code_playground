package category.math._700_800

/**
  * 781. Rabbits in Forest
  */
object _781_RabbitsInForest {
  def numRabbits(answers: Array[Int]): Int = {
    if (answers.isEmpty) return 0
    answers.groupBy(identity).map { case (k, arr) =>
      val num = k + 1
      num * Math.ceil(arr.length * 1.0 / num).toInt
    }.sum
  }
}