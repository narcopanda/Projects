package lectures.part1Basics

import scala.annotation.tailrec

object Recursion extends App{

  def factorial(n: Int):Int = {
    if(n < 1) 1
    else{
      println("computing factorial of " + n + " - n-1: ")
      val result = n * factorial(n-1)
      println("computed factorial of " + n)
      result

    }

  }
  println(factorial(10))

  def anotherFactorial(n:Int):BigInt = {
    @tailrec //checks to see if the function is tail recursive and if it not then won't compile
    def factHelper(x: Int, accumulator:BigInt):BigInt =
      if(x <= 1) accumulator
      else factHelper(x -1, x * accumulator) //TAIL RECURSION = use recursive call as the LAST expression


    factHelper(n,1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 *1)
  = factHelper(8, 9 * 10 * 1)
  = ...
  = ...
  = factHelper(2, 3 * 4 * ... *10 *1)
  = factHelper(1, 1 *2 * 3 * ... * 10)
  = 1*2*3*4*...*10
   */

  println(anotherFactorial(5000))

//  WHEN YOU NEED LOOPS, USE TAIL RECURSION.
  @tailrec
  def concat(str:String, n:Int, accum:String):String = {
    if(n <= 0)accum
    else concat(str , n-1, str + accum)

  }
  println(concat("hello", 3, ""))


}
