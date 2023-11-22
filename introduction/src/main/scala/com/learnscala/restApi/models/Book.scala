package com.learnscala.restApi.models

case class Book(id: Int, title: String, author: String, publishedAt: String)
object Book{
  implicit def bookRW: upickle.default.ReadWriter[Book] = upickle.default.macroRW[Book]
}
