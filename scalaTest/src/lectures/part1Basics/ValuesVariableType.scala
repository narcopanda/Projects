package lectures.part1Basics

object ValuesVariableType extends App {

//  vals are immutable
//  they are kind of like const or final
//  don't need a type scala infers
// ie: val x = 42
  val x: Int = 42
  println(x)

//  only need a ; if you are writing multiple things on one line but its bad practice
  val astr: String = "hello"
  val astr2 = "goodbye"

  val bool: Boolean = false
  val aChar: Char = 'a'
  val aInt:Int  = x
  val aShort: Short = 4613

//  need a L to show the compiler that its a long like java
  val aLong: Long = 74813783719713987L
  val aFloat:Float = 2.0f
  val aDouble: Double = 3.14

//  variables
  var a: Int = 4
  a = 5 //this is a side effect


}
