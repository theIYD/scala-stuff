package com.learnscala.restApi.routes

case class Routes()(implicit cc: castor.Context, log: cask.Logger) extends cask.Routes {
  @cask.get("/hello-world")
  def helloWorld() = {
    "Hello World"
  }

  @cask.get("/one-more-route")
  def oneMoreRoute() = {
    "one more route"
  }

  @cask.get("/user/:username")
  def showUserProfile(username: String) = s"The user name is $username"

  @cask.get("/posts/:postId")
  def showPost(postId: String) = s"The post is $postId"

  @cask.get("/request")
  def checkRequest(request: cask.Request) = {
    s"The request params are: ${request.queryParams}"
  }

  @cask.route("/json", methods = Seq("get"))
  def returnJSONObject() = {
    ujson.Obj(
      "name" -> "ABC",
      "type" -> "user",
      "role" -> "admin"
    )
  }

  @cask.postJson("/json")
  def postJSON(name: String, userType: String, roles: Seq[String]) = {
    ujson.Obj(
      "name" -> name,
      "type" -> userType,
      "roles" -> roles
    )
  }

  initialize()
}
