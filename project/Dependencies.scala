import sbt._

object Dependencies {

  val quartzVer = "1.8.0"
  val logbackVer = "1.0.13"
  val scalazVer = "7.0.4"
  val jodatimeVer = "2.1"
  val scalatestVer = "2.1.0"
  val scalacheckVer = "1.11.0"

  val dependencies = Seq(
    "org.quartz-scheduler"  %   "quartz"            % quartzVer,
    "ch.qos.logback"        %   "logback-classic"   % logbackVer,
    "org.scalaz"            %%  "scalaz-core"       % scalazVer,
    "joda-time"             %   "joda-time"         % jodatimeVer,
    "org.scalatest"         %%  "scalatest"         % scalatestVer   % "test",
    "org.scalacheck"        %%  "scalacheck"        % scalacheckVer  % "test"
  ) map (_.exclude("org.slf4j", "slf4j-log4j12"))

}