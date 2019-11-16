package category.array._700_800

/**
  * 825. Friends Of Appropriate Ages
  */
object _825_FriendsOfAppropriateAges {
  
  trait RequestRule {
    def notRequest(a: Int, b: Int): Boolean
  }
  
  class Rule0 extends RequestRule {
    override def notRequest(a: Int, b: Int): Boolean = b <= (a / 2 + 7)
  }
  
  class Rule1 extends RequestRule {
    override def notRequest(a: Int, b: Int): Boolean = b > a
  }
  
  class Rule2 extends RequestRule {
    override def notRequest(a: Int, b: Int): Boolean = b > 100 && a < 100
  }
  
  def numFriendRequests(ages: Array[Int]): Int = {
    val rules = Array(new Rule0, new Rule1, new Rule2)
    val count = new Array[Int](121)
    for (age <- ages) {
      count(age) += 1
    }
    var ans = 0
    for (i <- 1 to 120 if count(i) != 0) {
      for (j <- 1 to 120 if !rules.exists(_.notRequest(i, j)) && count(j) != 0) {
        ans += count(i) * count(j)
        if (i == j) ans -= count(i)
      }
    }
    ans
  }
  
  def numFriendRequestsV1(ages: Array[Int]) = {
    val sorted = ages.filter(age => age > 14).sorted
    var ans = 0
    
    def extractRelations(arr: Array[Int]) = arr.foldLeft((0, 0)) { case ((start, idx), num) =>
      var tmp = start
      while (tmp < idx && arr(tmp) <= num * 0.5 + 7) tmp += 1
      var same = idx - 1
      /*same age*/
      while (same >= tmp && arr(same) == num) {
        ans += 1
        same -= 1
      }
      ans += (idx - tmp)
      (tmp, idx + 1)
    }
    
    extractRelations(sorted)
    ans
  }
}