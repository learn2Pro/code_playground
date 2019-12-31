package category.string._500_600

/**
  * 520. Detect Capital
  */
object _520_DetectCapital {
  
  trait Rule {
    def pass(s: String): Boolean
  }
  
  class AllCapital extends Rule {
    override def pass(s: String): Boolean = s.forall(Character.isUpperCase)
  }
  
  class AllNotCapital extends Rule {
    override def pass(s: String): Boolean = s.forall(Character.isLowerCase)
  }
  
  class FirstCapital extends Rule {
    override def pass(s: String): Boolean = Character.isUpperCase(s(0)) && s.substring(1).forall(Character.isLowerCase)
  }
  
  def detectCapitalUse(word: String): Boolean = {
    val rules = Array(new AllCapital, new AllNotCapital, new FirstCapital)
    rules.exists(_.pass(word))
  }
}