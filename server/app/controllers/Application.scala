package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def landing = Action {
    Ok(views.html.landing(SharedMessages.itWorks))
  }

  def login = Action { implicit request =>
    Ok(views.html.login())
  }

}
