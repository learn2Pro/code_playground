package category.timeline.week31

import scala.collection.mutable.ArrayBuffer


/**
  * @author tang
  * @date 2019/08/04
  */
object VowelSpellcheckerSolution {
  private val capitlRules: Array[TransRule] = Array(new CapitalizeTransRule)
  private val vowelRules: Array[TransRule] = Array(new VowelTransRule)

  def spellchecker(wordlist: Array[String], queries: Array[String]): Array[String] = {
    val ans = new ArrayBuffer[String](32)
    val lookup = wordlist.zipWithIndex.toMap
    queries.foreach { query =>
      //match
      if (lookup.contains(query)) {
        ans.append(wordlist(lookup(query)))
      }
      else {
        //capital match
        val capitalResults: ArrayBuffer[Int] = StateBuilder
          .build(query, capitlRules)
          .map(word => lookup.getOrElse(word, -1))
          .filter(_ != -1)
        if (capitalResults.nonEmpty) {
          ans.append(wordlist(capitalResults.min))
        } else {
          val vowelResults: ArrayBuffer[Int] = StateBuilder
            .build(query, vowelRules ++ capitlRules)
            .map(word => lookup.getOrElse(word, -1))
            .filter(_ != -1)
          //vowel match
          if (vowelResults.nonEmpty) {
            ans.append(wordlist(vowelResults.min))
          } else {
            ans.append("")
          }
        }
      }
    }
    ans.toArray
  }
}

object StateBuilder {
  def build(word: String, rules: Array[TransRule]): ArrayBuffer[String] = {
    val root = CharState(null.asInstanceOf[Char])
    concateState(word, 0, root, rules)
    root.toWord()
  }

  def concateState(words: String, idx: Int, state: CharState, rules: Array[TransRule]): Unit = {
    val nextState = rules.flatMap(_.transform(words(idx))).distinct
    if (idx == words.length - 1) {
      state.next.appendAll(nextState)
    } else {
      state.next.appendAll(nextState)
      state.next.foreach { nextState =>
        concateState(words, idx + 1, nextState, rules)
      }
    }
  }
}

/**
  * 状态机转换
  *
  * @param c
  * @param next
  */
sealed case class CharState(c: Char, next: ArrayBuffer[CharState] = new ArrayBuffer[CharState]()) {
  def toWord(): ArrayBuffer[String] = {
    curr("", next)
  }

  def curr(s: String, next: ArrayBuffer[CharState]): ArrayBuffer[String] = {
    if (next.nonEmpty) {
      next.flatMap {
        child =>
          val str = s + child.c
          curr(str, child.next)
      }
    } else {
      ArrayBuffer(s)
    }
  }
}

trait TransRule {
  def transform(c: Char): ArrayBuffer[CharState]
}

class CapitalizeTransRule extends TransRule {
  override def transform(c: Char): ArrayBuffer[CharState] = {
    val upper = if (c.isUpper) c else c.toUpper
    val lower = if (c.isUpper) c.toLower else c
    ArrayBuffer(CharState(upper), CharState(lower))
  }
}

class VowelTransRule extends TransRule {
  val vowels: Set[Char] = Set('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U')

  override def transform(c: Char): ArrayBuffer[CharState] = {
    if (vowels.contains(c)) {
      val buffer = new ArrayBuffer[CharState]()
      vowels.foreach(c => buffer.append(CharState(c)))
      buffer
    } else {
      ArrayBuffer.empty[CharState]
    }
  }
}
