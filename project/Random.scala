import sbt._
import scala.util.{Random => sRandom}

object Random {
  val randomRange = settingKey[(Int, Int)]("Define min and max values for random number generation")
  val nextRandom = taskKey[Int]("Generate a random number in the range defined by randomRange setting")

  private val nextRandomTask = nextRandom  := {
    val range = randomRange.value
    val (min, max) = (range._1, range._2)
    min + sRandom.nextInt(max - min)
  }

  lazy val randomSettings = Seq(
    randomRange := (10, 100),
    nextRandomTask
  )

}