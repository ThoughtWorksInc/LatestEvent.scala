package com.thoughtworks.binding

import org.scalajs.dom._
import org.scalajs.dom.raw._

private[binding] object ScalaJsDomMissingTypes {
  type InputEvent <: UIEvent
  type MutationEvent <: Event
}
