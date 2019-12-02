package category.mock_exam

import scala.collection.mutable

object Mock_Exam_20191127_3 {
//  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
//    val m = matrix.length
//    val n = matrix(0).length
//    val visited = new mutable.HashSet[(Int, Int)]()
//
//    def get(loc: (Int, Int)): Long = {
//      if (loc._1 < 0 || loc._1 >= m) return Long.MaxValue
//      if (loc._2 < 0 || loc._2 >= n) return Long.MaxValue
//      matrix(loc._1)(loc._2)
//    }
//
//    def backTrack(input: (Int, Int), moved: Int): Int = {
//      if (input._1 < 0 || input._1 >= m) return moved
//      if (input._2 < 0 || input._2 >= n) return moved
//      visited.add(input)
//      val left = get((input._1 - 1, input._2))
//      val right = get((input._1 + 1, input._2))
//      val up = get((input._1, input._2 - 1))
//      val down = get((input._1, input._2 + 1))
//      var ans = moved
//      if (left < get(input)) ans = Math.max(ans, backTrack((input._1 - 1, input._2), moved + 1))
//      if (right < get(input)) ans = Math.max(ans, backTrack((input._1 + 1, input._2), moved + 1))
//      if (up < get(input)) ans = Math.max(ans, backTrack((input._1, input._2 - 1), moved + 1))
//      if (down < get(input)) ans = Math.max(ans, backTrack((input._1, input._2 + 1), moved + 1))
//      ans
//    }
//
//    for (i <- 0 until m)
//      for (j <- 0 until n if ) {
//        backTrack((i, j), 1)
//      }
//  }
}