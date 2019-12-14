package category.dp._700_800




/**
  * 740. Delete and Earn
  */
object _740_DeleteAndEarn {
  
  /**
    * public int deleteAndEarn(int[] nums) {
    * int[] count = new int[10001];
    * for (int x: nums) count[x]++;
    * int avoid = 0, using = 0, prev = -1;
    *
    * for (int k = 0; k <= 10000; ++k) if (count[k] > 0) {
    * int m = Math.max(avoid, using);
    * if (k - 1 != prev) {
    * using = k * count[k] + m;
    * avoid = m;
    * } else {
    * using = k * count[k] + avoid;
    * avoid = m;
    * }
    * prev = k;
    * }
    * return Math.max(avoid, using);
    * }
    */
  import scala.collection.mutable
  def deleteAndEarn(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val container = new mutable.HashMap[Int, Int]()
    nums.foreach { num =>
      if (container.contains(num)) {
        container.put(num, container(num) + 1)
      } else {
        container.put(num, 1)
      }
    }
    val sorted = container.keys.toArray.sorted
    var avoid, using = 0
    var prev = -1
    for (i <- sorted.indices) {
      val m = Math.max(avoid, using)
      if (sorted(i) - 1 != prev) {
        using = sorted(i) * container(sorted(i)) + m
        avoid = m
      } else {
        using = sorted(i) * container(sorted(i)) + avoid
        avoid = m
      }
      prev = sorted(i)
    }
    Math.max(avoid, using)
  }
  
  import scala.collection.mutable
  
  def deleteAndEarnV1(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val container = new mutable.HashMap[Int, Int]()
    nums.foreach { num =>
      if (container.contains(num)) {
        container.put(num, container(num) + 1)
      } else {
        container.put(num, 1)
      }
    }
    val sorted = container.keys.toArray.sorted
    val N = sorted.length
    val dp = Array.tabulate(N, N)((_, _) => 0)
    for (i <- Range(N - 1, -1, -1)) {
      dp(i)(i) = sorted(i) * container(sorted(i))
      for (j <- i + 1 until N) {
        if (sorted(j) - 1 == sorted(j - 1)) {
          dp(i)(j) = Math.max(dp(i)(j), dp(i)(j - 1))
          if (j - 2 >= 0) {
            dp(i)(j) = Math.max(dp(i)(j), dp(i)(j - 2) + sorted(j) * container(sorted(j)))
          } else {
            dp(i)(j) = Math.max(dp(i)(j), sorted(j) * container(sorted(j)))
          }
        } else {
          dp(i)(j) = dp(i)(j - 1) + sorted(j) * container(sorted(j))
        }
      }
    }
    dp(0)(N - 1)
  }
}