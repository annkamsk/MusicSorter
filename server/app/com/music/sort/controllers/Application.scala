package com.music.sort.controllers

import javax.inject._

import com.music.sort.shared.SharedMessages
import play.api.mvc._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  //  def index = Action {
  //    Ok(views.html.index(SharedMessages.itWorks))
  //  }

}
