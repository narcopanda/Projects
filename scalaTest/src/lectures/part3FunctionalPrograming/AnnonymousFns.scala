package lectures.part3FunctionalPrograming

object AnnonymousFns extends App {

  val doubler = (x: Int) => x*2 //anonymous fns (LAMBDA)

//  multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

//  no params
  val justDoIt = () => 3

  println(justDoIt) //function itself
  println(justDoIt()) //call

//  curly braces with lambdas
  val stringToInt = {str: String =>
    str.toInt
  }

//  more syntactic sugar
  val niceIncrementer: Int => Int = _ +1 // equivalent to x => x +1

  val niceAdder: (Int, Int) => Int = _ + _ // equvalent to (a,b) => a + b

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))

}
