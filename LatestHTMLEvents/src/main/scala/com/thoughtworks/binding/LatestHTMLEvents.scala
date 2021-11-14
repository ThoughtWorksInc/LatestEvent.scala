package com.thoughtworks.binding

import org.scalajs.dom.raw.EventTarget
import org.scalajs.dom.Event
import org.lrng.binding.html.NodeBinding.Interpolated.MountPointBuilder
import scala.scalajs.js
import org.scalajs.dom.Element
import org.lrng.binding.html.AttributeFactory
import com.thoughtworks.binding.bindable.Bindable

/** Including [[LatestHTMLEvents.of]], which automatically infers the event type based on the type class defined in
  * [[org.lrng.binding.html]]
  *
  * @example
  *   Given an HTML button element,
  *   {{{
  *   import org.lrng.binding.html, html.autoImports.xml.attributes
  *   import org.scalajs.dom.MouseEvent
  *   @html val myButton = <button>Click me!</button>
  *   }}}
  *
  *   when creating the latest click event binding with the help of [[LatestHTMLEvents.of]],
  *
  *   {{{
  *   val latestClickEvent = LatestHTMLEvents.of(myButton.value, attributes.onclick)
  *   }}}
  *
  *   the event type should be inferred as [[org.scalajs.dom.MouseEvent]],
  *
  *   {{{
  *   val _ = latestClickEvent: LatestEvent[MouseEvent]
  *   }}}
  *
  *   and the `MouseEvent` properties, like `clientX`, can be used in the derived [[Binding]]s
  *
  *   {{{
  *   def clientXBinding = Binding {
  *     val mouseEvent: Option[MouseEvent] = latestClickEvent.bind
  *     mouseEvent.map(_.clientX)
  *   }
  *   }}}
  */
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
