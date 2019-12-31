package category.string._600_700



/**
  * 609. Find Duplicate File in System
  */
object _609_FindDupFileInSystem {
  import java.util.regex.Pattern
  import scala.collection.mutable.ArrayBuffer
  
  val NAME_CONTENT_PATTERN = "(\\w+\\.txt)\\((\\w+)\\)"
  val p                    = Pattern.compile(NAME_CONTENT_PATTERN)
  
  
  def findDuplicate(paths: Array[String]): List[List[String]] = {
    val dupHolder = new java.util.HashMap[String, ArrayBuffer[String]]()
    
    def extractFile(dir: String, file: String): Unit = {
      val m = p.matcher(file)
      m.find()
      val content = m.group(2)
      val path = dir + "/" + m.group(1)
      if (dupHolder.containsKey(content)) {
        dupHolder.get(content).append(path)
      } else {
        dupHolder.put(content, ArrayBuffer(path))
      }
    }
    
    paths.foreach { path =>
      val parts = path.split(" ")
      for (i <- 1 until parts.length) extractFile(parts(0), parts(i))
    }
    
    import scala.collection.JavaConverters._
    dupHolder.asScala.filter(_._2.length >= 2).map(_._2.toList).toList
    
  }
}