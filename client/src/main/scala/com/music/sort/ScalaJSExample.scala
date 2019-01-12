package com.music.sort

import com.music.sort.shared.DoubleStop
import org.scalajs.dom

import scala.collection.SortedMap
import scala.scalajs.js

object ScalaJSExample {

  def main(args: Array[String]): Unit = {


  }

  def sort(notes: SortedMap[Int, List[DoubleStop]]): Unit = {
    notes.foreach(entry =>
      entry._2.foreach(ds =>
        if (ds.isSwap) swap(ds.first.height, ds.second.height)))
  }

  def swap(id1: Int, id2: Int): Unit = {
    val el1 = dom.document.getElementById(id1.toString)
    val el2 = dom.document.getElementById(id2.toString)
    val prev1 = el1.previousSibling
    val prev2 = el2.previousSibling
    prev1.appendChild(el2)
    prev2.appendChild(el1)
  }
}
