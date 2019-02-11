package com.music.sort.shared

import scala.concurrent.Future

class NotesCollection(collection: Array[Note], swap: (Note, Note) => Unit) extends Sortable with
  Iterable[Note] {
  def this(swap: (Note, Note) => Unit) {
    this(Array(), swap)
  }

  def apply(): Unit = {
    sort(collection, swap)
  }

  override def iterator: Iterator[Note] = collection.iterator
}
