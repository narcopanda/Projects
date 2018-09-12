package lectures.part1Basics

import java.util

import scala.annotation.tailrec
import java.util.{ArrayList, StringTokenizer}

object Recursion extends App{

//  def factorial(n: Int):Int = {
//    if(n < 1) 1
//    else{
//      println("computing factorial of " + n + " - n-1: ")
//      val result = n * factorial(n-1)
//      println("computed factorial of " + n)
//      result
//
//    }
//
//  }
//  println(factorial(10))
//
//  def anotherFactorial(n:Int):BigInt = {
//    @tailrec //checks to see if the function is tail recursive and if it not then won't compile
//    def factHelper(x: Int, accumulator:BigInt):BigInt =
//      if(x <= 1) accumulator
//      else factHelper(x -1, x * accumulator) //TAIL RECURSION = use recursive call as the LAST expression
//
//
//    factHelper(n,1)
//  }
//
//  /*
//  anotherFactorial(10) = factHelper(10, 1)
//  = factHelper(9, 10 *1)
//  = factHelper(8, 9 * 10 * 1)
//  = ...
//  = ...
//  = factHelper(2, 3 * 4 * ... *10 *1)
//  = factHelper(1, 1 *2 * 3 * ... * 10)
//  = 1*2*3*4*...*10
//   */
//
//  println(anotherFactorial(5000))
//
////  WHEN YOU NEED LOOPS, USE TAIL RECURSION.
//  @tailrec
//  def concat(str:String, n:Int, accum:String):String = {
//    if(n <= 0)accum
//    else concat(str , n-1, str + accum)
//
//  }
//  println(concat("hello", 3, ""))

  def rType(array: ArrayList[String]): String = {
    ???
  }
  def test(array: ArrayList[String]): String = {

    val word = stringToken(array)
//    println(word)
    word match {
      case "add" => "hi"//call r type fn
      case _ => "didn't work"
    }
  }
// generate a string token 
  def stringToken(array: ArrayList[String]): String = {
    val str: StringTokenizer = new StringTokenizer(array.get(0))
    @tailrec
    def looper(array: ArrayList[String], str: StringTokenizer, word: String): String = {
      if(!str.hasMoreTokens()) word
      else {
        //println(str.nextToken())
        looper(array, str, word = str.nextToken())
      }
    }
    val word: String = str.nextToken()
    array.add(looper(array, str, word))
    word
  }

  def runTest(array: ArrayList[String]): Unit = {
    @tailrec
    def looper(array: util.ArrayList[String]): util.ArrayList[String] = {
      if(array.size() < 1) array
      else {
        test(array)
        println(array.get(0))
        array.remove(0)
        looper(array)
      }
    }
    looper(array)
  }

  val arr: ArrayList[String] = new ArrayList[String]()
  //need to make the index parseable
  arr.add("add R1 R2")
  //println(arr.get(0))

  val test1 = runTest(arr)
  println(test1)
}
