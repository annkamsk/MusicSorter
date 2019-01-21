package com.music.sort.shared

object Pitches {

  sealed abstract class PitchClass(
                                    val letter: String,
                                    val midiBase: Int
                                  ) extends Ordered[PitchClass] {
    def compare(that: PitchClass): Int = this.midiBase - that.midiBase

    def getMidi: Int = this.midiBase

    override def toString: String = letter
  }

  case object C extends PitchClass("C", 0)

  case object CSharp extends PitchClass("C#", 1)

  case object D extends PitchClass("D", 2)

  case object DSharp extends PitchClass("D#", 3)

  case object E extends PitchClass("E", 4)

  case object F extends PitchClass("F", 5)

  case object FSharp extends PitchClass("F#", 6)

  case object G extends PitchClass("G", 7)

  case object GSharp extends PitchClass("G#", 8)

  case object A extends PitchClass("A", 9)

  case object ASharp extends PitchClass("A#", 10)

  case object H extends PitchClass("H", 11)

  val pitches: Set[PitchClass] = Set(C, CSharp, D, DSharp, E, F, FSharp, G, GSharp, A, ASharp, H)

}
