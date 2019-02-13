package com.music.sort

import com.music.sort.shared.{BubbleSort, Note, NotesBuilder, NotesCollection}
import org.scalajs.dom.raw.MouseEvent

import scala.scalajs.js

object ScalaJSExample {
  var collection: NotesCollection = new NotesCollection(compareAndSwap)
  var DOM: DOM = _

  def main(args: Array[String]): Unit = {
    DOM = new DOM()
    init()
    DOM.sortButton.addEventListener("click", (e: MouseEvent) => {
      collection.apply()
      js.Dynamic.global.play(0)
    },
      useCapture = false)
    DOM.generateButton.addEventListener("click", (e: MouseEvent) => init(),
      useCapture = false)

    DOM.stop.addEventListener("click", (e: MouseEvent) => js.Dynamic.global.clear(), useCapture = false)
  }

  def init(): Unit = {
    DOM.cleanKeyboard(collection)
    val notes = new NotesBuilder(DOM.selectBases.chosen, DOM.selectScales.chosen).getNotes
    collection = new NotesCollection(notes, compareAndSwap) with BubbleSort
    DOM.createKeyboard(collection)
  }

  def compareAndSwap(n1: Note, n2: Note): Boolean = if (n2 < n1) DOM.swap(n1, n2) else false

}
