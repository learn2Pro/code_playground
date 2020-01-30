package category.bsearch._400_500

import java.util

/**
  * 406. Queue Reconstruction by Height
  */
object _406_Solution {
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    if (people.isEmpty) return people
    val sorted = people.sorted(new Ordering[Array[Int]] {
      override def compare(x: Array[Int], y: Array[Int]): Int = if (x(0) == y(0)) y(1) - x(1) else x(0) - y(0)
    })
    val N = sorted.length
    val ans = new util.LinkedList[Array[Int]]()
    for (i <- 0 until N) {
      ans.add(sorted(i)(1), sorted(i))
    }
    import scala.collection.JavaConverters._
    ans.asScala.toArray
  }
  
  /**
    * class _237_Solution {
    * public int[][] reconstructQueue(int[][] people) {
    * LinkedList<int[]> list = new LinkedList<>();
    *         Arrays.sort(people,(a,b)->{
    * if(a[0]!=b[0])
    * return b[0]-a[0];
    * return a[1]-b[1];
    * });
    * for(int[] a:people)
    *             list.add(a[1],a);
    * int[][] res = new int[people.length][2];
    * int i=0;
    * for(int[] a: list) res[i++]=a;
    * return res;
    * }
    * }
    */
}