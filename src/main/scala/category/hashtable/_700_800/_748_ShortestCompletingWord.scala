package category.hashtable._700_800

/**
  * 748. Shortest Completing Word
  */
object _748_ShortestCompletingWord {
  private val primes = Array(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103)
  
  def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {
    def product(s: String): Long = {
      var product = 1L
      s.foreach { c =>
        if (Character.isLetter(c)) product *= primes(c.toLower - 'a')
      }
      product
    }
    
    val base = product(licensePlate)
    var min = Integer.MAX_VALUE
    var ans = ""
    words.foreach { word =>
      if (product(word) % base == 0 && word.length < min) {
        min = Math.min(min, word.length)
        ans = word
      }
    }
    ans
  }
  
  //  def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {
  //    def build(s: String): Array[Int] = {
  //      val arr = new Array[Int](26)
  //      s.foreach { c =>
  //        if (Character.isLetter(c)) arr(c.toLower - 'a') += 1
  //      }
  //      arr
  //    }
  //
  //    val arr = build(licensePlate)
  //    var min = Integer.MAX_VALUE
  //    var ans = ""
  //    words.foreach { word =>
  //      val find = build(word).zip(arr).forall { case (r0, r1) =>
  //        r0 >= r1
  //      }
  //      if (find && word.length < min) {
  //        ans = word
  //        min = Math.min(min, word.length)
  //      }
  //    }
  //    ans
  //  }
}