package category.twopointer

/**
  * 567. Permutation in String
  * test case
  * "ab"
  * "eidbaooo"
  * "ab"
  * "eidboaoo"
  * "abcd"
  * "abc"
  * "dinitrophenylhydrazine"
  * "acetylphenylhydrazine"
  */
object _567_Solution {
  def checkInclusion(s1: String, s2: String): Boolean = {
    if (s1.length > s2.length) return false
    val arr1 = new Array[Int](26)
    val slide = new Array[Int](26)
    s1.foreach(c => arr1(c - 'a') += 1)
    val N = s1.length
    for (i <- 0 until N) slide(s2(i) - 'a') += 1
    
    def check(input: Array[Int]): Boolean = {
      arr1.zip(input).forall { case (l, r) => l == r }
    }
    
    def move(i: Int): Unit = {
      slide(s2(i - N) - 'a') -= 1
      slide(s2(i) - 'a') += 1
    }
    
    for (p <- N until s2.length) {
      if (check(slide)) return true
      move(p)
    }
    
    check(slide)
  }
}