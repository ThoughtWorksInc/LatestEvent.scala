ThisBuild / organization := "com.thoughtworks.binding"

name := "LatestEvent"

enablePlugins(ScalaJSPlugin)

import Ordering.Implicits._

libraryDependencies += {
  if (VersionNumber(scalaJSVersion).numbers >= Seq(1L)) {
    "org.scala-js" %%% "scalajs-dom" % "2.0.0"
  } else {
    "org.scala-js" %%% "scalajs-dom" % "1.2.0"
  }
}

libraryDependencies += "com.thoughtworks.binding" %%% "binding" % {
  if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
    "12.1.0"
  } else {
    "11.9.0"
  }
}
