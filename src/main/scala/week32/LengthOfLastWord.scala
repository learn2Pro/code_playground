package week32

/**
  * Created by Administrator on 2019/8/11 0011.
  */
object LengthOfLastWord {
  def lengthOfLastWord(s: String): Int = {
    if (s == null || s.isEmpty) return 0
    val trim = s.trim
    trim.length - trim.lastIndexOf(' ') - 1
  }
}
