package com.learnscala.basics

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // Invoking bob as a function === bob.apply(43)

  /*
  * Scala runs on JVM.
  * In functional programming:
  * - compose functions
  * - pass functions as args
  * - return functions as results
  *
  * Conclusion: FunctionX = Function1, Function2, .... Function22
  * */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // function with 2 arguments and a String return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("i love", " Scala") // "i love Scala"

  // syntax sugars
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  doubler(4)

  // another syntax sugar
  val tripler: Int => Int = (x: Int) => 3 * x
  tripler(4)

  // another level:  syntax sugar. This is almost same as arrow functions in javascript.
  val quadruple = (x: Int) => 4 * x
  quadruple(4)

  // higher-order functions: functions as args / returns functions as results OR both
  val aMappedList = List(1,2,3).map(x => x + 1)
  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x))
  // alternative syntax
  val anAlternativeWayOfDefiningFuncAsArgs = List(1,2,3).flatMap {
    x => List(x, 3 * x)
  }
  val aFilteredList = List(1,2,3,4,5).filter { x => x <= 3 }
  // more shorter syntax
  val aFilteredListShort = List(1,2,3,4,5).filter { _ <= 3 }

  // all pairs between the numbers 1,2,3 and the letters 'a', 'b', 'c'
  val allPairs = List(1,2,3).flatMap { number => List('a', 'b', 'c').map { letter => s"$number-$letter"} }
  println(allPairs)

  // for comprehensions - in large code bases, reading chains of maps/flatMap can be difficult, hence use this
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // this is equivalent to the map/flatMap chain above

  /**
   * Collections
   * */

  // lists
  val aList = List(1,2,3)
  val firstElement = aList.head
  val restOfTheElements = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3)
  val anAppendedList = aList :+ 4 // List(1,2,3,4)

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3
  val accessedElement = aSequence(1) // the element at index 1: 2

  // vectors: fast Seq implementation
  val aVector = Vector(1,2,3,4,5)

  // sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3)
  val setHas5 = aSet.contains(5) // false
  val insertInSet = aSet + 5 // Set(1,2,3,4,5)
  val removeFromSet = aSet - 5

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map { 2 * _ }.toList // List(2,4,6,8 ... 2000)

  // tuples = groups of values under the same value
  val aTuple = ("Bon", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map(
    "Jane" -> 23
  )
}
