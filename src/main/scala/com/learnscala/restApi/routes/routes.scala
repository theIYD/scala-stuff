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

  initialize()
}
