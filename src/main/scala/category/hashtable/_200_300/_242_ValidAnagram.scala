package category.hashtable._200_300

/**
  * 242. Valid Anagram
  */
object _242_ValidAnagram {
  def isAnagram(s: String, t: String): Boolean = {
    val counter = new Array[Int](26)
    s.foreach(c => counter(c - 'a') += 1)
    t.foreach(c => counter(c - 'a') -= 1)
    counter.forall(_ == 0)
  }
}