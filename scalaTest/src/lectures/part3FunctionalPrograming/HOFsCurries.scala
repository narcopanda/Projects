package lectures.part3FunctionalPrograming

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
//  higher order fns(HOF)

//  map, flatMap, filter in MyList

//  fns that applies a fns n times over valuex
//  nTimes(f,n,x)
//  nTimes(f, 3, x) = f(f(f(x)))

  def nTimes(f: Int => Int, n: Int, x:Int): Int =
    if(n <= 0) x
    else nTimes(f, n-1, f(x))


  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1)) //call plusOne on the value 1 10 times

  //ntb(f,n) = n => f(f(f...(x)))
//  increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
//  val y = increment10(1)
  def nTimesBetter(f:Int => Int, n: Int): (Int => Int) =
  if(n <= 0) (x: Int) => x
  else (x :Int) => nTimesBetter(f, n-1)(f(x))


  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(2))

//  curried fns\

//  this fns receives a int and returns another fns
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

//  fns with multiple param lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val perciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(perciseFormat(Math.PI))

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x,y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) =>Int =
    (x, y) => f(x)(y)

//  FunctionX
  def compose[A, B, T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen[A, B, C](f: A => B, g: B => C): A => C =
    x => g(f(x))
}
