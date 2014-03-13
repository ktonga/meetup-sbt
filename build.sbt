
val (s, b, t) = ("simple", "build", "tool")

name := s"$s-$b-$t"

version := "1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.1.0" % "test"
