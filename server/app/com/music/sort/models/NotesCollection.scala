package com.music.sort.models

import com.music.sort.shared.{DoubleStop, Note}

class NotesCollection(notes: List[Note]) {

  def swap(d: DoubleStop): List[Note] = {
    def isRest(el: Note) = !el.equals(d.first) && !el.equals(d.second)

    if (!d.swappedFirst.equals(d.first))
      notes.span(p => isRest(p)) match {
        case (pre, el1 :: rest) => rest.span(r => isRest(r)) match {
          case (inter, el2 :: suf) => pre ::: (el1 :: inter) ::: (el1 :: suf)
          case _ => rest
        }
        case _ => notes
      }
    else notes
  }
}
