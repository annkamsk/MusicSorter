package com.music.sort.shared

trait SelectionSort extends Sortable {
  override val name = "Selection sort"

  override def getName: String = name

  override def sort(list: List[Note], compare: (Note, Note) => Boolean): Unit = {
    def minimum(xs: List[Note]): List[Note] =
      (List(xs.head) /: xs.tail) {
        (ys, x) =>
          if (compare(x, ys.head)) x :: ys
          else ys.head :: x :: ys.tail
      }

    def selectionSort(xs: List[Note]): List[Note] =
      if (xs.isEmpty) List()
      else {
        val min = minimum(xs)
        min match {
          case x :: null => min
          case default => min.head :: selectionSort(min.tail)
        }
      }

    selectionSort(list)
  }

}
