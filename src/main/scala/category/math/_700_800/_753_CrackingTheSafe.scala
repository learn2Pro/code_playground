package category.math._700_800


/**
  * 753. Cracking the Safe
  *
  * @see https://leetcode.com/problems/cracking-the-safe/discuss/153039/DFS-with-Explanations
  */
object _753_CrackingTheSafe {
  
  import scala.collection.mutable
  
  val seen = new mutable.HashSet[String]
  val ans  = new mutable.StringBuilder()
  
  def crackSafe(n: Int, k: Int): String = {
    
    def dfs(node: String, k: Int): Unit = {
      for (x <- 0 until k) {
        val nei = node + x
        if (!seen.contains(nei)) {
          seen.add(nei)
          dfs(nei.substring(1), k)
          ans.append(x)
        }
      }
    }
    
    if (n == 1 && k == 1) return "0"
    val sb = new mutable.StringBuilder()
    for (_ <- 0 until n - 1) sb.append("0")
    dfs(sb.toString(), k)
    ans.append(sb.toString())
    ans.toString()
  }
}