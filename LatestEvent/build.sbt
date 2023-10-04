enablePlugins(ScalaJSPlugin)

import Ordering.Implicits._

libraryDependencies += {
  if (VersionNumber(scalaJSVersion).numbers >= Seq(1L)) {
    "org.scala-js" %%% "scalajs-dom" % "2.8.0"
  } else {
    "org.scala-js" %%% "scalajs-dom" % "1.2.0"
  }
}

libraryDependencies += {
  if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
    "com.thoughtworks.binding" %%% "binding" % "12.2.0"
  } else {
    "com.thoughtworks.binding" %%% "binding" % "11.9.0"
  }
}
