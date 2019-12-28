/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package category.string

import category.string._200_300._227_BasicCalculatorII
import category.string._300_400.{_344_ReverseString, _385_MiniParser}
import org.scalatest.FunSuite

/**
  *
  * @author derong.tdr
  * @version StringTest.scala, v 0.1 2019年12月23日 23:40 tang Exp $
  */
class StringCategoryTest extends FunSuite {
  
  test("227. Basic Calculator II") {
    assert(_227_BasicCalculatorII.calculate("0-0") == 0)
    assert(_227_BasicCalculatorII.calculate(" 3/2 ") == 1)
    assert(_227_BasicCalculatorII.calculate("3+2*2") == 7)
    assert(_227_BasicCalculatorII.calculate(" 3+5 / 2 ") == 5)
  }
  
  test("_344_ReverseString"){
    _344_ReverseString.reverseString(Array('1','2'))
//    assert()
  }
  
  test("_385_MiniParser"){
    println(_385_MiniParser.deserialize("[[],[[[[]],-4],[[[]],[0],[[]]]]]"))
    println(_385_MiniParser.deserialize("[123,456,[788,799,833],[[]],10,[]]"))
    println(_385_MiniParser.deserialize("[]"))
    println(_385_MiniParser.deserialize("[[]]"))
    println(_385_MiniParser.deserialize("324"))
    println(_385_MiniParser.deserialize("[123,[456,[789]]]"))
  }
}
