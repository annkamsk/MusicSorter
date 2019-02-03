package com.music.sort

import com.music.sort.shared.Pitches
import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLSelectElement, MouseEvent}

object SelectBases {
  var chosen: Int = 0

  def init(): Unit = {
    val select = dom.document.getElementById("bases")
    for (base <- Pitches.pitches) {
      val option = dom.document.createElement("option")
      option.setAttribute("value", base.letter)
      option.innerHTML = base.letter
      select.appendChild(option)
    }
    select.addEventListener("change", (e: MouseEvent) => this.onChange(), useCapture = false)
  }

  def onChange(): Unit = {
    chosen = dom.document.getElementById("bases").asInstanceOf[HTMLSelectElement].selectedIndex
  }
}
