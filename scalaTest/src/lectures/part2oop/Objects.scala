package lectures.part2oop

object Objects {

//  scala does not have class-level functionality ("static")

  object Person{
//    static/class - level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    def apply(mother:Person, father:Person): Person = new Person("Bobbie")
  }

  class Person(val name:String){
//    instance-level functionality
  }

//  companions

  def main(args: Array[String]): Unit = { //same as extends app

  println(Person.N_EYES)
  println(Person.canFly)

  //  scala object = singleton instance
  val mary = new Person("mary")
  val john = new Person("jon")

  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person2 == person1)

  val bobbie = Person(mary, john)//Person.apply(mary, john)

  }

//  scala applications = scala obj /w
//  def main(args: Array[String]):Unit




}
