package com.meetup.sugar.sbt

import org.scalatest._

class AdderSpec extends WordSpec with Matchers {

  "An Adder" when {
    "adding n and -n" should {
      "retun 0" in {
        val n = 10
        Adder.add(n, -n) shouldBe 0
      }
    }
    "adding n and 0" should {
      "return n" in {
        val n = 20
        Adder.add(n, 0) shouldBe n
      }
    }
    "adding 40 and 60" should {
      "return 100" in {
        Adder.add(40, 60) shouldBe 100
      }
    }
  }
}

