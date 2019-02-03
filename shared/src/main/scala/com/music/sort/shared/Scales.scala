package com.music.sort.shared

object Scales {

  // note: I'm considering only equally tempered scales (meaning 12 intervals per octave)
  sealed abstract class Scale(
                               val sharps: Array[Int],
                               val name: String) extends Ordered[Scale] {

    override def toString: String = name

    override def compare(that: Scale): Int = this.sharps.length - that.sharps.length
  }

  case object BLUES extends Scale(Array(1, 3, 4, 5, 8), "Blues")

  // yes, I'm well aware that in music notation C# does not equal Db
  case object DOUBLE_HARMONIC extends Scale(Array(1, 2, 5, 6, 8, 9, 10), "Double harmonic major")

  case object GYPSY extends Scale(Array(1, 3, 4, 7, 8, 9, 10), "Gypsy")

  case object MAJOR extends Scale(Array(1, 3, 5, 6, 9, 10, 12), "Major")

  val scales: Seq[Scale] = Seq(BLUES, DOUBLE_HARMONIC, GYPSY, MAJOR)
}
