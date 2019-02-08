package com.music.sort

import com.music.sort.shared.{BubbleSort, Note, NotesBuilder, NotesCollection}
import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLElement, MouseEvent}

import scala.scalajs.js

object ScalaJSExample {
  var collection: NotesCollection = new NotesCollection(swap)

  def main(args: Array[String]): Unit = {
    SelectAlgorithms.init()
    SelectScales.init()
    SelectBases.init()
    init()
    dom.document.getElementById("sortButton").addEventListener("click", (e: MouseEvent) => collection.apply(),
      useCapture = false)
    dom.document.getElementById("generateButton").addEventListener("click", (e: MouseEvent) => init(),
      useCapture = false)
  }

  def init(): Unit = {
    deleteOld()
    val notes = new NotesBuilder(SelectBases.chosen, SelectScales.chosen).getNotes
    collection = new NotesCollection(notes, swap) with BubbleSort
    val row = dom.document.getElementById("row")
    var color = true

    def getColor: String = {
      color = !color
      if (color) "black" else "#FFFFF0"
    }

    for (note <- notes) {
      val col = dom.document.createElement("div")
      col.setAttribute("class", "column")
      col.setAttribute("id", "col" + note.id)
      val rec = dom.document.createElement("div")
      rec.setAttribute("class", "rectangle")
      rec.asInstanceOf[HTMLElement].style.backgroundColor = getColor
      rec.setAttribute("id", note.id)
      col.appendChild(rec)
      row.appendChild(col)
    }
  }

  def deleteOld(): Unit = {
    for (note <- collection) {
      val old = dom.document.getElementById(note.id)
      val parent = old.parentNode
      old.parentNode.removeChild(old)
      parent.parentNode.removeChild(parent)
    }
  }


  def swap(n1: Note, n2: Note): Unit = {
    js.Dynamic.global.makeSound(n1.pitch.toString, n1.octave)
    js.Dynamic.global.makeSound(n2.pitch.toString, n2.octave)
    val tmp: String = n1.id
    dom.document.getElementById(n1.id).setAttribute("id", n2.id)
    dom.document.getElementById(n2.id).setAttribute("id", tmp)
  }
}
