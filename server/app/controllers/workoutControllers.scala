package controllers

import models.memoryModelFit
import javax.inject._
import play.api.mvc._
import play.api.i18n._
import java.lang.ProcessBuilder.Redirect

@Singleton
class workoutController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
    
    //for a datab ase
    def showWorkout = Action.async { implicit request => 
        val usernameOption = request.session.get("username")
        usernameOption.map {username =>
            model.workout().map(genMessages => Ok(Json.toJson(genMessages)))
        }.getOrElse(Future.successful(Ok(Json.toJson(Seq.empty[String]))))
    }    

    def workoutHistory = Action.async { implicit request =>
        val usernameOption = request.session.get("username")

    }
}
