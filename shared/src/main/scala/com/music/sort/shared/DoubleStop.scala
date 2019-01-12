package com.music.sort.shared

class DoubleStop(val first: Note, val second: Note) {

  def swappedFirst: Note = if (first < second) first else second

  def swappedSecond: Note = if (first < second) second else first

  def isSwap: Boolean = second < first

  override def toString: String = "(" + first.height + ", " + second.height + ")"

}
