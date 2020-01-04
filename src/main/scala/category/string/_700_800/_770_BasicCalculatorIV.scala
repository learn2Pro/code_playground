package category.string._700_800

import java.util.regex.Pattern

import scala.collection.mutable.ArrayBuffer

/**
  * 770. Basic Calculator IV
  */
object _770_BasicCalculatorIV {
  
  trait Expr {
    def eval(params: Map[String, String]): Expr
    
    def symbol: String
  }
  
  case class Variable(symbol: String) extends Expr {
    override def eval(params: Map[String, String]): Expr = if (params.contains(symbol)) Constant(params(symbol)) else this
  }
  
  case class Constant(symbol: String) extends Expr {
    override def eval(params: Map[String, String]): Expr = this
  }
  
  class LeftBracket extends Expr {
    override def eval(params: Map[String, String]): Expr = throw new UnsupportedOperationException("not support evaluate!")
    
    override def symbol: String = "("
  }
  
  trait BinaryExpr extends Expr {
    def left: Expr
    
    def right: Expr
    
    def operand: String
    
    override def symbol: String = left.symbol + operand + right.symbol
  }
  
  case class Subtract(left: Expr, right: Expr) extends BinaryExpr {
    def operand: String = "-"
    
    override def symbol: String = {
      if (right.isInstanceOf[Constant]) {
        left.symbol + "+" + (right.symbol.toInt * -1).toString
      } else {
        "-1*" + right.symbol + "+" + left.symbol
      }
    }
    
    override def eval(params: Map[String, String]): Expr = {
      val lv = left.eval(params)
      val rv = right.eval(params)
      (lv, rv) match {
        case (_@Constant(v0), _@Constant(v1)) =>
          Constant((v0.toInt - v1.toInt).toString)
        case (e0@Variable(v0), e1@Variable(v1)) =>
          if (v0 == v1) Constant("0") else Subtract(e0, e1)
        case (_@Subtract(v0@Constant(_), other), v1@Constant(_)) =>
          Subtract(Subtract(v0, v1).eval(params), other)
        case (_@Subtract(other, v0@Constant(_)), v1@Constant(_)) =>
          Subtract(other, Add(v0, v1).eval(params))
        case (_@Add(other, v0@Constant(_)), v1@Constant(_)) =>
          Subtract(Add(v0, v1).eval(params), other)
        case (_@Add(v0@Constant(_), other), v1@Constant(_)) =>
          Add(Subtract(v0, v1).eval(params), other)
        case (v0@Constant(_), _@Subtract(v1@Constant(_), other)) =>
          Add(Subtract(v0, v1).eval(params), other)
        case (v0@Constant(_), _@Subtract(other, v1@Constant(_))) =>
          Subtract(Add(v0, v1).eval(params), other)
        case (v0@Constant(_), _@Add(other, v1@Constant(_))) =>
          Subtract(Subtract(v0, v1).eval(params), other)
        case (v0@Constant(_), _@Add(v1@Constant(_), other)) =>
          Subtract(Subtract(v0, v1).eval(params), other)
        case (_@Add(v0@Constant(_), e1), _@Add(v1@Constant(_), e3)) =>
          Add(Subtract(v0, v1).eval(params), Subtract(e1, e3))
        case (_@Add(v0@Constant(_), e1), _@Add(e3, v1@Constant(_))) =>
          Add(Subtract(v0, v1).eval(params), Subtract(e1, e3))
        case (_@Add(e1, v0@Constant(_)), _@Add(v1@Constant(_), e3)) =>
          Add(Subtract(v0, v1).eval(params), Subtract(e1, e3))
        case (_@Add(e1, v0@Constant(_)), _@Add(e3, v1@Constant(_))) =>
          Add(Subtract(v0, v1).eval(params), Subtract(e1, e3))
        case (_@Subtract(v0@Constant(_), e1), _@Subtract(v1@Constant(_), e3)) =>
          Add(Subtract(v0, v1).eval(params), Subtract(e3, e1))
        case (_@Subtract(v0@Constant(_), e1), _@Subtract(e3, v1@Constant(_))) =>
          Subtract(Add(v0, v1).eval(params), Add(e1, e3))
        case (_@Subtract(e1, v0@Constant(_)), _@Subtract(v1@Constant(_), e3)) =>
          Subtract(Add(e1, e3), Add(v0, v1).eval(params))
        case (_@Subtract(e1, v0@Constant(_)), _@Subtract(e3, v1@Constant(_))) =>
          Add(Subtract(e1, e3), Add(v0, v1).eval(params))
        case (_@Add(v0@Constant(_), e1), _@Subtract(v1@Constant(_), e3)) =>
          Add(Subtract(v0, v1).eval(params), Add(e3, e1))
        case (_@Add(v0@Constant(_), e1), _@Subtract(e3, v1@Constant(_))) =>
          Add(Add(v0, v1).eval(params), Subtract(e1, e3))
        case (_@Add(e1, v0@Constant(_)), _@Subtract(v1@Constant(_), e3)) =>
          Add(Add(e1, e3), Subtract(v0, v1).eval(params))
        case (_@Add(e1, v0@Constant(_)), _@Subtract(e3, v1@Constant(_))) =>
          Add(Subtract(e1, e3), Add(v0, v1).eval(params))
        case (_@Subtract(v0@Constant(_), e1), _@Add(v1@Constant(_), e3)) =>
          Subtract(Subtract(v0, v1).eval(params), Add(e3, e1))
        case (_@Subtract(v0@Constant(_), e1), _@Add(e3, v1@Constant(_))) =>
          Subtract(Subtract(v0, v1).eval(params), Add(e1, e3))
        case (_@Subtract(e1, v0@Constant(_)), _@Add(v1@Constant(_), e3)) =>
          Subtract(Subtract(e1, e3), Add(v0, v1).eval(params))
        case (_@Subtract(e1, v0@Constant(_)), _@Add(e3, v1@Constant(_))) =>
          Subtract(Subtract(e1, e3), Add(v0, v1).eval(params))
        case (c0@Multi(_@Constant(v0), e0), c1@Multi(_@Constant(v1), e1)) =>
          val sub = v0.toInt - v1.toInt
          if (e0.symbol == e1.symbol) {
            if (sub == 0) Constant("0") else Multi(Constant(sub.toString), e0)
          } else {
            Subtract(c0, c1)
          }
        case (c0@Multi(_: Variable | _: BinaryExpr, _), c1@Multi(_@Constant(v1), e1)) =>
          if (c0.symbol == e1.symbol) {
            val sub = 1 - v1.toInt
            if (sub == 0) Constant("0") else Multi(Constant(sub.toString), e1)
          } else {
            Subtract(c0, c1)
          }
        case (c1@Multi(_@Constant(v1), e1), c0@Multi(_: Variable | _: BinaryExpr, _)) =>
          if (c0.symbol == e1.symbol) {
            val sub = v1.toInt - 1
            if (sub == 0) Constant("0") else Multi(Constant(sub.toString), e1)
          } else {
            Subtract(c1, c0)
          }
        case _ =>
          if (lv.symbol == rv.symbol) Constant("0")
          else Subtract(lv, rv)
      }
    }
  }
  
  case class Add(left: Expr, right: Expr) extends BinaryExpr {
    def operand: String = "+"
    
    override def eval(params: Map[String, String]): Expr = {
      val lv = left.eval(params)
      val rv = right.eval(params)
      (lv, rv) match {
        case (_@Constant(v0), _@Constant(v1)) =>
          Constant((v0.toInt + v1.toInt).toString)
        case (e0@Variable(v0), e1@Variable(v1)) =>
          if (v0 == v1) Constant("2*" + v0) else Add(e0, e1)
        case (_@Subtract(v0@Constant(_), other), v1@Constant(_)) =>
          Subtract(Add(v0, v1).eval(params), other)
        case (_@Subtract(other, v0@Constant(_)), v1@Constant(_)) =>
          Add(other, Subtract(v1, v0).eval(params))
        case (_@Add(other, v0@Constant(_)), v1@Constant(_)) =>
          Add(Add(v0, v1).eval(params), other)
        case (_@Add(v0@Constant(_), other), v1@Constant(_)) =>
          Add(Add(v0, v1).eval(params), other)
        case (v0@Constant(_), _@Subtract(v1@Constant(_), other)) =>
          Subtract(Add(v0, v1).eval(params), other)
        case (v0@Constant(_), _@Subtract(other, v1@Constant(_))) =>
          Add(Subtract(v0, v1).eval(params), other)
        case (v0@Constant(_), _@Add(other, v1@Constant(_))) =>
          Add(Add(v0, v1).eval(params), other)
        case (v0@Constant(_), _@Add(v1@Constant(_), other)) =>
          Add(Add(v0, v1).eval(params), other)
        case (_@Add(v0@Constant(_), e1), _@Add(v1@Constant(_), e3)) =>
          Add(Add(v0, v1).eval(params), Add(e1, e3))
        case (_@Add(v0@Constant(_), e1), _@Add(e3, v1@Constant(_))) =>
          Add(Add(v0, v1).eval(params), Add(e1, e3))
        case (_@Add(e1, v0@Constant(_)), _@Add(v1@Constant(_), e3)) =>
          Add(Add(v0, v1).eval(params), Add(e1, e3))
        case (_@Add(e1, v0@Constant(_)), _@Add(e3, v1@Constant(_))) =>
          Add(Add(v0, v1).eval(params), Add(e1, e3))
        case (_@Subtract(v0@Constant(_), e1), _@Subtract(v1@Constant(_), e3)) =>
          Subtract(Add(v0, v1).eval(params), Add(e3, e1))
        case (_@Subtract(v0@Constant(_), e1), _@Subtract(e3, v1@Constant(_))) =>
          Add(Subtract(v0, v1).eval(params), Subtract(e3, e1))
        case (_@Subtract(e1, v0@Constant(_)), _@Subtract(v1@Constant(_), e3)) =>
          Subtract(Add(e1, e3), Add(v0, v1).eval(params))
        case (_@Subtract(e1, v0@Constant(_)), _@Subtract(e3, v1@Constant(_))) =>
          Subtract(Add(e1, e3), Add(v0, v1).eval(params))
        case (_@Add(v0@Constant(_), e1), _@Subtract(v1@Constant(_), e3)) =>
          Add(Add(v0, v1).eval(params), Subtract(e1, e3))
        case (_@Add(v0@Constant(_), e1), _@Subtract(e3, v1@Constant(_))) =>
          Add(Subtract(v0, v1).eval(params), Add(e1, e3))
        case (_@Add(e1, v0@Constant(_)), _@Subtract(v1@Constant(_), e3)) =>
          Add(Subtract(e1, e3), Add(v0, v1).eval(params))
        case (_@Add(e1, v0@Constant(_)), _@Subtract(e3, v1@Constant(_))) =>
          Add(Add(e1, e3), Subtract(v0, v1).eval(params))
        case (_@Subtract(v0@Constant(_), e1), _@Add(v1@Constant(_), e3)) =>
          Add(Add(v0, v1).eval(params), Subtract(e3, e1))
        case (_@Subtract(v0@Constant(_), e1), _@Add(e3, v1@Constant(_))) =>
          Add(Add(v0, v1).eval(params), Subtract(e3, e1))
        case (_@Subtract(e1, v0@Constant(_)), _@Add(v1@Constant(_), e3)) =>
          Add(Add(e1, e3), Subtract(v1, v0).eval(params))
        case (_@Subtract(e1, v0@Constant(_)), _@Add(e3, v1@Constant(_))) =>
          Add(Add(e1, e3), Subtract(v1, v0).eval(params))
        case (c0@Multi(_@Constant(v0), e0), c1@Multi(_@Constant(v1), e1)) =>
          val sub = v0.toInt + v1.toInt
          if (e0.symbol == e1.symbol) {
            if (sub == 0) Constant("0") else Multi(Constant(sub.toString), e0)
          } else {
            Add(c0, c1)
          }
        case (c0@Multi(_: Variable | _: BinaryExpr, _), c1@Multi(_@Constant(v1), e1)) =>
          if (c0.symbol == e1.symbol) {
            val sub = 1 + v1.toInt
            if (sub == 0) Constant("0") else Multi(Constant(sub.toString), e1)
          } else {
            Add(c0, c1)
          }
        case (c1@Multi(_@Constant(v1), e1), c0@Multi(_: Variable | _: BinaryExpr, _)) =>
          if (c0.symbol == e1.symbol) {
            val sub = 1 + v1.toInt
            if (sub == 0) Constant("0") else Multi(Constant(sub.toString), e1)
          } else {
            Add(c0, c1)
          }
        case _ =>
          if (lv.symbol == rv.symbol) Multi(Constant("2"), lv)
          else Add(lv, rv)
      }
    }
  }
  
  case class Multi(left: Expr, right: Expr) extends BinaryExpr {
    def operand: String = "*"
    
    def sort(exprs: Array[Expr]): Expr = {
      exprs.sortBy(_.symbol).reduce(Multi)
    }
    
    override def eval(params: Map[String, String]): Expr = {
      val lv = left.eval(params)
      val rv = right.eval(params)
      (lv, rv) match {
        case (_@Constant(v0), _@Constant(v1)) =>
          Constant((v0.toInt * v1.toInt).toString)
        case (_@Subtract(e0, e1), v1@Constant(_)) =>
          Subtract(Multi(e0, v1), Multi(e1, v1))
        case (_@Add(e0, e1), v1@Constant(_)) =>
          Add(Multi(e0, v1), Multi(e1, v1))
        case (v1@Constant(_), _@Subtract(e0, e1)) =>
          Subtract(Multi(e0, v1), Multi(e1, v1))
        case (v1@Constant(_), _@Add(e0, e1)) =>
          Add(Multi(e0, v1), Multi(e1, v1))
        case (v1@Constant(_), _@Multi(e0, v0@Constant(_))) =>
          Multi(Multi(v0, v1), e0).eval(params)
        case (v1@Constant(_), _@Multi(v0@Constant(_), e0)) =>
          Multi(Multi(v0, v1), e0).eval(params)
        case (_@Multi(e0, v0@Constant(_)), v1@Constant(_)) =>
          Multi(Multi(v0, v1), e0).eval(params)
        case (_@Multi(v0@Constant(_), e0), v1@Constant(_)) =>
          Multi(Multi(v0, v1), e0).eval(params)
        case (_@Multi(e0, e1), v1@Constant(_)) =>
          Multi(v1, Multi(e0, e1))
        case (v0@Constant(_), _@Add(other, v1@Constant(_))) =>
          Add(Multi(v0, v1), Multi(v0, other))
        case (v0@Constant(_), _@Add(v1@Constant(_), other)) =>
          Add(Multi(v0, v1), Multi(v0, other)).eval(params)
        case (_@Add(v0@Constant(_), e1), _@Add(v1@Constant(_), e3)) =>
          Add(Add(sort(Array(e1, e3)), Multi(v1, e1)), Add(Multi(v0, e3), Multi(v0, v1))).eval(params)
        case (_@Subtract(e0, e1), _@Subtract(e2, e3)) =>
          Subtract(Add(sort(Array(e0, e2)), sort(Array(e1, e3))), Add(sort(Array(e1, e2)), sort(Array(e0, e3)))).eval(params)
        case (_@Add(e0, e1), _@Subtract(e2, e3)) =>
          Add(Subtract(sort(Array(e0, e2)), sort(Array(e1, e3))), Subtract(sort(Array(e1, e2)), sort(Array(e0, e3))))
                  .eval(params)
        case (_@Subtract(e0, e1), _@Add(e2, e3)) =>
          Subtract(Add(sort(Array(e0, e2)), sort(Array(e0, e3))), Add(sort(Array(e1, e2)), sort(Array(e1, e3)))).eval(params)
        case (_@Add(e0, e1), _@Multi(e2, e3)) =>
          Add(sort(Array(e0, e2, e3)), sort(Array(e1, e2, e3))).eval(params)
        case (_@Multi(e2, e3), _@Add(e0, e1)) =>
          Add(sort(Array(e0, e2, e3)), sort(Array(e1, e2, e3))).eval(params)
        case (_@Subtract(e0, e1), _@Multi(e2, e3)) =>
          Subtract(sort(Array(e0, e2, e3)), sort(Array(e1, e2, e3))).eval(params)
        case (_@Multi(e2, e3), _@Subtract(e0, e1)) =>
          Subtract(sort(Array(e0, e2, e3)), sort(Array(e1, e2, e3))).eval(params)
        case (_@Multi(e0, e1), _@Multi(e2, e3)) =>
          sort(Array(e0, e1, e2, e3)).eval(params)
        case (_@Multi(e0, e1), v0@Variable(_)) =>
          sort(Array(v0, e0, e1))
        case _ =>
          sort(Array(lv, rv))
      }
    }
  }
  
  
  trait Parser[T] {
    def parse(word: T): Expr
    
    protected def min(lo: Int, hi: Int): Int = {
      if (lo == -1) return hi
      if (hi == -1) return lo
      Math.min(hi, lo)
    }
  }
  
  case class Lexer(i: Int) extends Parser[String] {
    val NUM_PATTERN: Pattern = java.util.regex.Pattern.compile("[-]?\\d+$")
    var nextHop    : Int     = i + 1
    
    override def parse(word: String): Expr = {
      val partial = min(min(word.indexOf('*', i), word.indexOf('+', i)), min(word.indexOf(')', i), word.indexOf('-', i)))
      val end = if (partial == -1) word.length else partial
      val symbol = word.substring(i, end).trim
      nextHop = end
      if (NUM_PATTERN.matcher(symbol).find()) Constant(symbol) else Variable(symbol)
    }
  }
  
  class CombineExpr extends Parser[Seq[Expr]] {
    override def parse(exprs: Seq[Expr]): Expr = {
      secondOrder(firstOrder(exprs))
    }
    
    private def firstOrder(exprs: Seq[Expr]): Seq[Expr] = {
      val buffer = new ArrayBuffer[Expr]()
      var i = 0
      while (i < exprs.length) {
        exprs(i) match {
          case m@Multi(_, _) =>
            buffer += m.copy(buffer.remove(buffer.length - 1), exprs(i + 1))
            i += 2
          case n@_ =>
            buffer.append(n)
            i += 1
        }
      }
      buffer
    }
    
    private def secondOrder(exprs: Seq[Expr]): Expr = {
      var left = exprs.head
      for (i <- Range(1, exprs.length, 2)) {
        exprs(i) match {
          case a@Add(_, _) =>
            left = a.copy(left, exprs(i + 1))
          case s@Subtract(_, _) =>
            left = s.copy(left, exprs(i + 1))
        }
      }
      left
    }
  }
  
  
  def basicCalculatorIV(expression: String, evalvars: Array[String], evalints: Array[Int]): List[String] = {
    val params = evalvars.zip(evalints).map { case (k, v) => k -> v.toString }.toMap
    val N = expression.length
    
    def fromSymbol(s: String): Expr = {
      val combine = new CombineExpr
      val stack = new java.util.Stack[Expr]()
      var i = 0
      while (i < N) {
        if (expression(i) != ' ') {
          expression(i) match {
            case '+' =>
              stack.push(Add(null, null))
            case '-' =>
              stack.push(Subtract(null, null))
            case '*' =>
              stack.push(Multi(null, null))
            case '(' =>
              stack.push(new LeftBracket)
            case ')' =>
              val buffer = new ArrayBuffer[Expr]()
              while (!stack.empty() && !stack.peek().isInstanceOf[LeftBracket]) buffer.insert(0, stack.pop())
              if (stack.peek().isInstanceOf[LeftBracket]) stack.pop
              stack.push(combine.parse(buffer))
            case _ =>
              val lexer = Lexer(i)
              stack.push(lexer.parse(expression))
              i = lexer.nextHop - 1
          }
        }
        i += 1
      }
      import scala.collection.JavaConversions._
      combine.parse(stack)
    }
    
    val ans = fromSymbol(expression).eval(params)
    if (ans == Constant("0")) Nil else ans.symbol.split("[\\+]").toList
  }
}