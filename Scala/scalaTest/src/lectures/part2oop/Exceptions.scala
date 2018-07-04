package lectures.part2oop

object Exceptions extends App {

  val x: String = null

//  NullPointerException
//  println(x.length)

//  throwing and catching exceptions
//  val aWeirdValue = throw new NullPointerException

  //  throwable classes extend the throwable class
//  exception and error are the major Throwable subtypes

//  2. how to catch exceptions

  def getInt(withException:Boolean):Int =
    if(withException) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try{
//    code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  }finally {
//    code that will get executed NO MATTER
//    optional
//    does not influence the return type of this expression
//    use finally only for the side effect
    println("finally")
  }

  println(potentialFail)

//  3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException


//  val array = Array.ofDim(Int.MaxValue) //OOM
//  SO
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("division by 0")

  object PocketCalc{
    def add(x: Int, y: Int) = {
      val result = x +y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y<0 && result > 0) throw new UnderflowException
      else result
    }
    def subtract(x: Int, y: Int) = {
      val result = x-y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def multiply(x: Int, y:Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    }
    def divide(x: Int, y: Int) = {
      if(y == 0) throw new MathCalculationException
      else x/y
    }
  }

//  println(PocketCalc.add(Int.MaxValue, 10))
    println(PocketCalc.divide(2,0))
}
