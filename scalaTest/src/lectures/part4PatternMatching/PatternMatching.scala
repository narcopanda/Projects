package lectures.part4PatternMatching

import scala.util.Random

object PatternMatching extends App {

  val random =new Random
  val x =random.nextInt(10)

  val description = x match {
    case 1 => "one"
    case 2 => "double"
    case 3 => "three"
    case _ => "something else" // _ = wildcard

  }
  println(x)
  println(description)

  //1. decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink"
    case Person(n, a) => s"Hi, my name is $n and I'm $a"
    case _ => "who are you"
  }

  println(greeting)

}

