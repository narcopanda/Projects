package lectures.part4PatternMatching

object AdvancedPatternMatching extends App{
  val nums = List(1)
  val des = nums match{
    case head :: Nil => println(s"the only element is $head.")
    case _ =>
  }
  println("hi")
  /*
    -constants
    - wildcards
    - tuples
    - some special magic
  */

  class Person(val name: String, val age: Int)
    println("hi2")
    object Person{
      def unapply(person: Person): Option[(String, Int)] = Some((person.name, person.age))
    }

    val bob = new Person("Bob", 25)
    val greeting = bob match {
      case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    }

    println(greeting)

}
