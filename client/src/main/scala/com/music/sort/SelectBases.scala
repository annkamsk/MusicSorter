package com.music.sort

import com.music.sort.shared.Pitches.PitchClass
import com.music.sort.shared.{Pitches, Scales}
import org.scalajs.dom

object SelectBases {
  val chosen: PitchClass = null

  def init(): Unit = {
    val select = dom.document.getElementById("bases")
    for (base <- Pitches.pitches) {
      val option = dom.document.createElement("option")
      option.setAttribute("value", base.letter)
      option.innerHTML = base.letter
      select.appendChild(option)
    }
  }

  def onSelect(): Unit = {

  }
}
