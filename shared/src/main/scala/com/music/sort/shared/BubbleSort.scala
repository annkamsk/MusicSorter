package com.music.sort.shared

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


trait BubbleSort extends Sortable {
  override val name = "Bubble Sort"

  override def sort(list: Array[Note], compare: (Note, Note) => Unit): Unit = {
    for (i <- 0 until list.length - 1; j <- 0 until list.length - 1 - i) {
      if (list(j + 1) < list(j)) {
        val temp = list(j)
        list(j) = list(j + 1)
        list(j + 1) = temp
        compare(list(j + 1), list(j))
      }
    }
  }


}
