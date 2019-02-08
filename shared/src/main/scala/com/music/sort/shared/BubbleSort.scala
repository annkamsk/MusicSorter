package com.music.sort.shared

trait BubbleSort extends Sortable {
  override val name = "Bubble Sort"

  override def sort(list: Array[Note], compare: (Note, Note) => Boolean): Unit = {
    for (i <- 0 until list.length - 1; j <- 0 until list.length - 1 - i) {
      if (compare(list(j + 1), list(j))) {
        val temp = list(j)
        list(j) = list(j + 1)
        list(j + 1) = temp
      }
    }
  }


}
