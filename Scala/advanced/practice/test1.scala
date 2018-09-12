import scala.util.{Try}
object DarkSugars extends App {

 //syntax sugar #1: methods with single param
 def single(arg: Int): String = s"$arg little ducks ..."

 val des = single{
   //write some code
   42
 }

 val aTryInstance = Try{ //java's try {...}
   throw new RuntimeException
 }

 List(1,2,3).map{
   x => x + 1
 }

 //syntax sugar #2: single anstract method
 trait Action{
   def act(x: Int): Int
 }

 val anInstance: Action = (x: Int) => x + 1 //magic

 val aThread = new Thread(new Runnable {
   override def run(): Unit = println("hello, scala")
 })

 val aSweeterThread = new Thread(() => println("sweet scala"))

 abstract class AnAbstractType {
   def implemented: Int = 23
   def f(a: Int): Unit
 }

 val anAbstractInstance: AnAbstractType = (a: Int) => println("sweet")

 // syntax sugar # 3: the :: and #:: methods are special
 
 val prependedList = 2 :: List(3, 4)
 // 2.::(List(3,4))
 // List(3,4).::(2)
 // ?!?!?!?!?
 
 //scala spec: last char decides associativity of method
 1 :: 2 :: 3 :: List(4,5)
 List(4,5).::(3).::(2).::(1) //equivalent
 
 class MyStream[T] {
   def -->:(value: T): MyStream[T] = this //actual implement here
 }

 val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

 // syntax sugar #4: multi-word method naming (not really used)
 
 class TeenGirl(name: String) {
   def `and then said`(gossip: String) = println(s"$name said $gossip")
 }

 val lilly = new TeenGirl("Lilly")
 lilly `and then said` "Scala is so sweet"

 //syntax sugar #5: infix types
 class Composite[A,b] {
   //val composite: Composite[Int, String] = ???
   val composite: Int Composite String = ???
 } 

 class -->[A,B]
 val towards: Int --> String = ???

 //syntax sugar #6: update() is very special, much like apply()
 val anArray = Array(1,2,3)
 anArray(2) = 7 // rewritten to anArray.update(2, 7)
 //used in mutable collections
 //remember apply AND update()
 
 //syntax sugar #7: setters for mutable containers
 class Mutable{
   private var interalMember: Int = 0 //private for OO encapsulation
   def member = interalMember // "getter"
   def member_=(value: Int): Unit = 
     interalMember = value // "setter"
 }

 val aMutableContainer = new Mutable
 aMutableContainer.member = 42 // rewritten as aMutableContainer.member_=(42)

} 
