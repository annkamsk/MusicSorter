package com.music.sort

import com.music.sort.shared.Note
import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent

object ScalaJSExample {

  def main(args: Array[String]): Unit = {
    val notes = List(new Note(43), new Note(11), new Note(10), new Note(12), new Note(5), new Note(3))
    init(notes)
    dom.document.getElementById("sortButton").addEventListener("click", (e: MouseEvent) => bubblesort(notes), useCapture = false)

  }

  def init(notes: List[Note]): Unit = {
    val row = dom.document.getElementById("row")
    for (note <- notes) {
      val col = dom.document.createElement("div")
      col.setAttribute("class", "column")
      val rec = dom.document.createElement("div")
      rec.setAttribute("class", "rectangle")
      rec.setAttribute("id", note.getId)
      col.appendChild(rec)
      row.appendChild(col)
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
    val tmp: String = n1.getId
    dom.document.getElementById(n1.getId).setAttribute("id", n2.getId)
    dom.document.getElementById(n2.getId).setAttribute("id", tmp)
  }
}
