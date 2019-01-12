package com.music.sort.services

import com.music.sort.models.BubbleSort
import com.music.sort.shared.{DoubleStop, Note}
import javax.inject.Singleton

@Singleton
class Sorter {
  private val notes = {
    List(new Note(43), new Note(11), new Note(10), new Note(12), new Note(5), new Note(3))
  }
  private val bubbleSort = new BubbleSort(notes)

  def printCollection(): Map[Int, List[DoubleStop]] = bubbleSort.f

  def printNotes(): List[Note] = notes

}
