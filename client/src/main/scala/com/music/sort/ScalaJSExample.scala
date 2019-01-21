package com.music.sort

import com.music.sort.shared.{Note, Pitches, Scales}
import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent

object ScalaJSExample {
  def main(args: Array[String]): Unit = {
    val notes = List()
    SelectScales.init()
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
      rec.setAttribute("id", note.id)
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
    val tmp: String = n1.id
    dom.document.getElementById(n1.id).setAttribute("id", n2.id)
    dom.document.getElementById(n2.id).setAttribute("id", tmp)
  }
}
