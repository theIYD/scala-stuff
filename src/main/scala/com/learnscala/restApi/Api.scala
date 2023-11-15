package com.learnscala.restApi

object Api extends cask.MainRoutes {
  @cask.get("/")
  def hello() = {
    "Hello World!"
  }

  @cask.get("/names")
  def getNames() = {
    "ABC, DEF"
  }

  @cask.post("/demo-post")
  def doThing(request: cask.Request) = {
    request.text().reverse
  }

  initialize()
}
