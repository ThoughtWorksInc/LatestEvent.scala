ThisBuild / organization := "com.thoughtworks.binding"

name := "LatestEvent"

enablePlugins(ScalaJSPlugin)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.8"

libraryDependencies += "com.thoughtworks.binding" %%% "binding" % "11.9.0"
