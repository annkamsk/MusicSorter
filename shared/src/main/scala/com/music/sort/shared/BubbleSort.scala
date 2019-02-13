package com.music.sort.shared


trait BubbleSort extends Sortable {
  override val name = "Bubble Sort"

  override def sort(list: List[Note], compare: (Note, Note) => Boolean): Unit = {
    def bubbleSort(source: List[Note], result: List[Note]): List[Note] = {
      if (source.isEmpty) {
        result
      } else {
        bubble(source, Nil, result)
      }
    }

    def bubble(source: List[Note], tmp: List[Note], result: List[Note])
    : List[Note] =
      source match {
        case n1 :: n2 :: t =>
          if (compare(n1, n2)) {
            bubble(n2 :: t, tmp ::: List(n1), result)
          }
          else {
            bubble(n1 :: t, tmp ::: List(n2), result)
          }
        case n1 :: t => bubbleSort(tmp, n1 :: result)
      }

    bubbleSort(list, Nil)
  }


}
