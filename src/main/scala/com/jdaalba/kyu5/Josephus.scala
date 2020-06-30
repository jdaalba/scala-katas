package com.jdaalba.kyu5

import scala.collection.mutable.ArrayBuffer

object Josephus {
  def josephusSurvivor(n: Int, k: Int): Int = {
    val items: ArrayBuffer[Int] = ArrayBuffer.from(Range.inclusive(1, n))
    val permutation = ArrayBuffer[Int]()
      var position = 0
      while (items.nonEmpty) {
        position = (position + k - 1) % items.size
        permutation.addOne(items.remove(position))
      }
      permutation.toArray.last
  }
}
