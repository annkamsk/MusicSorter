package com.music.sort.shared

class NotesCollection(collection: List[Note], swap: (Note, Note) => Boolean) extends Sortable with
  Iterable[Note] {
  def this(swap: (Note, Note) => Boolean) {
    this(List(), swap)
  }

  def apply(): Unit = {
    sort(collection, swap)
  }

  override def iterator: Iterator[Note] = collection.iterator

}
