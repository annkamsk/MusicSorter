package com.music.sort

import com.music.sort.SelectBases.chosen
import com.music.sort.shared.Pitches
import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLSelectElement, MouseEvent}

object SelectAlgorithms {
  var selected = 0

  def init(): Unit = {
    // TODO
    //    val select = dom.document.getElementById("algo")
    //    for (algo <- Algorithms.algo) {
    //      val option = dom.document.createElement("option")
    //      option.setAttribute("value", algo.name)
    //      option.innerHTML = algo.name
    //      select.appendChild(option)
    //    }
    //    select.addEventListener("change", (e: MouseEvent) => this.onChange(), useCapture = false)
  }

  def onChange(): Unit = {
    chosen = dom.document.getElementById("algo").asInstanceOf[HTMLSelectElement].selectedIndex
  }

}
