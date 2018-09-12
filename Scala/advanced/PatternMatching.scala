object AdvancedPatternMatching extends App{

  val nums = List(1)
  val des = nums match{
    case head :: Nil => println(s"the only element is $head.")
    case _ => 
  }

  /* 
    -constants
    - wildcards
    - tuples
    - some special magic
  */
 
 class Person(val name: String, val age: Int) 
   
   // need to make a object inorder to have a custom pattern matching
   object Person{
     def unapply(person: Person): Option[(String, Int)] = 
       if (person.age < 21) None
       else Some((person.name, person.age))

     def unapply(age: Int): Option[String] = 
       Some(if(age < 21) "minor" else "major")
   }

   
   val bob = new Person("Bob", 25)
   val greeting = bob match {
     case Person(n, a) => s"Hi, my name is $n and I am $a years old"
   }   

   println(greeting)

   val legalStatus = bob.age match {
     case Person(status) => s"My legal status is $status"
   } 

   println(legalStatus)


   object even{
     def unapply(arg: Int): Boolean = arg % 2 == 0
   }

   object odd{
     def unapply(arg: Int): Boolean = arg % 2 != 0
   }

   object singleDigit{
     def unapply(arg: Int): Boolean = arg > -10 && arg < 10
   }

   val n : Int = 45
   val test = n match {
     case singleDigit() => "single"
     case even() => "even num"
     case odd() => "odd num"
     case _ => "no property"
   }

   println(test)

   // infix patterns
   case class Or[A, B](a:A, b: B) // either
   val either = Or(2, "two")
   val humanDes = either match {
     //case Or(num, string) => s"$num is written as $string"
     case num Or string => s"$num is written as $string"
     case _ => "nothing"
   }

   println(humanDes)

   //decomposing sequences
   //val vararg = num match {
   //  case List(1, _*) => "starting with 1" 
   //}
   
   abstract class MyList[+A] {
     def head: A = ???
     def tail: MyList[A] = ???
   }
   case object Empty extends MyList[Nothing]
   case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

   object MyList{
     def unapplySeq[A](list: MyList[A]): Option[Seq[A]] = 
       if(list == Empty) Some(Seq.empty)
       else unapplySeq(list.tail).map(list.head +: _)
   }

   val myList: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
   val decomposed = myList match {
     case MyList(1, 2, _*) => "Starting with 1, 2"
     case _ => "Nothing"
   }

   println(decomposed)

   // custom return types for unapply
   // isEmpty: Boolean, get: something
   
   abstract class Wrapper[T] {
     def isEmpty: Boolean
     def get: T 
   }

   object PersonWrapper{
     def unapply(person: Person): Wrapper[String] = new Wrapper[String]{
       def isEmpty = false
       def get = person.name
     }
   }

   println(bob match {
     case PersonWrapper(n) => s"This person name is $n" 
     case _ => "Nothing"
   })
}
