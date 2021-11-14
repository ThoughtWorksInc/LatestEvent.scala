ThisBuild / organization := "com.thoughtworks.binding"

ThisBuild / evictionErrorLevel := Level.Info

lazy val LatestEvent = project

lazy val LatestHTMLEvents = project.dependsOn(LatestEvent)

publish / skip := true

enablePlugins(ScalaUnidocPlugin)
