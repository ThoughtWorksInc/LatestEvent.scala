package com.thoughtworks.binding
import com.thoughtworks.binding.Binding.{ChangedEvent, ChangedListener}
import org.scalajs.dom.raw._

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * @author 杨博 (Yang Bo)
  */
class LatestEvent[E <: Event](eventTarget: EventTarget, eventType: String) extends Binding[Option[E]] {
  private var cache: Option[E] = None
  private val publisher = new SafeBuffer[ChangedListener[Option[E]]]

  protected def removeChangedListener(listener: ChangedListener[Option[E]]): Unit = {
    publisher -= listener
    if (publisher.isEmpty) {
      eventTarget.removeEventListener(eventType, eventListener)
    }
  }

  private val eventListener: js.Function1[E, _] = { upstreamEvent: E =>
    cache = Some(upstreamEvent)
    val changedEvent = new ChangedEvent(this, cache)
    for (listener <- publisher) {
      listener.changed(changedEvent)
    }
  }

  protected def addChangedListener(listener: ChangedListener[Option[E]]): Unit = {
    if (publisher.isEmpty) {
      eventTarget.addEventListener(eventType, eventListener)
    }
    publisher += listener
  }

  protected def value: Option[E] = cache
}

object LatestEvent {
  def abort(eventTarget: EventTarget) = {
    new LatestEvent[Event](eventTarget, "abort")
  }
  def error(eventTarget: EventTarget) = {
    new LatestEvent[Event](eventTarget, "error")
  }
  def load(eventTarget: EventTarget) = {
    new LatestEvent[UIEvent](eventTarget, "load")
  }
  def loadend(eventTarget: EventTarget) = {
    new LatestEvent[ProgressEvent](eventTarget, "loadend")
  }
  def loadstart(eventTarget: EventTarget) = {
    new LatestEvent[ProgressEvent](eventTarget, "loadstart")
  }
  def progress(eventTarget: EventTarget) = {
    new LatestEvent[ProgressEvent](eventTarget, "progress")
  }
}
