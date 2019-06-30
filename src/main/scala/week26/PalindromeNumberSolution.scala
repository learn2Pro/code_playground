package week26

/**
  * @author tang
  * @date 2019/06/30
  */
object PalindromeNumberSolution {
  def isPalindrome(x: Int): Boolean = {
    if (x < 0 || (x % 10 == 0 && x != 0)) false
    else {
      var ans = 0
      var tmp = x
      while (tmp > ans) {
        ans = ans * 10 + tmp % 10
        tmp /= 10
      }
      ans == tmp || ans / 10 == tmp
    }
  }
}
