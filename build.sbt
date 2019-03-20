ThisBuild / organization := "com.thoughtworks.binding"

name := "LatestEvent"

dynverSeparator in ThisBuild := "-"

enablePlugins(ScalaJSPlugin)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6"

libraryDependencies += "com.thoughtworks.binding" %%% "binding" % "11.6.0"
