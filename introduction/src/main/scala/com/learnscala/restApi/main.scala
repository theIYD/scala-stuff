package com.learnscala.restApi

import com.learnscala.restApi.routes.{BookRoutes, Routes}

object main extends cask.Main {
  val allRoutes = Seq(Routes(), BookRoutes())
}
