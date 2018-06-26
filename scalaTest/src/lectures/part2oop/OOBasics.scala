package lectures.part2oop

object OOBasics extends App{

  val person = new Person("jon", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val writer = new Writer("jon", "smith", 2000)
  println(writer.fullName())
}

class Person(name:String, val age: Int) { //constructor

//  body
  val x =2 //field
  println(1+3)

  def greet(name:String): Unit = println(s"${this.name} says: Hi, $name")

  def greet():Unit = println(s"hi, i am $name")//overloading

  def this(name:String) = this(name, 0)
  def this()= this("John Doe")
}
//class parameters are not fields

class Writer(firstName:String, lastName:String, val year:Int){

  def fullName(): String = firstName + " " + lastName
}

class Novel(name:String, release:Int, author:Writer){

  def authorAge(release:Int):Int = release - author.year
  def isWrittenBy(name:String):String = author.fullName()
  def copy(newYear:Int) = new Novel(name:String, newYear, author:Writer)

}

class Counter(val count:Int){

  def currentCount():Int = count
  def incrementCount():Counter = new Counter(count+1) //immutability
  def decrementCount():Counter = new Counter(count-1)

  def incrementCount(count:Int):Counter = new Counter(count+1)
  def decrementCount(count:Int):Counter = new Counter(count-1)

}


