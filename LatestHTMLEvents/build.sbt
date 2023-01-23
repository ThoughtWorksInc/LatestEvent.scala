enablePlugins(ScalaJSBundlerPlugin)

enablePlugins(ScalaJSPlugin)

enablePlugins(Example)

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.15" % Test

libraryDependencies += "org.lrng.binding" %%% "html" % "1.0.3"

Test / requireJsDomEnv := true

import Ordering.Implicits._

publish / skip := VersionNumber(scalaBinaryVersion.value).numbers < Seq(2L, 12L)

// Enable macro annotations by setting scalac flags for Scala 2.13
scalacOptions ++= {
  import Ordering.Implicits._
  if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
    Seq("-Ymacro-annotations")
  } else {
    Nil
  }
}

// Enable macro annotations by adding compiler plugins for Scala 2.11 and 2.12
libraryDependencies ++= {
  import Ordering.Implicits._
  if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
    Nil
  } else {
    Seq(compilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full))
  }
}
