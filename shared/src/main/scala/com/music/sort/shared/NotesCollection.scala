package com.music.sort.shared

class NotesCollection(collection: List[Note], swap: (Note, Note) => Unit) extends Sortable with Iterable[Note] {
  def this(swap: (Note, Note) => Unit) {
    this(List(), swap)
  }

  def apply(): Unit = {
    sort(collection, swap)
  }

  override def iterator: Iterator[Note] = collection.iterator
}
