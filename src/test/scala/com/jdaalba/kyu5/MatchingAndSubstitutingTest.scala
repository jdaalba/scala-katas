package com.jdaalba.kyu5

import org.scalatest._
import org.scalatest.Assertions._
import MatchingAndSubstitutingTest._

class MatchingAndSubstitutingTest extends FlatSpec {
  it should "pass basic tests" in {
    val s1 = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha"
    dotest(s1, "Ladder", "1.1", "Program: Ladder Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 1.1")
    val s2 = "Program title: Balance\nAuthor: Dorries\nCorporation: Funny\nPhone: +1-503-555-0095\nDate: Tues July 19, 2014\nVersion: 6.7\nLevel: Release"
    dotest(s2, "Circular", "1.5", "Program: Circular Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 1.5")
    val s12 = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-009\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha"
    dotest(s12, "Ladder", "1.1", "ERROR: VERSION or PHONE")
    val s13 = "Program title: Balance\nAuthor: Dorries\nCorporation: Funny\nPhone: +1-503-555-0095\nDate: Tues July 19, 2014\nVersion: 2.0\nLevel: Release"
    dotest(s13, "Circular", "1.5", "Program: Circular Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 2.0")
    val s14 = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7.5\nLevel: Alpha"
    dotest(s14, "Ladder", "1.1", "ERROR: VERSION or PHONE")
  }
}

object MatchingAndSubstitutingTest {
  private def dotest(s: String, prog: String, version: String, expect: String): Unit = {
    val actual: String = MatchingAndSubstituting.change(s, prog, version)
    assertResult(expect) {
      actual
    }
  }
}
