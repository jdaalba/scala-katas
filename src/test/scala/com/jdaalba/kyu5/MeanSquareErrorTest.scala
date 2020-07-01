package com.jdaalba.kyu5

import org.scalatest.{FlatSpec, Matchers}

class MeanSquareErrorTest extends FlatSpec with Matchers {
  val tests = List(
    (Array(1, 2, 3),       Array(4, 5, 6),         9.0),
    (Array(10, 20, 10, 2), Array(10, 25, 5, -2),  16.5),
    (Array(0, -1),         Array(-1, 0),           1.0)
  )
  tests.foreach {
    case (input1, input2, expected) =>
      s"solution(${input1.mkString(", ")}), (${input2.mkString(", ")})" should s"return $expected" in {
        MeanSquareError.solution(input1, input2) should be (expected)
      }
  }
}