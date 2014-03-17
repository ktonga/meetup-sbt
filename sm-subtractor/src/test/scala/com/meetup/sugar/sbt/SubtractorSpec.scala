package com.meetup.sugar.sbt

import org.scalatest._

class SubtractorSpec extends WordSpec with Matchers {

  "A Subtractor" when {
    "subtracting n and -n" should {
      "retun 2n" in {
        val n = 10
        Subtractor.subtract(n, -n) shouldBe 20
      }
    }
    "subtracting n and n" should {
      "return 0" in {
        val n = 20
        Subtractor.subtract(n, n) shouldBe 0
      }
    }
    "subtracting 100 and 60" should {
      "return 40" in {
        Subtractor.subtract(100, 60) shouldBe 40
      }
    }
  }
}

