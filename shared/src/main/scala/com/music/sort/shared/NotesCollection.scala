package com.music.sort.shared

class NotesCollection(array: Array[Note]) {

  def this() {
    this(new Array[Note](0))
  }

  def add(note: Note) = new NotesCollection(Array.concat(array, Array(note)))


}
