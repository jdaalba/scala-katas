package com.jdaalba.kyu5

object MatchingAndSubstituting {

  def change(s: String, prog: String, version: String): String = {
    val phoneHasRightFormat = "Phone: \\+1-(\\d{3}-){2}\\d{4}\\s".r.findFirstIn(s).isDefined
    val versionHasRightFormat = "Version: \\d+\\.\\d+\\s".r.findFirstIn(s).isDefined
    val isV2 = "Version: 2\\.0\\s".r.findFirstIn(s).isDefined
    (versionHasRightFormat, phoneHasRightFormat) match {
      case (true, true) => f"Program: $prog Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: ${if (isV2) "2.0" else version}"
      case _ => "ERROR: VERSION or PHONE"
    }
  }
}
