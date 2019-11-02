package category.timeline.week42


/**
  * 179. Largest Number
  */
object LargestNumber {
  
  import scala.annotation.tailrec
  import scala.collection.mutable.ArrayBuffer
  
  implicit val oderForRule: Ordering[String] = new Ordering[String] {
    override def compare(x: String, y: String): Int = {
      (x + y).compareTo(y + x)
    }
  }
  
  def largestNumber(nums: Array[Int]): String = {
    
    if (nums == null || nums.isEmpty) return ""
    if (nums.forall(_ == 0)) return "0"
    nums.map(_.toString).sorted(oderForRule).reduce((a0, a1) => a1 ++ a0)
  }
  
  
}