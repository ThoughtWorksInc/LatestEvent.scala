ThisBuild / organization := "com.thoughtworks.binding"

ThisBuild / evictionErrorLevel := Level.Info

lazy val LatestEvent = project

publish / skip := true

enablePlugins(ScalaUnidocPlugin)
