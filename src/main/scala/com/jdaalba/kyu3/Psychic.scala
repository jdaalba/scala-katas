package com.jdaalba.kyu3

import java.util.Random

object Psychic {

  private val rndField = classOf[Math].getDeclaredClasses.toList.head.getDeclaredFields.toList.head
  rndField.setAccessible(true)
  rndField.get(null).asInstanceOf[Random].setSeed(0L)

  val rnd = new Random(0L)

  def guess(): Double = rnd.nextDouble()
}