package lectures.part2oop

object Generics extends App {

  class MyList[+A]{
    //  use the type A
    def add[B >: A](element: B): MyList[A] = ???

  }

  class  MyMap[Key, Value]
  trait  MyMap1[Key, Value]

  val listOfInts = new MyList[Int]
  val listOfStrings = new MyList[String]

//  generic methods
  object MyList{
   def empty[A]:MyList[A] = ???
  }
  val emptyListOfInts = MyList.empty[Int]


//  variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

// 1-yes list of[Cat] extends List[Animal] = covariance

  class CovariantList[+A]

  val animal:Animal = new Cat
  val animalList:CovariantList[Animal] = new CovariantList[Cat]

//  animalList.add(new Dog)???

//  2-No = Invariance
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

//  3- HELL, no! Contravariance
  class ContravariantList[-A]
  val covariantList:ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer:Trainer[Cat] = new Trainer[Animal]

//  bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

//  class Car
//  val newCage = new Cage(new Car) //this wont work



}

