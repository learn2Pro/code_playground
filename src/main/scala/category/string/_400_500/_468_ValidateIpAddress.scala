package category.string._400_500

/**
  * 468. Validate IP Address
  */
object _468_ValidateIpAddress {
  
  trait Validator {
    def rules: Array[Rule]
    
    def ans: String
    
    def validate(splits: Array[String]): String = {
      val passed = splits.forall(split => rules.forall(_.pass(split)))
      if (passed) ans else "Neither"
    }
  }
  
  trait Rule {
    def pass(part: String): Boolean
  }
  
  class NoLeadingZeroRule extends Rule {
    override def pass(part: String): Boolean = if (part.length > 1 && part(0) == '0') false else true
  }
  
  case class LengthLimitRule(size: Int) extends Rule {
    override def pass(part: String): Boolean = part.length <= size
  }
  
  case class RangeLimitRule(start: Int, end: Int, radix: Int) extends Rule {
    override def pass(part: String): Boolean = {
      try {
        val num = Integer.parseInt(part, radix)
        !part.startsWith("-") && num <= end && num >= start
      } catch {
        case _: Exception =>
          false
      }
    }
  }
  
  class Ipv4Validator extends Validator {
    val rules: Array[Rule] = Array(new NoLeadingZeroRule, LengthLimitRule(3), RangeLimitRule(0, 255, 10))
    
    override def ans: String = "IPv4"
  }
  
  class Ipv6Validator extends Validator {
    val rules: Array[Rule] = Array(LengthLimitRule(4), RangeLimitRule(0, 65535, 16))
    
    override def ans: String = "IPv6"
  }
  
  def validIPAddress(IP: String): String = {
    val validators = Map(4 -> new Ipv4Validator, 8 -> new Ipv6Validator)
    val replacement = IP.replace(".", ":")
    val splits = replacement.split(":")
    if (replacement.startsWith(":") || replacement.endsWith(":")) return "Neither"
    if (splits.length != 4 && splits.length != 8) return "Neither"
    validators(splits.length).validate(splits)
  }
}