package com.music.sort.shared

import scala.concurrent.Future

trait Sortable {
  val name = "Default"

  def sort(collection: Array[Note], swap: (Note, Note) => Unit): Unit = {
    // default sort
  }
}

object Sortable {

  case object BUBBLE_SORT extends BubbleSort

  val algorithms: Seq[Sortable] = Seq(BUBBLE_SORT)
}

