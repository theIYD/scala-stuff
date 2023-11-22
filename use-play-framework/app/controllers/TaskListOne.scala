package controllers

import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class TaskListOne @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def taskList: Action[AnyContent] = Action {
    Ok("This is a task list")
  }
}
