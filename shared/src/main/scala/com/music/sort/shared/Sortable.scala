package com.music.sort.shared

trait Sortable extends Selectable {
  val name = "Default"

  def sort(collection: List[Note], swap: (Note, Note) => Boolean): Unit = {
    // default sort
  }

  override def getName: String = name
}

object Sortable {

  case object BUBBLE_SORT extends BubbleSort

  case object SELECTION_SORT extends SelectionSort

  val algorithms: Seq[Sortable] = Seq(BUBBLE_SORT, SELECTION_SORT)
}

