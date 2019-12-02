package category.mock_exam

object MockExam_20191130_2 {
  def hammingDistance(x: Int, y: Int): Int = {
    var ans = 0
    for (i <- 0 until 32) {
      val left = (x >>> i) & 0x01
      val right = (y >>> i) & 0x01
      if (left != right) ans += 1
    }
    ans
  }
}