package lectures.part2oop

object MethodNotations extends App{

  class Person(val name:String, favoriteMovie: String){
    def likes(movie:String):Boolean = movie == favoriteMovie
//    def hangOutWith(person: Person):String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person):String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck"
    def isAlive:Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"



  }

  val mary = new Person("Mary", "Godfather")
  println(mary.likes("Godfather"))
  println(mary likes "Godfather") // they are the same thing
//  infix notation = operator notation (syntactic sugar)
//  works with only one param

//  "operators" in scala
  val tom = new Person("Tom", "Fight Clud")
  println(mary + tom)
  println(mary.+(tom))


  println(1 + 2)
  println(1.+(2))

//  ALL OPERATORS ARE METHODS ie ! ?

//  prefix notation
  val x = -1//equivalent with unary_-
  val y = 1.unary_-

  println(!mary)
  println(mary.unary_!)//same as !mary

//  postfix notation only works with fns with no params
  println(mary.isAlive)
  println(mary isAlive)

//  apply
  println(mary.apply())
  println(mary())//equivalent


  def +(str:String): Person = new Person("mary", "the rockstar")




}
