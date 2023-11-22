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

  def user(userId: String): Action[AnyContent] = TODO

  def add: Action[AnyContent] = TODO
}
