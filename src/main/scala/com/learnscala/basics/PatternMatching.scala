package com.learnscala.basics

object PatternMatching extends App {

  // switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case _ => anInteger + "th"
  }

  // Pattern Match is an EXPRESSION

  // Case class decomposition
  case class Person(name: String, age: Int) // Person class is a companion object with a .apply method
  val bob = Person("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "Something else"
  }

  // deconstructing tuples
  val aTuple = ("Bon", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know"
  }

  // decomposing lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on it's second position"
    case _ => "unknown list"
  }

  // if PM doesn't match anything, it will throw a MatchError
  // PM will try all cases in "sequence"
}
