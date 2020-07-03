package com.jdaalba.kyu5

import org.scalatest.FlatSpec

class TrailingZerosTest extends FlatSpec {
  it should "work with example tests" in {
    assert(TrailingZeros.zeros(0) == 0)
    assert(TrailingZeros.zeros(6) == 1)
    assert(TrailingZeros.zeros(14) == 2)
  }
}