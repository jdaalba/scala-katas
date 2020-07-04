package com.jdaalba.kyu5

import org.scalatest.{FlatSpec, Matchers}

class MemoizedFibonacciTest extends FlatSpec with Matchers {
  "fib(70)" should "return 190392490709135" in {
    MemoizedFibonacci.fib(70).toString should be("190392490709135")
  }
  "fib(60)" should "return 1548008755920" in {
    MemoizedFibonacci.fib(60).toString should be("1548008755920")
  }
  "fib(50)" should "return 12586269025" in {
    MemoizedFibonacci.fib(50).toString should be("12586269025")
  }
}