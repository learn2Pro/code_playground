package category.dp._400_500

/**
  * 466. Count The Repetitions
  */
object _466_CountTheRepetitions {
  def getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int = {
    if (n1 == 0) return 0
    val len1 = s2.length
    val countArr = new Array[Int](n1)
    val indexArr = new Array[Int](n1)
    var index, repeat = 0
    for (i <- 0 until n1) {
      for (c <- s1) {
        if (c == s2(index)) index += 1
        if (index == len1) {
          index = 0
          repeat += 1
        }
      }
      indexArr(i) = index
      countArr(i) = repeat
      for (k <- 0 until i if indexArr(k) == index) {
        val prev = countArr(k)
        val pattern = (countArr(i) - countArr(k)) * ((n1 - k - 1) / (i - k))
        val remain = countArr(k + (n1 - k - 1) % (i - k)) - countArr(k)
        return (prev + pattern + remain) / n2
      }
    }
    repeat / n2
  }
}