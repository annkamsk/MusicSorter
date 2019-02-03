package com.music.sort

import com.music.sort.shared.Scales
import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLSelectElement, MouseEvent}

object SelectScales {
  var chosen: Int = 0

  def init(): Unit = {
    val select = dom.document.getElementById("scales")
    for (scale <- Scales.scales) {
      val option = dom.document.createElement("option")
      option.setAttribute("value", scale.name)
      option.innerHTML = scale.name
      select.appendChild(option)
    }
    select.addEventListener("change", (e: MouseEvent) => this.onChange(), useCapture = false)
  }

  def onChange(): Unit = {
    chosen = dom.document.getElementById("scales").asInstanceOf[HTMLSelectElement].selectedIndex
  }

}
