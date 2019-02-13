package com.music.sort.shared

import com.music.sort.shared.Scales.Scale

import scala.util.Random

class NotesBuilder(base: Pitches.PitchClass, scale: Scale) {
  val SIZE = 24
  val MIN_SCALE = 3
  val r: Random.type = scala.util.Random
  val OCTAVE = 3

  def this() = {
    this(Pitches.C, Scales.MAJOR)
  }

  def this(base: Int, scale: Int) = {
    this(Pitches.pitches(base), Scales.scales(scale))
  }


  def getNotes: List[Note] = {
    def dupe[Note](as: Seq[Note]): Stream[Note] = as match {
      case Seq(h, t@_*) => h #:: h #:: dupe(t)
      case _ => Stream.empty
    }

    def customEquals(curr: Note, unique: Note): Boolean =
      if (curr.pitch.midiBase == unique.pitch.midiBase && curr.octave == unique.octave) true else false


    dupe(Stream.range(1, SIZE))
      .map(p => p % 12 + 1)
      .filter(p => scale.sharps.contains(p))
      .take(SIZE)
      .force
      .map(p => new Note(Pitches.getPitch(p, base), r.nextInt(MIN_SCALE) + 3))
      .foldRight(Seq[Note]()) {
        (curr, unique) => {
          if (!unique.exists(customEquals(curr, _)))
            curr +: unique
          else
            unique
        }
      }.toList
  }
}
