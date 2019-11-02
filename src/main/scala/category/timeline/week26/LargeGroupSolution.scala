package category.timeline.week26

/**
  * @author tang
  * @date 2019/06/29
  */
object LargeGroupSolution {
  def largeGroupPositions(S: String): List[List[Int]] = {
    var ans: List[List[Int]] = List.empty[List[Int]]
    val len = S.length
    var left = 0
    var right = 0
    while (left < len && right < len) {
      while (right < len && S(left) == S(right)) {
        right += 1
      }
      if (right - left >= 3) {
        ans ++= List(List(left, right - 1))
      }
      left = right
    }
    ans
  }
}
