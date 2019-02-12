package com.music.sort.shared

class NotesCollection(collection: Array[Note], swap: (Note, Note) => Boolean) extends Sortable with
  Iterable[Note] {
  def this(swap: (Note, Note) => Boolean) {
    this(Array(), swap)
  }

  def apply(): Unit = {
    sort(collection, swap)
  }

  override def iterator: Iterator[Note] = collection.iterator
}
