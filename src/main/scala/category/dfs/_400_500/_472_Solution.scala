package category.dfs._400_500

/**
  * 472. Concatenated Words
  */
object _472_Solution {
  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
    var ans: List[String] = Nil
    val set = new java.util.HashSet[String]
    val sorted = words.sortWith { case (s0, s1) => s0.length < s1.length }
    
    def iterate(word: String): Boolean = {
      if (set.isEmpty) return false
      val N = word.length
      val dp = new Array[Boolean](N + 1)
      dp(0) = true
      for (i <- 1 to N) {
        var j = 0
        var anyOne = false
        while (j < i && !anyOne) {
          if (dp(j) && set.contains(word.substring(j, i))) {
            dp(i) = true
            anyOne = true
          }
          j += 1
        }
      }
      dp(N)
    }
    
    for (s <- sorted) {
      if (iterate(s)) ans ::= s
      set.add(s)
    }
    ans
  }
  
  class Trie {
    var word    : String      = _
    var children: Array[Trie] = new Array[Trie](26)
  }
  
  object Trie {
    def build(root: Trie, word: String): Unit = {
      var current = root
      word.foreach { c =>
        if (current.children(c - 'a') == null) current.children(c - 'a') = new Trie
        current = current.children(c - 'a')
      }
      current.word = word
    }
  }
  
  //  def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
  //    val root = new Trie
  //    words.foreach(Trie.build(root, _))
  //
  //    def search(word: String, agg: Int): Int = {
  //      if (word.isEmpty) return agg
  //      val N = word.length
  //      var current = root
  //      for (i <- 0 until N) {
  //        val node = current.children(word(i) - 'a')
  //        if (node == null) return 0
  //        if (node.word != null) {
  //          val anyOne = search(word.substring(i + 1), agg + 1)
  //          if (anyOne > 1) return anyOne
  //        }
  //        current = node
  //      }
  //      0
  //    }
  //
  //    words.filter(search(_, 0) > 1).toList
  //  }
}