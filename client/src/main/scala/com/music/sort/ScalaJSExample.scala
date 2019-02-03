package com.music.sort

import com.music.sort.shared.Note
import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent

object ScalaJSExample {
  var notes: List[Note] = List()

  def main(args: Array[String]): Unit = {
    SelectScales.init()
    SelectBases.init()
    init()
    dom.document.getElementById("sortButton").addEventListener("click", (e: MouseEvent) => bubblesort(notes),
      useCapture = false)
    dom.document.getElementById("generateButton").addEventListener("click", (e: MouseEvent) => init(),
      useCapture = false)
  }

  def init(): Unit = {
    deleteOld()
    notes = new NotesBuilder(SelectBases.chosen, SelectScales.chosen).getNotes
    val row = dom.document.getElementById("row")
    for (note <- notes) {
      val col = dom.document.createElement("div")
      col.setAttribute("class", "column")
      col.setAttribute("id", "col" + note.id)
      val rec = dom.document.createElement("div")
      rec.setAttribute("class", "rectangle")
      rec.setAttribute("id", note.id)
      col.appendChild(rec)
      row.appendChild(col)
    }
  }

  def deleteOld(): Unit = {
    for (note <- notes) {
      val old = dom.document.getElementById(note.id)
      val parent = old.parentNode
      old.parentNode.removeChild(old)
      parent.parentNode.removeChild(parent)
    }
  }

  def bubblesort(list: List[Note]): List[Note] = {
    def sort(as: List[Note], bs: List[Note]): List[Note] =
      if (as.isEmpty) bs
      else bubble(as, Nil, bs)

    def bubble(as: List[Note], zs: List[Note], bs: List[Note]): List[Note] = as match {
      case h1 :: h2 :: t =>
        if (h2 < h1) {
          swap(h1, h2)
          bubble(h1 :: t, h2 :: zs, bs)
        }
        else {
          bubble(h2 :: t, h1 :: zs, bs)
        }
      case h1 :: Nil => sort(zs, h1 :: bs)
    }

    sort(list, Nil)
  }

  def swap(n1: Note, n2: Note): Unit = {
    val tmp: String = n1.id
    dom.document.getElementById(n1.id).setAttribute("id", n2.id)
    dom.document.getElementById(n2.id).setAttribute("id", tmp)
  }
}
