package lectures.part1Basics

object Expressions extends App {

  val x = 1+2 //expression
  println(x)

  println(2 + 3 * 4)

  println(1 == x)
  println(!(1==x))
//  ! && ||

  var aVar = 2
  aVar +=3

  val acond = true
  val aCond = if(acond) 5 else 3 //if expression nor if instruction
  println(aCond)

  var i = 0
  while (i < 10){
    println(i)
    i +=1
  }
//  NEVER WRITE THIS AGAIN

//  EVERYTHING in scala is an Expression

  val aWeirdValue = (aVar = 3) //Unit == void
  println(aWeirdValue)

//  side effects: println(), while, reassigning

//  Code blocks

  val aCodeBlock= {
    val y = 2
    val z = y + 1

    if(z>2) "hello" else "goodbye"
  }
//  value of the whole block is the value of the last expression

//  1. what is the difference between "hello world" vs println("hello world")?

//  2.
        val someValue = {
          2 < 3
        }

        val someOtherValue = {
          if(someValue) 239 else 986
          42
        }
}
