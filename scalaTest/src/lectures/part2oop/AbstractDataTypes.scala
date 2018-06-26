package lectures.part2oop

object AbstractDataTypes extends App{

  abstract class Animal{
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "k9"

    override def eat: Unit = println("woof")
  }

//  traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    override def eat: Unit = println("nomnom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog= new Dog
  val croc = new Crocodile
  croc.eat(dog)


//  traits vs abstract classes
//  1 - traits do not have constructor params
//  2 - multiple traits may be inherited bt the same class
//  3 - traits = behaviors, abstract class = "thing"
}
