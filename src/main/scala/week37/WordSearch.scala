/**
  * Alipay.com Inc.
  * Copyright (c) 2004-2019 All Rights Reserved.
  */
package week37

/**
  *
  * @author derong.tdr
  * @version WordSearch.scala, v 0.1 2019年09月13日 20:09 tang Exp $
  */
object WordSearch {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val row = board.length
    val col = board(0).length
    for (i <- 0 until row)
      for (j <- 0 until col) {
        val chooseAns = choose(word, 0, i, j, board)
        if (chooseAns) return true
      }
    false
  }


  private def choose(
    word: String, idx: Int, i: Int, j: Int,
    board: Array[Array[Char]]): Boolean = {
    if (idx == word.length) return true
    if (i < 0 || j < 0 || (i == board.length) || (j == board(0).length)) return false
    if (board(i)(j) != word(idx)) return false
    val temp = board(i)(j)
    board(i)(j) = '.'
    val ans = choose(word, idx + 1, i - 1, j, board) || choose(word, idx + 1, i, j - 1, board) || choose(word, idx + 1, i + 1, j, board) || choose(word, idx + 1, i, j + 1, board)
    board(i)(j) = temp
    ans
  }
}
