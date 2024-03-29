# LatestEvent.scala

[![Latest version](https://index.scala-lang.org/ThoughtWorksinc/LatestEvent.scala/latest.svg)](https://index.scala-lang.org/ThoughtWorksinc/LatestEvent.scala)
[![Scaladoc](https://javadoc.io/badge/com.thoughtworks.binding/latestevent_sjs1_3.svg?label=scaladoc)](https://javadoc.io/page/com.thoughtworks.binding/latestevent_sjs1_3/latest/com/thoughtworks/binding/LatestEvent.html)
[![Scala CI](https://github.com/ThoughtWorksInc/LatestEvent.scala/actions/workflows/scala.yml/badge.svg)](https://github.com/ThoughtWorksInc/LatestEvent.scala/actions/workflows/scala.yml)

**LatestEvent.scala** is a library to track the latest events from HTML DOM objects and other event targets. It can be used with [Binding.scala](https://github.com/ThoughtWorksInc/Binding.scala) and [html.scala](https://github.com/Atry/html.scala/) for bidirectional data-binding and routing.

## Getting Started

``` scala
def rootView = {
  val inputBinding = html"<input>"
  val value = Binding {
    val input = inputBinding.bind

    // Automatically recaculate whenever `input` is changed
    LatestEvent.change(input).bind
    
    input.value
  }
  html"""<div>
    ${inputBinding.bind}
    Your input value is ${value.bind}
  </div>"""
}

@JSExport def main(): Unit = {
  render(document.body, rootView)
}
```

It can be also used as an alternative to a routing library. See the [todo app](https://github.com/ThoughtWorksInc/todo/commit/54921cd4e1e7acf0b119b8bcd75c1a5c3f755f67#diff-96b7940afd1d65c4c49f5b434c0c764a2f1ecb133b12537b7144a8a05531457eR40-R43) for example.

## Links

- [Binding.scala](https://github.com/ThoughtWorksInc/Binding.scala)
- [html.scala](https://github.com/Atry/html.scala)
- [The legacy Binding.scala's routing library](https://github.com/atry/route.scala)
