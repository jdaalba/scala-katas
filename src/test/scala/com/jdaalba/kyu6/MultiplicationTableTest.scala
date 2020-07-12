package com.jdaalba.kyu6

import org.scalatest.FunSuite

class MultiplicationTableTest extends FunSuite {

  test("should work with example tests") {
    assert(MultiplicationTable.multiplicationTable(1) == List(List(1)))
    assert(MultiplicationTable.multiplicationTable(2) == List(List(1, 2), List(2, 4)))
    assert(MultiplicationTable.multiplicationTable(3) == List(List(1, 2, 3), List(2, 4, 6), List(3, 6, 9)))
  }
}
