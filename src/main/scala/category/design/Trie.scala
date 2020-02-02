package category.design

/**
  * 208. Implement Trie (Prefix Tree)
  */
class Trie() {
  
  /** Initialize your data structure here. */
  var word    : String            = _
  var children: Array[Trie] = new Array[Trie](26)
  
  /** Inserts a word into the trie. */
  def insert(word: String): Unit = {
    var curr = this
    word.foreach { c =>
      if (curr.children(c - 'a') == null) curr.children(c - 'a') = new Trie
      curr = curr.children(c - 'a')
    }
    curr.word = word
  }
  
  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    var curr = this
    word.foreach { c =>
      curr = curr.children(c - 'a')
      if (curr == null) return false
    }
    curr.word != null
  }
  
  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    var curr = this
    prefix.foreach { c =>
      curr = curr.children(c - 'a')
      if (curr == null) return false
    }
    curr != null
  }
}