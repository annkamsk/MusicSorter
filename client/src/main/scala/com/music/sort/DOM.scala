package com.music.sort

import com.music.sort.ScalaJSExample.collection
import com.music.sort.shared._
import org.scalajs.dom
import org.scalajs.dom.raw.{Element, HTMLElement, MouseEvent}

import scala.scalajs.js

class DOM {
  val sortButton: Element = getElement("sortButton")
  val generateButton: Element = getElement("generateButton")
  val selectAlgorithms = new Select(Sortable.algorithms, "algos")
  val stop: Element = getElement("stop")
  val selectScales = new Select(Scales.scales, "scales")
  val selectBases = new Select(Pitches.pitches, "bases")

  def initSort(f: () => Unit): Unit = sortButton.addEventListener("click", (e: MouseEvent) => f, useCapture = false)

  def getElement(id: String): Element = dom.document.getElementById(id)

  def swap(n1: Note, n2: Note): Boolean = {
    js.Dynamic.global.makeSound(n1.pitch.toString, n1.octave)
    val key1 = dom.document.getElementById(n1.id)
    val key2 = dom.document.getElementById(n2.id)
    key1.setAttribute("id", n2.id)
    js.Dynamic.global.makeSound(n2.pitch.toString, n2.octave)
    key2.setAttribute("id", n1.id)
    true
  }

  def createKeyboard(notes: NotesCollection): Unit = {
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

  def cleanKeyboard(notes: NotesCollection): Unit = {
    for (note <- collection) {
      val old = dom.document.getElementById(note.id)
      val parent = old.parentNode
      old.parentNode.removeChild(old)
      parent.parentNode.removeChild(parent)
    }
    js.Dynamic.global.clear()
  }


}
