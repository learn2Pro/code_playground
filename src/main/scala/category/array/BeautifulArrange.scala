package category.array

/**
  * 667. Beautiful Arrangement II
  */
object BeautifulArrange {
  def constructArray(n: Int, k: Int): Array[Int] = {
    val arr = new Array[Int](n)
    /*[1,2,3,4,...,k] == 1*/
    for (i <- 0 until n - k - 1) {
      arr(i) = i + 1
    }
    /*[1,n,2,n-1,...,n/2,n/2+1] == n-1*/
    var idx = n - k - 1
    for (i <- 0 until k + 1) {
      if (i % 2 == 0) {
        arr(idx) = i / 2 + n - k
      } else {
        arr(idx) = n - i / 2
      }
      idx += 1
    }
    arr
  }
}