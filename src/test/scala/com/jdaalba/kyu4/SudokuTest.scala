package com.jdaalba.kyu4

import org.scalatest._

class SudokuTest extends FlatSpec with Matchers {
  
/*

        5 3 4 | 6 7 8 | 9 1 2
        6 7 2 | 1 9 5 | 3 4 8
        1 9 8 | 3 4 2 | 5 6 7
        ------+-------+------
        8 5 9 | 7 6 1 | 4 2 3
        4 2 6 | 8 5 3 | 7 9 1
        7 1 3 | 9 2 4 | 8 5 6
        ------+-------+------
        9 6 1 | 5 3 7 | 2 8 4
        2 8 7 | 4 1 9 | 6 3 5
        3 4 5 | 2 8 6 | 1 7 9

 */

  private val validBoard = Array(
    Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
    Array(6, 7, 2, 1, 9, 5, 3, 4, 8),
    Array(1, 9, 8, 3, 4, 2, 5, 6, 7),
    Array(8, 5, 9, 7, 6, 1, 4, 2, 3),
    Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
    Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
    Array(9, 6, 1, 5, 3, 7, 2, 8, 4),
    Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
    Array(3, 4, 5, 2, 8, 6, 1, 7, 9)
  )
  s"${validBoard.map(_.mkString(" ")).mkString("\n")}" should s"be valid" in {
    Sudoku.isValid(validBoard) should be(true)
  }

  private val invalidBoard = Array(
    Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
    Array(6, 7, 2, 1, 9, 0, 3, 4, 9),
    Array(1, 0, 0, 3, 4, 2, 5, 6, 0),
    Array(8, 5, 9, 7, 6, 1, 0, 2, 0),
    Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
    Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
    Array(9, 0, 1, 5, 3, 7, 2, 1, 4),
    Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
    Array(3, 0, 0, 4, 8, 1, 1, 7, 9)
  )
  s"${invalidBoard.map(_.mkString(" ")).mkString("\n")}" should s"be invalid" in {
    Sudoku.isValid(invalidBoard) should be(false)
  }

  "First invalid" should "is invalid" in {
    val testCase = Array(
      Array(4, 9, 8, 2, 6, 1, 3, 7, 5),
      Array(7, 5, 6, 3, 8, 4, 2, 1, 9),
      Array(6, 4, 3, 1, 5, 8, 7, 9, 2),
      Array(5, 2, 1, 7, 9, 3, 8, 4, 6),
      Array(9, 8, 7, 4, 2, 6, 5, 3, 1),
      Array(2, 1, 4, 9, 3, 5, 6, 8, 7),
      Array(3, 6, 5, 8, 1, 7, 9, 2, 4),
      Array(8, 7, 9, 6, 4, 2, 1, 3, 5)
    )

    Sudoku.isValid(testCase) should be(false)
  }

  "Second invalid" should "is invalid" in {
    val testCase = Array(
      Array(2, 3, 4, 5, 6, 7, 8, 9, 1),
      Array(3, 4, 5, 6, 7, 8, 9, 1, 2),
      Array(4, 5, 6, 7, 8, 9, 1, 2, 3),
      Array(5, 6, 7, 8, 9, 1, 2, 3, 4),
      Array(6, 7, 8, 9, 1, 2, 3, 4, 5),
      Array(7, 8, 9, 1, 2, 3, 4, 5, 6),
      Array(8, 9, 1, 2, 3, 4, 5, 6, 7),
      Array(9, 1, 2, 3, 4, 5, 6, 7, 8)
    )

    Sudoku.isValid(testCase) should be(false)
  }

  "Third invalid" should "is invalid" in {
    val testCase = Array(
      Array(1, 3, 2, 5, 7, 9, 4, 6, 8),
      Array(4, 9, 8, 2, 6, 1, 3, 7, 5),
      Array(7, 5, 6, 3, 8, 4, 2, 1, 9),
      Array(6, 4, 3, 1, 5, 8, 7, 9, 2),
      Array(5, 2, 1, 7, 9, 3, 8, 4, 6),
      Array(9, 8, 7, 4, 2, 6, 5, 3, 1),
      Array(2, 1, 4, 9, 3, 5, 6, 8, 7),
      Array(3, 6, 5, 8, 1, 7, 9, 2, 4),
      Array(8, 7, 9, 6, 4, 2, 1, 3, 5)
    )

    Sudoku.isValid(testCase) should be(false)
  }

  "Fourth invalid" should "is invalid" in {
    val testCase = Array(
      Array(1, 2, 3, 4, 5, 6, 7, 8, 9),
      Array(2, 3, 4, 5, 6, 7, 8, 9, 1),
      Array(3, 4, 5, 6, 7, 8, 9, 1, 2),
      Array(4, 5, 6, 7, 8, 9, 1, 2, 3),
      Array(5, 6, 7, 8, 9, 1, 2, 3, 4),
      Array(6, 7, 8, 9, 1, 2, 3, 4, 5),
      Array(7, 8, 9, 1, 2, 3, 4, 5, 6),
      Array(8, 9, 1, 2, 3, 4, 5, 6, 7),
      Array(9, 1, 2, 3, 4, 5, 6, 7, 8)
    )

    Sudoku.isValid(testCase) should be(false)
  }
}