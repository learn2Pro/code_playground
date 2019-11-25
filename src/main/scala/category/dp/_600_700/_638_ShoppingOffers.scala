package category.dp._600_700


/**
  * 638. Shopping Offers
  */
object _638_ShoppingOffers {
  
  def shoppingOffers(price: List[Int], special: List[List[Int]], needs: List[Int]): Int = {
    
    def dot(l: List[Int], r: List[Int]): Int = {
      l.zip(r).map { case (n0, n1) => n0 * n1 }.sum
    }
    
    
    def backTrack(remains: List[Int]): Int = {
      var res = dot(remains, price)
      for (s <- special) {
        val zipped = s.zip(remains)
        var remainCost = 0
        var which = 0
        var stop = false
        while (which < zipped.length && !stop) {
          val offer = zipped(which)._1
          val need = zipped(which)._2
          remainCost += ((need - offer) * price(which))
          which += 1
          if (need < offer) stop = true
        }
        if (!stop) res = Math.min(res, s(which) + backTrack(zipped.map {
          case (offer, need) => need - offer
        }))
      }
      res
      
    }
    
    if (price.isEmpty) return 0
    backTrack(needs)
    
  }
}