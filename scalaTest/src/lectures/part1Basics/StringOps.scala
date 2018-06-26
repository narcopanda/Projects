package lectures.part1Basics

object StringOps extends App {

  val str:String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val aNumeber = aNumberString.toInt
  println('a' +:aNumberString :+ 'z' )
  println(str.reverse)
  println(str.take(2))


//  Scala-specific: String interpolators
  val name = "David"
  val age = 12
  val greeting = s"hello, my name is $name and I am ${age + 1} years old"

  println(greeting)

//  F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f"
  println(myth)

//  raw-interpolators
  println(raw"this is a \n newline")
  val esc = "this is a \n newline"
  println(raw"$esc")

}
