package com.jdaalba.kyu5

object MeanSquareError {

  def solution(a: Array[Int], b: Array[Int]): Double = a.zip(b)
    .map(tuple => tuple._1 - tuple._2)
    .map(e => e * e)
    .sum / a.length.toDouble
}