package com.music.sort.controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class MusicController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def music = Action {
    Ok(views.html.music("Sort out your music!"))
  }

}
