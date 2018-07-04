package lectures.part3FunctionalPrograming

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

//  map
  println(list.map(_ + 1)) // adds one to every number
  println(list.map(_ + " is a number"))

//  filter
  println(list.filter(_ %2 == 0))

//  flatmap
  val toPair = (x: Int) => List(x, x+1) //turns a element into a list of elements
  println(list.flatMap(toPair))

//  print all combinations between two lists
  val num = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")
//  List("a1", "a2", ...

//  iterating
  val combo = num.flatMap(n => chars.map(c => "" + c + n))
  println(combo)
  val combo2 = num.flatMap(n => chars.flatMap(c => colors.map(cl => "" + cl + "-" + c + n)))
  println(combo2)

//  foreach
  list.foreach(println)

//  for-comprehensions
  val forCombo = for{
    n <- num if n % 2 == 0 //filter ie num.filter(_ %2 == 0)
    c <- chars
    color <- colors
  }yield "" + c + n + "-" + color
  println(forCombo)

  for {
    n <- num
  }println(n)


  list.map { x =>
    x *2
  }


}
