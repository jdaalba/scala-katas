package com.jdaalba.kyu4

import scala.collection.mutable.ArrayBuffer

object RangeExtraction {

//  def solution(nums: List[Int]): String = {
//    nums.foldLeft(List.empty[List[Int]]) {
//      case (Nil, x) => List(x)::Nil
//      case (xs::xxs, x) =>
//        if (xs.head == x-1) (x::xs)::xxs
//        else List(x)::xs::xxs
//    }.map {
//      case x::Nil => s"$x"
//      case x::y::Nil => s"$y,$x"
//      case x => s"${x.last}-${x.head}"
//    }.reverse.mkString(",")
//  }

  def solution(xs: List[Int]): String = {
    val bufferResult = ArrayBuffer[ArrayBuffer[Int]](ArrayBuffer[Int]())
    var currentValue: Int = 0
    for (index <- xs.indices) {
      val buffer = bufferResult.last
      val element = xs(index)
      if (index == 0 || element == buffer.last + 1) {
        buffer.addOne(element)
      } else {
        bufferResult.addOne(ArrayBuffer[Int](element))
        currentValue = element
      }
    }
    bufferResult.map(_.toList)
      .map(formatInterval)
      .mkString(",")
  }

  def formatInterval(sortedList: List[Int]): String = {
    sortedList.length match {
      case 0 => ""
      case 1 | 2 => sortedList mkString ","
      case _ => f"${sortedList.head}-${sortedList.last}"
    }
  }
}
