import Time._
import Dependencies._

name := "meetup-sbt"

version := "1.0"

timeSettings

libraryDependencies ++= dependencies

net.virtualvoid.sbt.graph.Plugin.graphSettings

