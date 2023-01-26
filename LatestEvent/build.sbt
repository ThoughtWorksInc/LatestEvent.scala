enablePlugins(ScalaJSPlugin)

import Ordering.Implicits._

libraryDependencies += {
  if (VersionNumber(scalaJSVersion).numbers >= Seq(1L)) {
    "org.scala-js" %%% "scalajs-dom" % "2.3.0"
  } else {
    "org.scala-js" %%% "scalajs-dom" % "1.2.0"
  }
}

libraryDependencies += {
  if (VersionNumber(scalaVersion.value).numbers >= Seq(2L, 13L)) {
    "com.thoughtworks.binding" %%% "binding" % "12.1.0+119-a0371f70"
  } else {
    "com.thoughtworks.binding" %%% "binding" % "11.9.0"
  }
}
