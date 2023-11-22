package com.learnscala.restApi.store

import com.learnscala.restApi.models.Book

import java.util.Date

object RepositoryStore {
  var books = Seq(
    Book(1,"ABC", "DEF", new Date().toString)
  )

  def getAllBooks() = {
    books
  }

  def getBookById(bookId: Int) = {
    books.find { book =>
      book.id == bookId
    }
  }

  def createBook(name: String, author: String, publishedAt: Date) = {
    val lastBookId = books.last.id
    val id = lastBookId + 1
    val book = new Book(id, s"New Book - $id", "DEF", new Date().toString)
    books = books :+ book
  }

  def removeBook(bookId: Int) = {
    books = books.filter { book =>
      book.id != bookId
    }
  }
}
