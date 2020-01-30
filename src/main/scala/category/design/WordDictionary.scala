package category.design

/**
  * 211. Add and Search Word - Data structure design
  *
  * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
  * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
  * ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
  * [[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
  */
class WordDictionary() {
  
  /** Initialize your data structure here. */
  var word    : String                = _
  var children: Array[WordDictionary] = new Array[WordDictionary](26)
  
  /** Inserts a word into the trie. */
  def addWord(word: String): Unit = {
    var curr = this
    word.foreach { c =>
      if (curr.children(c - 'a') == null) curr.children(c - 'a') = new WordDictionary
      curr = curr.children(c - 'a')
    }
    curr.word = word
  }
  
  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  def search(word: String): Boolean = {
    if (word.length == 1) {
      val c = word.head
      if (c == '.') return children.exists(dict => dict != null && dict.word != null)
      else return children(c - 'a') != null && children(c - 'a').word != null
    }
    val first = word.head
    if (first == '.') {
      children.filter(_ != null).exists(_.search(word.substring(1)))
    } else {
      children(first - 'a') != null && children(first - 'a').search(word.substring(1))
    }
  }
  
}