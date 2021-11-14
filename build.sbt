ThisBuild / organization := "com.thoughtworks.binding"

name := "LatestEvent"

enablePlugins(ScalaJSPlugin)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.2.0"

libraryDependencies += "com.thoughtworks.binding" %%% "binding" % {
  import Ordering.Implicits._
  if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
    "12.1.0"
  } else {
    "11.9.0"
  }
}