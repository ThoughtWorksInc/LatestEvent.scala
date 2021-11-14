enablePlugins(ScalaJSPlugin)

libraryDependencies += "org.lrng.binding" %%% "html" % "1.0.3"

import Ordering.Implicits._

publish / skip := VersionNumber(scalaBinaryVersion.value).numbers < Seq(2L, 12L)
