package category.string._300_400

/**
  * 383. Ransom Note
  */
object _383_RansomNote {
  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    if (ransomNote.isEmpty) return true
    if (magazine.isEmpty) return false
    val selection = new Array[Int](26)
    magazine.foreach(c => selection(c - 'a') += 1)
    ransomNote.foreach { c =>
      selection(c - 'a') -= 1
      if (selection(c - 'a') < 0) return false
    }
    true
  }
}