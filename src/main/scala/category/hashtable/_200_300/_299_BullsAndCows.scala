package category.hashtable._200_300

/**
  * 299. Bulls and Cows
  */
object _299_BullsAndCows {
  def getHint(secret: String, guess: String): String = {
    val N = secret.length
    val count = new Array[Int](10)
    val location = new Array[Char](N)
    for (i <- 0 until N) {
      count(secret(i) - '0') += 1
      location(i) = secret(i)
    }
    var bull, cow = 0
    for (i <- 0 until N) {
      if (guess(i) == location(i)) {
        bull += 1
        count(guess(i) - '0') -= 1
      }
    }
    for (i <- 0 until N) {
      if (guess(i) != location(i) && count(guess(i) - '0') > 0) {
        cow += 1
        count(guess(i) - '0') -= 1
      }
    }
    s"${bull}A${cow}B"
  }
}