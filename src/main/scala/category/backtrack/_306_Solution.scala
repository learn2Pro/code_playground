package category.backtrack

/**
  * 306. Additive Number
  *
  * "112358"
  * "199100199"
  * "9999110000100001"
  * "9999110000100001"
  * "9999110000100001100001100001100001"
  * "99999999999999999999999"
  * "1023"
  * "1203"
  * "0123"
  * "123"
  * "199001200"
  * "101"
  * "011"
  * "0011"
  */
object _306_Solution {
  def isAdditiveNumber(num: String): Boolean = {
    
    def concate(s1: String, to: Int): String = {
      val sb = new StringBuilder
      for (i <- 0 until to) sb.append('0')
      sb.append(s1).toString()
    }
    
    def add(s1: String, s2: String): String = {
      val sb = new StringBuilder
      val (update, other) = if (s1.length < s2.length) {
        concate(s1, s2.length - s1.length) -> s2
      } else {
        concate(s2, s1.length - s2.length) -> s1
      }
      var carry = 0
      for (i <- Range(update.length - 1, -1, -1)) {
        val sum = update(i) - '0' + other(i) - '0' + carry
        sb.append(sum % 10)
        carry = sum / 10
      }
      if (carry != 0) sb.append(carry)
      sb.reverse.toString()
    }
    
    def backtrack(input: String, first: String, second: String): Boolean = {
      if (input.isEmpty) return true
      if (first.nonEmpty && second.nonEmpty) {
        val target = add(first, second)
        if (input.indexOf(target) != 0) return false
        backtrack(input.substring(target.length), second, target)
      } else if (first.isEmpty) {
        for (i <- 1 until input.length / 2 + 1) {
          val ans = backtrack(input.substring(i), input.substring(0, i), "")
          if (ans) return true
        }
        false
      } else {
        val max = input.length - first.length
        for (i <- 1 until Math.min(max, input.length / 2) + 1) {
          val second = input.substring(0, i)
          if (second=="0" || !second.startsWith("0")) {
            val ans = backtrack(input.substring(i), first, input.substring(0, i))
            if (ans) return true
          }
        }
        false
      }
    }
    
    backtrack(num, "", "")
  }
}