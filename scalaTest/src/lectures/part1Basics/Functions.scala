package lectures.part1Basics

object Functions extends App{

  def aFunction(a: String, b: Int): String ={

    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n:Int): String = {
    if(n == 1 ) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

// WHEN YOU NEED LOOPS USE RECURSION.

  def aFunctionWithSideEffects(aString: String):Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  /*
  1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
  2. Factorial function 1 *2 *3 *... * n
  3. A Fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n- 1) + f(n -2)
  4. test if a number is prime
   */

  def greeting(name:String, age:Int) = {"Hi, my name is " + name + " and I am " + age + " years old"}
  println(greeting("jon", 10))


  def factorial(num:Int):Int = {
    if(num <= 0)1
    else num* factorial(num - 1)
  }

  def fibonacci(n:Int):Int = {
    if(n <= 1)1
    else fibonacci(n-1) + fibonacci(n-2)
  }

  def isPrime(n:Int): Boolean = {
    if(n % 2 == 0) false
    else true
  }
  println(isPrime(2))


}
