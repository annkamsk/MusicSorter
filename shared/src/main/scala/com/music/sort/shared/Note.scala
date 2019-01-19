package com.music.sort.shared

class Note(val height: Int) {
  def <(note: Note): Boolean = height < note.height

  def equals(obj: Note): Boolean = height.equals(obj.height)

  def getId: String = (height.toString.map(_.asDigit) collect Note.ID_MAPPER).mkString("")

}

object Note {
  val ID_MAPPER: Map[Int, String] = Map(
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine",
    0 -> "zero"
  )
}
