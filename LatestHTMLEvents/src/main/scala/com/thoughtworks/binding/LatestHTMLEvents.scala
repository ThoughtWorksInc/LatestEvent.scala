package com.thoughtworks.binding

import org.scalajs.dom.raw.EventTarget
import org.scalajs.dom.Event
import org.lrng.binding.html.NodeBinding.Interpolated.MountPointBuilder
import scala.scalajs.js
import org.scalajs.dom.Element
import org.lrng.binding.html.AttributeFactory
import com.thoughtworks.binding.bindable.Bindable

object LatestHTMLEvents {

  def of[E <: org.scalajs.dom.Element, AttributeObject <: AttributeFactory.Typed, InferredEvent <: Event](
      target: E,
      attribute: AttributeObject
  )(implicit
      mountPointBuilder: MountPointBuilder[E, AttributeObject, js.Function1[InferredEvent, _]]
  ): LatestEvent[InferredEvent] = {
    val propertyName = attribute.getClass.getSimpleName
    if (propertyName.startsWith("on") && propertyName.endsWith("$")) {
      return new LatestEvent(target, propertyName.substring("on".length(), propertyName.length() - "$".length()))
    } else {
      throw new IllegalArgumentException(
        "attribute must be an object defined in [[org.lrng.binding.html.autoImports.xml.attributes]] whose name starts with \"on\""
      )
    }
  }
}
