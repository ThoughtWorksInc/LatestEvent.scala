enablePlugins(ScalaJSPlugin)

import Ordering.Implicits._

if (VersionNumber(scalaJSVersion).numbers >= Seq(1L)) {
  libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.0.0"
} else {
  libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.2.0"
}

libraryDependencies += {
  if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
    "com.thoughtworks.binding" %%% "binding" % "12.1.0"
  } else {
    "com.thoughtworks.binding" %%% "binding" % "11.9.0"
  }
}
