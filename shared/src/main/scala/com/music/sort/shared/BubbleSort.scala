package com.music.sort.shared

trait BubbleSort extends Sortable {
  override val name = "Bubble Sort"

  override def sort(list: List[Note], swap: (Note, Note) => Unit): Unit = {
    def sort(as: List[Note], bs: List[Note]): List[Note] =
      if (as.isEmpty) bs
      else bubble(as, Nil, bs)

    def bubble(as: List[Note], zs: List[Note], bs: List[Note]): List[Note] = as match {
      case h1 :: h2 :: t =>
        if (h2 < h1) {
          swap(h1, h2)
          bubble(h1 :: t, h2 :: zs, bs)
        }
        else {
          bubble(h2 :: t, h1 :: zs, bs)
        }
      case h1 :: Nil => sort(zs, h1 :: bs)
    }

    sort(list, Nil)
  }


}
