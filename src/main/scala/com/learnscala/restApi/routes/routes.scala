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

  initialize()
}
