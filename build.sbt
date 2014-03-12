import Random._

val (s, b, t) = ("simple", "build", "tool")

name := s"$s-$b-$t"

version := "1.0"

val staticTime = settingKey[java.util.Date]("Setting for holding a Date")
val dynamicTime = taskKey[java.util.Date]("Task for generating Dates")

staticTime := new java.util.Date

dynamicTime := new java.util.Date

val printNextRandom = taskKey[Unit]("Prints a random number")

randomSettings

printNextRandom := println("Random: " + nextRandom.value)

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.0" % "test"

net.virtualvoid.sbt.graph.Plugin.graphSettings

