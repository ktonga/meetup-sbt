import sbt._
import sbt.Keys._
import net.virtualvoid.sbt.graph.Plugin._

object BuildSettings {
  val buildOrganization = "meetup.sugar"
  val buildVersion      = "1.6"
  val buildScalaVersion = "2.10.3"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := buildOrganization,
    version      := buildVersion,
    scalaVersion := buildScalaVersion
  ) ++ graphSettings
}

object Dependencies {

  // versions
  val quartzVer = "1.8.0"
  val logbackVer = "1.0.13"
  val scalazVer = "7.0.4"
  val jodatimeVer = "2.1"
  val scalatestVer = "2.1.0"
  val scalacheckVer = "1.11.0"

  // ModulesIDs
  val quartz      = "org.quartz-scheduler"  %   "quartz"            % quartzVer
  val logback     = "ch.qos.logback"        %   "logback-classic"   % logbackVer
  val scalaz      = "org.scalaz"            %%  "scalaz-core"       % scalazVer
  val jodatime    = "joda-time"             %   "joda-time"         % jodatimeVer
  val scalatest   = "org.scalatest"         %%  "scalatest"         % scalatestVer   % "test"
  val scalacheck  = "org.scalacheck"        %%  "scalacheck"        % scalacheckVer  % "test"

}

object MultiprojectBuild extends Build {
  import BuildSettings._
  import Dependencies._

  val commonDeps = Seq(logback, scalatest, scalacheck)
  val adderDeps = Seq(scalaz)
  val subtractorDeps = Seq(jodatime)

  lazy val simpleMath = Project(
    "simple-math",
    file("."),
    settings = buildSettings
  ) aggregate(mainApp, adder, subtractor)

  lazy val mainApp = Project(
    "main-app",
    file("sm-main-app"),
    settings = buildSettings ++ Seq(libraryDependencies ++= commonDeps)
  ) dependsOn(adder, subtractor)

  lazy val adder = Project(
    "adder",
    file("sm-adder"),
    settings = buildSettings ++ Seq(libraryDependencies ++= commonDeps ++ adderDeps)
  )

  lazy val subtractor = Project(
    "subtractor",
    file("sm-subtractor"),
    settings = buildSettings ++ Seq(libraryDependencies ++= commonDeps ++ subtractorDeps)
  )

}

