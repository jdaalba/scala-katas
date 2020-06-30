package com.jdaalba.kyu4

import org.scalatest.{FlatSpec, Matchers}

class MatrixTest extends FlatSpec with Matchers {

  val tests = List(
    (Array(Array(1)), 1, Some("Determinant of a 1 x 1 matrix yields the value of the one element.")),
    (Array(Array(666)), 666, Some("Determinant of a 1 x 1 matrix yields the value of the one element.")),
    (Array(Array(1, 3), Array(2, 5)), -1, Some("Should return 1 * 5 - 3 * 2, i.e., -1.")),
    (Array(Array(2, 5, 3), Array(1, -2, -1), Array(1, 3, 4)), -20, None),
    (Array(Array(1, 2, 3, 4), Array(5, 0, 2, 8), Array(3, 5, 6, 7), Array(2, 5, 3, 1)), 24, None)
  )

  tests.foreach {
    case (matrix, expected, message) =>
      val matrixStr = s"Array(${matrix.map(r => s"Array(${r.mkString(", ")})").mkString(", ")})"
      s"determinant($matrixStr)" should s"return $expected" in {
        message match {
          case Some(error) => withClue(message) { Matrix.determinant(matrix) should be (expected) }
          case None => Matrix.determinant(matrix) should be (expected)
        }
      }
  }
}
