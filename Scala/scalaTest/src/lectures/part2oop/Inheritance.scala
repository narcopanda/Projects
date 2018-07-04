package lectures.part2oop

object Inheritance extends App{

  sealed class Animal{
    val creatureType = "wild"
     def eat = println("eat")
  }
  class Cat extends Animal{

    def crunch = {
      eat
      println("crunch")
    }
  }
  val cat = new Cat
  cat.crunch

//  constructors
  class Person(name: String, age: Int){ def  this(name:String) = this(name,0)}
  class Adult(name:String, age:Int, idCard: String) extends Person(name)

//  overriding
  class Dog(override val creatureType: String = "safe") extends Animal{
//  override val creatureType: String = "safe"
    override def eat: Unit = {
      super.eat
      println("munch munch")
    }
  }


  val dog = new Dog("k9")
  dog.eat
  println(dog.creatureType)

//  type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("k9")
  unknownAnimal.eat

//  overRIDDING vs overLOADING

//  super

//  preventing overrides
//  1 - use final on member
//  2- use final on the entire class
//  3 - seal the class = extends in this file only


}
