package category.string._600_700

/**
  * 678. Valid Parenthesis String
  */
object _678_ValidParenthesisStr {
  def checkValidString(s: String): Boolean = {
    if (s.isEmpty) return true
    var lo, hi = 0
    var i = 0
    var earlyStop = false
    while (i < s.length && !earlyStop) {
      val incr0 = if (s(i) == '(') 1 else -1
      val incr1 = if (s(i) == ')') -1 else 1
      lo += incr0
      hi += incr1
      if (hi < 0) earlyStop = true
      if(!earlyStop) lo = Math.max(lo, 0)
      i += 1
    }
    lo == 0
  }
  
  def check(s: String): Boolean = {
    val stack = new java.util.Stack[Char]()
    s.foreach {
      case ')' =>
        if (stack.isEmpty || stack.peek() != '(') return false
        stack.pop()
      case c@_ =>
        stack.push(c)
    }
    stack.isEmpty
  }
  
  def checkValidStringV1(s: String): Boolean = {
    if (s.isEmpty) return true
    val idx = s.indexOf('*')
    if (idx == -1) return check(s)
    val part0 = s.substring(0, idx)
    val part1 = s.substring(idx + 1)
    if (checkValidString(part0 + part1)) return true
    if (checkValidString(part0 + '(' + part1)) return true
    if (checkValidString(part0 + ')' + part1)) return true
    false
  }
}