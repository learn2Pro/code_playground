package category.string._300_400

/**
  * 345. Reverse Vowels of a String
  */
object _354_ReverseVowelsOfAStr {
  val VOWELS = Set('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U')
  
  def reverseVowels(s: String): String = {
    if (s == null || s.isEmpty) return s
    var l = 0
    var r = s.length - 1
    val chars = s.toCharArray
    
    def swap(i: Int, j: Int, chars: Array[Char]): Unit = {
      val tmp = chars(i)
      chars(i) = chars(j)
      chars(j) = tmp
    }
    
    while (l < r) {
      if (VOWELS.contains(chars(l)) && VOWELS.contains(chars(r))) {
        swap(l, r, chars)
        l += 1
        r -= 1
      } else if (VOWELS.contains(chars(r)) && !VOWELS.contains(chars(l))) {
        l += 1
      } else if (VOWELS.contains(chars(l)) && !VOWELS.contains(chars(r))) {
        r -= 1
      } else {
        l += 1
        r -= 1
      }
    }
    new String(chars)
  }
}