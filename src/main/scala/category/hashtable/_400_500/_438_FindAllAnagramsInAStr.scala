package category.hashtable._400_500

/**
  * 438. Find All Anagrams in a String
  */
object _438_FindAllAnagramsInAStr {
  def findAnagrams(s: String, p: String): List[Int] = {
    case class Win(input: String, N: Int) {
      val array   = new Array[Int](26)
      var pointer = 0
      for (i <- 0 until N) {
        array(input(i) - 'a') += 1
      }
      
      def slide(): Unit = {
        pointer += 1
        if (pointer + N <= input.length) {
          array(input(pointer - 1) - 'a') -= 1
          array(input(pointer + N - 1) - 'a') += 1
        }
      }
      
      def isAnagram(other: Array[Int]): Boolean = {
        var i = -1
        other.forall { num =>
          i += 1
          num == array(i)
        }
      }
      
      def isEnd(): Boolean = {
        pointer + N > input.length
      }
    }
    
    var ans: List[Int] = Nil
    if (s == null || s.isEmpty || p.length > s.length) return ans
    val w = Win(s, p.length)
    val other = new Array[Int](26)
    p.foreach(inner => other(inner - 'a') += 1)
    while (!w.isEnd()) {
      if (w.isAnagram(other)) ans ::= w.pointer
      w.slide()
    }
    ans
  }
}