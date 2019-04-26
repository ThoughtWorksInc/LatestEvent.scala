ThisBuild / organization := "com.thoughtworks.binding"

name := "LatestEvent"

enablePlugins(ScalaJSPlugin)

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.7"

libraryDependencies += "com.thoughtworks.binding" %%% "binding" % "11.7.0"
