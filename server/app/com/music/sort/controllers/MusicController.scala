package com.music.sort.controllers

import com.music.sort.services.Sorter
import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class MusicController @Inject()(cc: ControllerComponents, sorter: Sorter) extends AbstractController(cc) {
  def music = Action {
    Ok(views.html.music(sorter.printCollection(), sorter.printNotes()))
  }

}
