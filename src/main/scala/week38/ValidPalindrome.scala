package week38

/**
  * 125. Valid Palindrome
  */
object ValidPalindrome {
  def isPalindrome(s: String): Boolean = {
    if (s == null || s.isEmpty) return true
    var isPalindrome = true
    var left = 0
    var right = s.length - 1
    val lowerStr = s.toLowerCase
    while (left < right && isPalindrome) {
      if (!isValidChar(lowerStr(left))) left += 1
      else if (!isValidChar(lowerStr(right))) right -= 1
      else if (lowerStr(left) != lowerStr(right)) {
        isPalindrome = false
      } else {
        left += 1
        right -= 1
      }
    }
    isPalindrome
  }
  
  def isValidChar(char: Char): Boolean = {
    (char >= '0' && char <= '9') || (char >= 'a' && char <= 'z')
  }
}