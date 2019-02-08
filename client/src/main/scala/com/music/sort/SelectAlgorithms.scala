package com.music.sort

import com.music.sort.SelectBases.chosen
import com.music.sort.shared.Sortable
import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLSelectElement, MouseEvent}

object SelectAlgorithms {
  var selected = 0

  def init(): Unit = {
    val select = dom.document.getElementById("algos")
    for (algo <- Sortable.algorithms) {
      val option = dom.document.createElement("option")
      option.setAttribute("value", algo.name)
      option.innerHTML = algo.name
      select.appendChild(option)
    }
    select.addEventListener("change", (e: MouseEvent) => this.onChange(), useCapture = false)
  }

  def onChange(): Unit = {
    chosen = dom.document.getElementById("algos").asInstanceOf[HTMLSelectElement].selectedIndex
  }

}
