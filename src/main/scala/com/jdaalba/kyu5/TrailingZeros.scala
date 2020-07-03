package com.jdaalba.kyu5

object TrailingZeros {

  def zeros(n: Int): Int = {
    val maxPow = (math.log(n) / math.log(5)).toInt
    Range.inclusive(1, maxPow)
      .map(math.pow(5, _))
      .map(_.toInt)
      .map(n / _)
      .sum
  }
}