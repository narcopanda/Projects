package exercises

abstract class MyList[+A] {

  def head:A
  def tail:MyList[A]
  def isEmpty():Boolean
  def add[B >:A](num:B):MyList[B]

  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](myTransformer: MyTransformer[A,B]): MyList[B]
  def filter(myPredicate: MyPredicate[A]): MyList[A]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  def ++[B >: A](list: MyList[B]):MyList[B]//concatenation

}

trait MyPredicate[-T]{
  def condition(testCond: T):Boolean
}

trait MyTransformer[-A,B]{
  def transform(origin:A):B
}

object Empty extends MyList{
  override def head: Nothing = throw new NoSuchElementException

  override def tail: Nothing = throw new NoSuchElementException

  override def isEmpty(): Boolean = true

  override def add[B >:Nothing](num:B):MyList[B] = new Cons(num, Empty)

  override  def printElements: String = ""

  override def map[B](myTransformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty

  override def filter(myPredicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](h:A, t:MyList[A]) extends MyList[A] {
  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >:A](num:B):MyList[B] = new Cons(num, this)

   def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
    [1,2,3].filter(n % 2 == 0) =
      [2,3].filter(n % 2 == 0) =
       = new Cons(2, [3].filter(n % 2 == 0))
       = new Cons(2, Empty.filter(n % 2 == 0))
       = new Cons(2, Empty
   */
  override def filter(myPredicate: MyPredicate[A]): MyList[A] =
    if(myPredicate.condition(h)) new Cons(h, t.filter(myPredicate))
    else t.filter(myPredicate)

  /*
    [1,2,3].map(n*2)
      = new Cons(2, [2,3].map(n*2))
      = new Cons(2, new Cons(4, [3].map(n *2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n*2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty))))
   */
  override def map[B](myTransformer: MyTransformer[A, B]): MyList[B] =
    new Cons(myTransformer.transform(h), t.map(myTransformer))


  /*
      [1,2].flatMap(m => [n,n+1]
       = [1,2] ++ [2].flatMap(n => [n , n+1]
       = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1]
       = [1,2] ++ [2,3] ++ Empty
       = [1,2,2,3]
   */
  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  /*
    [1,2] ++ [3,4,5]
    = new Cons(1, [2] ++ [3,4,5])
    = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))

   */
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}

object ListTest extends App{
  val listOfInts:MyList[Int] = new Cons(1,new Cons(2,new Cons(3, Empty)))
  val anotherListOfInts:MyList[Int] = new Cons(1,new Cons(4,new Cons(5, Empty)))
  val listOfStrings: MyList[String] = new Cons[String]("Hello", new Cons[String]("Scala", Empty))
  println(listOfInts.toString)
  println(listOfStrings.toString)

  println(listOfInts.map(new MyTransformer[Int, Int] {
    override def transform(origin: Int): Int = origin * 2
  }).toString)

  println(listOfInts.filter(new MyPredicate[Int] {
    override def condition(testCond: Int): Boolean = testCond % 2 ==0
  }).toString)

  println((listOfInts ++ anotherListOfInts).toString)
  println(listOfInts.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(origin: Int): MyList[Int] = new Cons (origin, new Cons(origin + 1, Empty))
  }).toString)
}

