package com.music.sort.shared

class Note(val pitch: Pitches.PitchClass, octave: Int) {
  lazy val midi: Int = pitch.getMidi + (octave + 1) * 12

  //  no, it doesn't make any sense to construct such fancy ids but to show off my scala skills
  lazy val id: String = (midi.toString.map(_.asDigit) collect Note.ID_MAPPER).mkString("")

  def <(that: Note): Boolean = this.octave < that.octave || (this.octave == that.octave && this.pitch < that.pitch)

  override def toString: String = pitch.toString + octave

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
