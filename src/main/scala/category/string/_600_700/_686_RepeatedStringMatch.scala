package category.string._600_700



/**
  * 686. Repeated String Match
  */
object _686_RepeatedStringMatch {
  import scala.collection.mutable.ArrayBuffer
  def repeatedStringMatch(A: String, B: String): Int = {
    
    val N = A.length
    val M = B.length
    var loc = 0
    val kmp = new ArrayBuffer[Int]()
    
    def buildKMP(): Unit = {
      for (i <- A.indices if A(i) == B(0)) kmp += i
      kmp += N
    }
    
    buildKMP()
    if (kmp.isEmpty) return -1
    var ai = kmp(loc)
    var bi = 0
    while (ai < N) {
      while (bi < M && A(ai % N) == B(bi)) {
        ai += 1
        bi += 1
      }
      if (bi == M) return Math.ceil(1.0 * ai / N).toInt
      else {
        loc += 1
        ai = kmp(loc)
        bi = 0
      }
    }
    -1
  }
}