
name := "meetup-sbt"

version := "1.0"

libraryDependencies ++= Seq(
  "org.quartz-scheduler"  %   "quartz"            % "1.8.0",
  "ch.qos.logback"        %   "logback-classic"   % "1.0.13",
  "org.scalaz"            %%  "scalaz-core"       % "7.0.4",
  "joda-time"             %   "joda-time"         % "2.1",
  "org.scalatest"         %%  "scalatest"         % "2.1.0"   % "test",
  "org.scalacheck"        %%  "scalacheck"        % "1.11.0"  % "test"
)

net.virtualvoid.sbt.graph.Plugin.graphSettings

