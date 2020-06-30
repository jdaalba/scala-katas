package com.jdaalba.kyu4

object Matrix {

  def determinant(matrix: Array[Array[Int]]): Int = matrix.length match {
    case 1 => matrix.head.head
    case _ => getOperators(matrix).map(tuple => tuple._1 * determinant(tuple._2)).sum
  }

  def getOperators(matrix: Array[Array[Int]]): Seq[(Int, Array[Array[Int]])] = {
    matrix.indices
      .map(index => {
        val sign = if (index % 2 == 0) 1 else -1
        val adjunct = matrix.slice(1, matrix.length)
          .map(row => row.indices
            .filterNot(index.equals)
            .map(row.apply)
            .toArray
          )
        val element = matrix.head(index)
        (sign * element, adjunct)
      })
  }
}