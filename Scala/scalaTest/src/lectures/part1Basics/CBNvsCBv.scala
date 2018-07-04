package lectures.part1Basics

object CBNvsCBv extends App {

  def calledByValue(x: Long):Unit = {
    println("by value: " + x)
    println("by value: " + x)

  }

  def calledByName(x: => Long): Unit ={
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infintite(): Int = 1 + infintite()
  def printFirst(x: Int, y: => Int) = println(x)

//  println(infintite(), 34)

  printFirst(34, infintite())
}
