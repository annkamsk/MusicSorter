package com.music.sort.models

import com.music.sort.shared.DoubleStop

trait Sorting {
  def list: NotesCollection

  def f: Map[Int, List[DoubleStop]] = collectCompars()

  def collectCompars(): Map[Int, List[DoubleStop]]

  def sort(list: NotesCollection = this.list, swaps: List[DoubleStop] = f(0), time: Int = 0): Unit = {
    print(list)
    swaps match {
      case h :: rest => sort(new NotesCollection(list.swap(h)), rest, time)
      case Nil => f(time + 1) match {
        case h :: rest => sort(new NotesCollection(list.swap(h)), rest, time + 1)
        case Nil =>
      }
    }
  }
}
