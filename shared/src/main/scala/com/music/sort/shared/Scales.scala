package com.music.sort.shared

object Scales {

  // note: I'm considering only equally tempered scales (meaning 12 intervals per octave)
  sealed abstract class Scale(
                               val sharps: Array[Pitches.PitchClass],
                               val name: String,
                               val length: Int) extends Ordered[Scale] {

    override def toString: String = name

    override def compare(that: Scale): Int = this.length - that.length
  }

  case object BLUES extends Scale(Array(Pitches.C, Pitches.D, Pitches.DSharp, Pitches.E, Pitches.G), "Blues", 5)

  // yes, I'm well aware that in music notation C# does not equal Db
  case object DOUBLE_HARMONIC extends Scale(Array(Pitches.C, Pitches.CSharp, Pitches.E, Pitches.F, Pitches.G, Pitches
    .GSharp, Pitches.A), "Double harmonic major", 7)

  case object GYPSY extends Scale(Array(Pitches.C, Pitches.D, Pitches.DSharp, Pitches.FSharp, Pitches.G, Pitches
    .GSharp, Pitches.ASharp), "Gypsy", 7)

  case object MAJOR extends Scale(Array(Pitches.C, Pitches.D, Pitches.E, Pitches.F, Pitches.GSharp, Pitches.A, Pitches.H),
    "Major", 7)


  val scales: Set[Scale] = Set(BLUES, DOUBLE_HARMONIC, GYPSY, MAJOR)
}
