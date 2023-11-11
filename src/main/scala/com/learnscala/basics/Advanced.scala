package com.learnscala.basics

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced extends App {
  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy") // if you run the app here, nothing will be printed
    43
  }

  // useful in infinite collections
  val eagerValue = lazyValueWithSideEffect + 1 // print will run, and 43 will be returned.

  // "pseudo-collections": Option, Try
  def methodWhichCanReturnNull(): String = "hello, Scala"
  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(value) => s"I have obtained a valid string: $value"
    case None => "I obtained nothing"
  }

  def methodWhichCanThrowException(): String = throw new RuntimeException
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(value) => s"I have obtained a valid string: $value"
    case Failure(ex) => s"I have obtained an exception $ex"
  }

  /**
   * Evaluate something on another thread
   * (asynchronous programming)
   * */
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  }

  // future is a "collection" which contains a value when it's evaluated
  // future is composable with map, flatMap and filter

  /**
   * Implicits basics
   * */
  // #1: implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 43
  print(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // #2: implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // compiler does new MyRichInteger(23).isEven()
  // use this carefully as it is dangerous.
}
