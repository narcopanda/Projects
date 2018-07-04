package lectures.part3FunctionalPrograming

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections

import scala.util.Random

object Sequences extends App {

//  Seq
  val aseq = Seq(1,3, 2, 4)
  val aseq2 = Seq('a', 'b', 'c')
  println(aseq)
  println(aseq.reverse)
  println(aseq(2))
  println(aseq ++ Seq(5,7, 6))
  println(aseq.sorted)
  println(aseq ++ aseq2)

//  Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("hello"))

//  list
  val aList = List(1,2,3)
//  append :+
//  prepend +:
  val prepended = 42 +: aList :+ 89
  println(prepended)

  val apples5 = List.fill(5)("apples")
  println(apples5)
  println(aList.mkString("-"))

//  arrays
  val num = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)
  println(threeElements)
  threeElements.foreach(println)

//  mutation
  num(2) = 0 // sysntax sugar for numbers.update(2, 0)
  println(num.mkString(" "))

//  arrays and seq
  val numSeq: Seq[Int] = num //implicit conversion
  println(numSeq)

//  vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

//  vector vs list

  val maxRuns =1000
  val maxCapacity = 1000000
  def getWriteTime(collections: Seq[Int]): Double = {
    val r = new Random
    val times = for{
      it <- 1 to maxRuns
    }yield {
      val currentTime = System.nanoTime()
      collections.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numList = (1 to maxCapacity).toList
  val numVectors = (1 to maxCapacity).toVector

//  keeps reference to tail
//  updating an element in the middle takes long
  println(getWriteTime(numList))

//  depth of the tree is small
//  needs to replace an entire 32-element chunk
  println(getWriteTime(numVectors))

}
