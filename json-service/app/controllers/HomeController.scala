package controllers

import models.User
import play.api.libs.json._

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def index: Action[AnyContent] = Action {
    Ok(views.html.index())
  }

  def users: Action[AnyContent] = Action {
    val users = List(User())
    Ok(Json.toJson(users)).as("application/json")
  }

  def user(userId: String): Action[AnyContent] = Action {
    Ok(Json.obj("userId" -> userId))
  }

  def add: Action[AnyContent] = Action { implicit request =>
    Ok(Json.obj("body" -> Json.toJson(request.body.asJson)))
  }
}
