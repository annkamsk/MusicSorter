package com.music.sort.shared

trait Sortable {
  val name = "Default"

  def sort(collection: List[Note], swap: (Note, Note) => Unit): Unit = {
    // default sort
  }
}

object Sortable {

  case object BUBBLE_SORT extends BubbleSort

  val algorithms: Seq[Sortable] = Seq(BUBBLE_SORT)
}

