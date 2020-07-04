package com.jdaalba.kyu5

//import scala.collection.mutable

object MemoizedFibonacci {

  private val results = scala.collection.mutable.Map(0 -> BigInt(0), 1 -> BigInt(1))

  def fib(n: Int): BigInt = {
    results.get(n) match {
      case Some(num) => num
      case None => val result = fib(n - 1) + fib(n - 2)
        results.put(n, result)
        result
    }
  }
}