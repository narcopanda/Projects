package lectures.part2oop

object CaseClasses  extends  App{

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)
//  1. class params are fields
  val jim = new Person("jim", 20)
  println(jim.name)

//  2. sensible toString
//  println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

//  3. equals and hashCode implemented OOTB
  val jim2 = new Person("jim", 20)
  println(jim == jim2)

//  4 CCs(case classes) have handy copy method
  val jim3 = jim.copy()
  val jim4 = jim.copy(age = 45)
  println(jim3)
  println(jim4)

//  5. CCS have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

//  6. CCs are serializable
//  Akka framework

//  7/ CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UK{
    def name:String = "The UK of GB and NI"
  }



}
