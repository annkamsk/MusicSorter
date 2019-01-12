package com.music.sort.models

import com.music.sort.shared.{DoubleStop, Note}

class BubbleSort(notes: List[Note]) extends Sorting {

  override def collectCompars(): Map[Int, List[DoubleStop]] = {
    def bubbleSort(source: List[Note], result: List[Note], f: Map[Int, List[DoubleStop]], time: Int = 0): Map[Int,
      List[DoubleStop]] = {
      if (source.isEmpty) {
        f
      } else {
        bubble(source, Nil, result, f, time)
      }
    }

    def bubble(source: List[Note], tmp: List[Note], result: List[Note], f: Map[Int, List[DoubleStop]], time: Int)
    : Map[Int, List[DoubleStop]] =
      source match {
        case n1 :: n2 :: t =>
          if (n1 < n2) {
            bubble(n2 :: t, tmp ::: List(n1), result, f + (time -> List(new DoubleStop(n1, n2))), time + 1)
          }
          else {
            bubble(n1 :: t, tmp ::: List(n2), result, f + (time -> List(new DoubleStop(n1, n2))), time + 1)
          }
        case n1 :: t => bubbleSort(tmp, n1 :: result, f, time)
      }

    bubbleSort(this.notes, Nil, Map[Int, List[DoubleStop]]())
  }

  override def list: NotesCollection = new NotesCollection(this.notes)
}
