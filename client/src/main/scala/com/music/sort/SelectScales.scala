package com.music.sort

import com.music.sort.shared.Scales
import com.music.sort.shared.Scales.Scale
import org.scalajs.dom

import scala.scalajs.js

object SelectScales extends js.type {
  val chosen: Scale = null

  def init(): Unit = {
    val select = dom.document.getElementById("scales")
    for (scale <- Scales.scales) {
      val option = dom.document.createElement("option")
      option.setAttribute("value", scale.name)
      option.innerHTML = scale.name
      select.appendChild(option)
    }
  }

  def onSelect(): Unit = {

  }

}
