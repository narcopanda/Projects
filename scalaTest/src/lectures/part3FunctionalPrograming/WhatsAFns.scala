package lectures.part3FunctionalPrograming

object WhatsAFns extends App {

//  use fns as first class elements

val doubler = new MyFunction[Int, Int] {
  override def apply(element: Int): Int = element * 2
}
  println(doubler(2))
//  fns tpes = function1[a,b]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }
  println(stringToIntConverter("3")+ 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

//  Function types Function2[A,B] == (A,B) => R

//  All scala fns are object

  val stringCon: (String, String) => String = new Function2[String, String, String] {
    override def apply(str: String, str2: String): String = str + str2
  }

  println(stringCon("a", "pple"))
}

trait MyFunction[A, B]{
  def apply(element: A): B
}