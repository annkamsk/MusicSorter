package com.music.sort.shared

import com.music.sort.shared.Scales.Scale

class NotesBuilder(base: Pitches.PitchClass, scale: Scale) {
  val SIZE = 24
  val OCTAVE = 3

  def this() = {
    this(Pitches.C, Scales.MAJOR)
  }

  def this(base: Int, scale: Int) = {
    this(Pitches.pitches.apply(base), Scales.scales.apply(scale))
  }

  def getNotes: List[Note] = {
    def dupe[Note](as: Seq[Note]): Stream[Note] = as match {
      case Seq(h, t@_*) => h #:: h #:: dupe(t)
      case _ => Stream.empty
    }

    dupe(Stream.range(1, SIZE))
      .map(p => p % 12 + 1)
      .filter(p => scale.sharps.contains(p))
      .take(SIZE)
      .force
      .map(p => new Note(Pitches.getPitch(p, base), OCTAVE))
      .toList
  }
}
