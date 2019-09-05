package weekTest20

import org.scalatest.FunSuite
import week35.RotateImage
import week36.GroupAnagrams

/**
  * @author tang
  * @date 2019/08/03
  */
class LeetCodeExamTestWeek35 extends FunSuite {

  test("48. Rotate Image 1.0") {
    //    val input0 = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
    //    RotateImage.rotate(input0)
    //    assert(input0 == Array(Array(7, 4, 1), Array(8, 5, 2), Array(9, 6, 3)))
    val input1 = Array(Array(5, 1, 9, 11), Array(2, 4, 8, 10), Array(13, 3, 6, 7), Array(15, 14, 12, 16))
    RotateImage.rotate(input1)
    assert(input1 == Array(Array(15, 13, 2, 5), Array(14, 3, 4, 1), Array(12, 6, 8, 9), Array(16, 7, 10, 11)))
  }

  test("120. Triangle") {

  }

  test("49. Group Anagrams") {
        println(GroupAnagrams.groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat")))
    println(GroupAnagrams.groupAnagrams(Array("ray", "cod", "abe", "ned", "arc", "jar", "owl", "pop", "paw", "sky", "yup", "fed", "jul", "woo", "ado", "why", "ben", "mys", "den", "dem", "fat", "you", "eon", "sui", "oct", "asp", "ago", "lea", "sow", "hus", "fee", "yup", "eve", "red", "flo", "ids", "tic", "pup", "hag", "ito", "zoo")))
  }

}
