package com.learnscala.restApi.routes

import com.learnscala.restApi.store.RepositoryStore

import java.util.Date

case class BookRoutes()(implicit cc: castor.Context, logger: cask.Logger) extends cask.Routes {
  val repositoryStore = RepositoryStore

  @cask.get("/books")
  def books() = {
    val books = repositoryStore.getAllBooks()
    upickle.default.write(books)
  }

  @cask.postJson("/book")
  def createBook(name: String, author: String) = {
    repositoryStore.createBook(name, author, new Date())
    ujson.Obj(
      "message" -> "Book created!"
    )
  }

  @cask.route("/book/:id", methods = Seq("get"))
  def getBook(id: Int) = {
    val book = repositoryStore.getBookById(id)
    upickle.default.write(book)
  }

  @cask.route("/book/:id", methods = Seq("delete"))
  def deleteBook(id: Int) = {
    val book = repositoryStore.removeBook(id)
    ujson.Obj(
      "message" -> "Book removed!"
    )
  }

  initialize()
}
