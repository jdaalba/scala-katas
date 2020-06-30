package com.jdaalba.kyu4

object Sudoku {

  private val range = Range(0, 3)

  def isValid(board: Array[Array[Int]]): Boolean = {

    val rowValidation = board.count(totalIs45) == 9

    val columnValidation = board.transpose.count(totalIs45) == 9

    rowValidation && columnValidation && validateSquares(board)
  }

  private def validateSquares(board: Array[Array[Int]]) = range.flatMap(x => range.map(y => (x, y)))
    .map(tuple => range.flatMap(x => range.map(y => (x + 3 * tuple._1, y + 3 * tuple._2)))
      .map(t => board(t._1)(t._2))
      .toArray
    ).forall(totalIs45)

  private def totalIs45(numbers: Array[Int]) = numbers
    .filter(_ >= 1)
    .filter(_ <= 9)
    .distinct
    .sum == 45

  val xs: Set[Int] = (1 to 9).toSet

  def isValid2(board: Array[Array[Int]]): Boolean = {
    board.forall(_.toSet == xs) &&
      board.transpose.forall(_.toSet == xs) &&
      board.grouped(3).forall {
        _.transpose.grouped(3).forall(_.flatten.toSet == xs)
      }
  }
}
