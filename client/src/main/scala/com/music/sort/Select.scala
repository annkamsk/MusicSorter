package com.music.sort

import com.music.sort.shared.Selectable
import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLSelectElement, MouseEvent}

class Select(collection: Seq[Selectable], id: String) {
  var chosen: Int = init()

  def init(): Int = {
    val select = dom.document.getElementById(id)
    for (el <- collection) {
      val option = dom.document.createElement("option")
      option.setAttribute("value", el.getName)
      option.innerHTML = el.getName
      select.appendChild(option)
    }
    select.addEventListener("change", (e: MouseEvent) => this.onChange(), useCapture = false)
    0
  }

  def onChange(): Unit = {
    chosen = dom.document.getElementById(id).asInstanceOf[HTMLSelectElement].selectedIndex
  }
}
