package com.music.sort.shared

class Note(val height: Int) {
  def <(note: Note): Boolean = height < note.height

  def equals(obj: Note): Boolean = height.equals(obj.height)

}
