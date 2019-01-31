package com.music.sort.shared

class Note(val pitch: Pitches.PitchClass, val octave: Int) {
  lazy val midi: Int = pitch.getMidi + (octave + 1) * 12

  lazy val id: String = "id" + midi.toString

  def <(that: Note): Boolean = this.octave < that.octave || (this.octave == that.octave && this.pitch < that.pitch)

  override def toString: String = pitch.toString + octave

}

