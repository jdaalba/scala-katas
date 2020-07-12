package com.jdaalba.kyu6

object MultiplicationTable {

  def multiplicationTable(size: Int): List[List[Int]] = List.tabulate(size, size)((x, y) => (x + 1) * (y + 1))

  //  def multiplicationTable(size: Int): List[List[Int]] = Range.inclusive(1, size)
  //    .map(num => Range.inclusive(1, size).map(_ * num))
  //    .map(_.toList)
  //    .toList
}
