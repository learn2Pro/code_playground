package week37

object ScrambleString {
  def isScramble(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) return false
    if (s1 == s2) return true
    if (s1.length == 2 && s1.sorted == s2.sorted) return true
    val len = s1.length
    Array.tabulate(len - 1)(loc => loc + 1).exists { idx =>
      (s1.substring(0, idx).sorted == s2.substring(0, idx).sorted &&
              s1.substring(idx, len).sorted == s2.substring(idx, len).sorted &&
              isScramble(s1.slice(0, idx), s2.slice(0, idx)) &&
              isScramble(s1.slice(idx, len), s2.slice(idx, len))) ||
              (s1.substring(0, idx).sorted == s2.substring(len - idx, len).sorted &&
                      s1.substring(idx, len).sorted == s2.substring(0, len - idx).sorted &&
                      isScramble(s1.slice(0, idx), s2.slice(len - idx, len)) &&
                      isScramble(s1.slice(idx, len), s2.slice(0, len - idx)))
    }
  }
}