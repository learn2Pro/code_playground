package category.dfs._300_400


/**
  * 332. Reconstruct Itinerary
  */
object _332_ReconstructItinerary {
  
  import java.util.PriorityQueue
  
  def findItinerary(tickets: List[List[String]]): List[String] = {
    val flights = new java.util.HashMap[String, PriorityQueue[String]]
    tickets.foreach { case _@List(from, to) =>
      val q = flights.getOrDefault(from, new PriorityQueue[String]())
      q.add(to)
      flights.put(from, q)
    }
    var ans: List[String] = Nil
    
    def dfs(departure: String): Unit = {
      val arrivals = flights.get(departure)
      while (arrivals != null && !arrivals.isEmpty) {
        dfs(arrivals.poll())
      }
      ans ::= departure
    }
    
    dfs("JFK")
    ans
  }
}