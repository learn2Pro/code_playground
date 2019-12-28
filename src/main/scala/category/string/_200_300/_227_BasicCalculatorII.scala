package category.string._200_300

/**
  * 227. Basic Calculator II
  */
object _227_BasicCalculatorII {
  
  trait Op {
    def eval(left: Long, right: Long): Long
  }
  
  class Plus extends Op {
    override def eval(left: Long, right: Long): Long = left + right
  }
  
  class Minus extends Op {
    override def eval(left: Long, right: Long): Long = left - right
  }
  
  class Multi extends Op {
    override def eval(left: Long, right: Long): Long = left * right
  }
  
  class Divide extends Op {
    override def eval(left: Long, right: Long): Long = left / right
  }
  
  val Ops = Map('+' -> new Plus, '-' -> new Minus, '*' -> new Multi, '/' -> new Divide)
  
  def calculate(s: String): Int = {
    if (s == null || s.isEmpty) return 0
    
    /*a+b-c or a*b/c*/
    def evalMulti(input: String): String = {
      val nums = input.split("[-|+|*|/]")
      if (nums.length == 1) return nums(0)
      var lastAns = Ops(input(nums(0).length)).eval(nums(0).trim.toLong, nums(1).trim.toLong)
      var location = nums(0).length + nums(1).length + 1
      for (i <- 2 until nums.length) {
        lastAns = Ops(input(location)).eval(lastAns, nums(i).trim.toLong)
        location += nums(i).length + 1
      }
      lastAns.toString
    }
    
    val subExp = s.split("[+|-]")
    var i = -1
    evalMulti(subExp.map { sub =>
      i += sub.length + 1
      val eval = if (sub.contains("*") | sub.contains("/")) evalMulti(sub)
                 else sub
      val symbol = if (i < s.length) s(i) else ""
      eval + symbol
    }.mkString("")).toInt
    
  }
}