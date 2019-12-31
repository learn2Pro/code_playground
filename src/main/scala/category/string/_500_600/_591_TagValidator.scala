package category.string._500_600

/**
  * 591. Tag Validator
  */
object _591_TagValidator {
  
  trait Rule {
    def pass(input: String): Boolean
  }
  
  class TagNameLimit extends Rule {
    override def pass(input: String): Boolean = {
      val parsed = if (input(0) == '/') input.substring(1) else input
      parsed.forall(Character.isUpperCase) && parsed.length <= 9 && parsed.length >= 1
    }
  }
  
  class TagContentLimit extends Rule {
    override def pass(input: String): Boolean = input.forall(_ != '<')
  }
  
  val CDATA_PATTERN_0 = "<![CDATA["
  val CDATA_PATTERN_1 = "]]>"
  val CDATA_PATTERN_2 = "\032\\s+\032"
  val PREFIX          = "\031"
  
  
  def isValid(code: String): Boolean = {
    val tagName = new TagNameLimit
    val tagContent = new TagContentLimit
    import scala.annotation.tailrec
    @tailrec
    def handleCDATA(input: String, start: Int): (Boolean, String) = {
      val first = input.indexOf(CDATA_PATTERN_0, start)
      if (first == -1) return true -> input
      val second = input.indexOf(CDATA_PATTERN_1, first + CDATA_PATTERN_0.length)
      if (second == -1) return false -> input
      handleCDATA(input.substring(0, first) + "CD" + input.substring(second + CDATA_PATTERN_1.length), 0)
    }
    
    val (rs, replaced) = handleCDATA(code, 0)
    if (!rs || replaced.isEmpty) return false
    val stack = new java.util.Stack[String]()
    val N = replaced.length
    var i = 0
    
    def stackValidate(stack: java.util.Stack[String], rule: Rule, tag: String): (Boolean, String) = {
      var sub = ""
      while (!stack.isEmpty && stack.peek() != tag && !stack.peek().startsWith(PREFIX)) sub = stack.pop() + sub
      if (stack.isEmpty) return false -> sub
      if (stack.peek() == tag) {
        stack.pop()
        if (!tag.startsWith(PREFIX) && sub.isEmpty) return false -> sub
      } else if (tag == "<") {
        sub = ""
      } else {
        return false -> sub
      }
      if (sub.nonEmpty && !rule.pass(sub)) return false -> sub
      true -> sub
    }
    
    while (i < N) {
      replaced(i) match {
        case '>' =>
          val (ans, sub) = stackValidate(stack, tagName, "<")
          if (!ans) return false
          if (sub.nonEmpty && sub.head != '/') stack.push(PREFIX + sub)
          else if (sub.nonEmpty) {
            val (ans, _) = stackValidate(stack, tagContent, PREFIX + sub.substring(1))
            if (!ans) return false
            if (i < N - 1 && stack.isEmpty) return false
          }
        case r@_ =>
          stack.push(r.toString)
      }
      i += 1
    }
    stack.isEmpty
  }
}