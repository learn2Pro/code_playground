package category.hashtable._700_800

/**
  * 720. Longest Word in Dictionary
  */
object _720_LongestWordInDictionary {
  
  class Trie {
    var symbol  : String      = _
    val children: Array[Trie] = new Array[Trie](26)
  }
  
  def longestWord(words: Array[String]): String = {
    /*build Trie*/
    val root = new Trie
    words.foreach { word =>
      var current = root
      word.foreach { c =>
        if (current.children(c - 'a') == null) current.children(c - 'a') = new Trie
        current = current.children(c - 'a')
      }
      current.symbol = word
    }
    
    def cmp(s0: String, s1: String): Int = {
      if (s0.length != s1.length) {
        s0.length - s1.length
      } else {
        -s0.compareTo(s1)
      }
    }
    
    def find(input: String): Boolean = {
      var current = root
      input.foreach { c =>
        if (current.children(c - 'a').symbol == null) return false
        current = current.children(c - 'a')
      }
      true
    }
    
    var ans = ""
    words.foreach { word =>
      if (find(word) && cmp(word, ans) > 0) {
        ans = word
      }
    }
    ans
  }
  
  //  def longestWord(words: Array[String]): String = {
  //    val sorted = words.sorted(new Ordering[String] {
  //      override def compare(x: String, y: String): Int = {
  //        if (x.length != y.length) {
  //          x.length - y.length
  //        } else {
  //          -x.compareTo(y)
  //        }
  //      }
  //    })
  //
  //    val wordSet = words.toSet
  //    val N = words.length
  //    for (i <- Range(N - 1, -1, -1)) {
  //      val current = sorted(i)
  //      val inner = current.length
  //      val ans = Range(1, inner).forall { end =>
  //        wordSet.contains(current.substring(0, end))
  //      }
  //      if (ans) return current
  //    }
  //    ""
  //
  //  }
}