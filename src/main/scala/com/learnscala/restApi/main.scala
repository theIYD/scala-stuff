package com.learnscala.restApi

import com.learnscala.restApi.routes.Routes

object main extends cask.Main {
  val allRoutes = Seq(Routes())
}
