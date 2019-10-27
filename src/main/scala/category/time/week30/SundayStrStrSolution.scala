package category.time.week30

import java.util.{HashMap => JHashMap}

/**
  * kmp strstr()
  *
  * @author tang
  * @date 2019/07/27
  */
object SundayStrStrSolution {
  def strStr(haystack: String, needle: String): Int = {
    if (needle == null || needle.isEmpty) return 0
    if (haystack == null || haystack.isEmpty) return -1
    //build unique char set
    val unique = new JHashMap[Char, Int]()
    val len = needle.length
    needle.zipWithIndex.foreach {
      case (k, v) =>
        unique.put(k, len - v)
    }

    var pointer = 0
    while (pointer + len <= haystack.length) {
      var curr = 0
      while (curr < len && needle(curr) == haystack(pointer + curr)) curr += 1
      if (curr == len) return pointer
      if (pointer + len >= haystack.length) return -1
      //如果该字符没有在模式串中出现则直接跳过，即移动位数 = 匹配串长度 + 1
      if (!unique.containsKey(haystack(pointer + len))) {
        pointer += (len + 1)
      } else {
        pointer += unique.get(haystack(pointer + len))
      }
    }
    -1
  }


}
