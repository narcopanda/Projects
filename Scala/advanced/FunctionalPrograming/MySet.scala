import scala.annotation.tailrec

trait MySet[A] extends (A => Boolean) {
  
  def apply(elem: A): Boolean = contains(elem)

  def contains(elem: A): Boolean

  def +(elem: A): MySet[A]
  def ++(anotherSet: MySet[A]): MySet[A]
  
  def map[B](f: A => B): MySet[B]
  def flatMap[B](f: A => MySet[B]): MySet[B]
  def filter(predicate: A => Boolean): MySet[A]
  def foreach(f: A => Unit): Unit

  def -(elem: A): MySet[A]
  def intersection(anotherSet: MySet[A]): MySet[A]
  def difference(anotherSet: MySet[A]): MySet[A]
  def unary_! : MySet[A]

}

class EmptySet[A] extends MySet[A]{

  def contains(elem: A): Boolean = false

  def +(elem: A): MySet[A] = new NonEmptySet[A](elem, this)
  def ++(anotherSet: MySet[A]): MySet[A] = anotherSet
  
  def map[B](f: A => B): MySet[B] = new EmptySet[B]
  def flatMap[B](f: A => MySet[B]): MySet[B] = new EmptySet[B]
  def filter(predicate: A => Boolean): MySet[A] = this
  def foreach(f: A => Unit): Unit = ()

  def -(elem: A): MySet[A] = this
  def intersection(anotherSet: MySet[A]): MySet[A] = this
  def difference(anotherSet: MySet[A]): MySet[A] = this

  def unary_! : MySet[A] = new PropertyBasedSet[A](_ => true)

}

//class AllInclusiveSet[A] extends MySet[A]{
//
//  override def contains(elem: A): Boolean = true
//  
//  override def +(elem: A): MySet[A] = this
//
//  override def ++(anotherSet: MySet[A]): MySet[A] = this
//
//  override def map[B](f: A => B): MySet[B] = 
//
//  override def flatMap[B](f: A => MySet[B]): MySet[B] =
//
//  override def filter(predicate: A => Boolean): MySet[A] =
//
//  override def foreach(f: A => Unit): Unit =
//
//  override def -(elem: A): MySet[A] =
//
//  override def difference(anotherSet: MySet[A]): MySet[A] =
//
//  override def intersection(anotherSet: MySet[A]): MySet[A] =
//
//  override def unary_! : MySet[A] =
//  
//}

// all elements of type which satisfy a property
class PropertyBasedSet[A](property: A => Boolean) extends MySet[A]{

  def contains(elem: A): Boolean = property(elem)

  def +(elem: A): MySet[A] = new PropertyBasedSet[A](x => property(x) || x == elem)

  def ++(anotherSet: MySet[A]): MySet[A] = new PropertyBasedSet[A](x => property(x) || anotherSet(x))
  
  def map[B](f: A => B): MySet[B] = failed
  def flatMap[B](f: A => MySet[B]): MySet[B] = failed
  def foreach(f: A => Unit): Unit = failed

  def filter(predicate: A => Boolean): MySet[A] = new PropertyBasedSet[A](x => property(x) && predicate(x))

  def -(elem: A): MySet[A] = filter(x => x != elem)
  def intersection(anotherSet: MySet[A]): MySet[A] = filter(anotherSet)
  def difference(anotherSet: MySet[A]): MySet[A] = filter(!anotherSet)
  def unary_! : MySet[A] = new PropertyBasedSet[A](x => !property(x))

  def failed = throw new IllegalArgumentException("Went down the rabbit hole!!!")

}

class NonEmptySet[A](head: A, tail: MySet[A]) extends MySet[A]{

  def contains(elem: A): Boolean = 
    elem == head || tail.contains(elem)

  def +(elem: A): MySet[A] = 
    if(this contains elem) this
    else new NonEmptySet[A](elem, this)

  // [1,2,3] ++ [4,5] =
  // [2,3] ++ [4,5] + 1 =
  // [3] ++ [4,5] + 1 + 2 =
  // [] ++ [4,5] + 1 + 2 + 3
  // [4,5] + 1 + 2 + 3 = [4,5,1,2,3]
  
  def ++(anotherSet: MySet[A]): MySet[A] = 
    tail ++ anotherSet + head
  
  def map[B](f: A => B): MySet[B] = ( tail map f ) + f(head)
  def flatMap[B](f: A => MySet[B]): MySet[B] = (tail flatMap f) ++ f(head)
  def filter(predicate: A => Boolean): MySet[A] = {
    val filterTail = tail filter predicate
    if (predicate(head)) filterTail + head
    else filterTail
  }

  def foreach(f: A => Unit): Unit = {
    f(head)
    tail foreach f
  }

  def -(elem: A): MySet[A] = 
    if (head == elem) tail
    else tail - elem + head

  def intersection(anotherSet: MySet[A]): MySet[A] = filter(anotherSet) // intersection and filter are the same thing!!!!!
  def difference(anotherSet: MySet[A]): MySet[A] = filter(x => !anotherSet.contains(x))

  def unary_! : MySet[A] = new PropertyBasedSet[A](x => !this.contains(x))

  }

object MySet{

  // val s = MySet(1,2,3) = buildSet(seq(1,2,3), [])
  // = buildSet(seq(2,3), [] + 1)
  // = buildSet(seq(3), [1], + 2) 
  // = buildSet(seq(), [1,2] + 3) 
  // = [1,2,3] 
  def apply[A](values: A*): MySet[A] = {
    @tailrec
    def buildSet(valSeq: Seq[A], acc: MySet[A]): MySet[A] =
      if(valSeq.isEmpty) acc
      else buildSet(valSeq.tail, acc + valSeq.head)

      buildSet(values.toSeq, new EmptySet[A])
  }
}

object MySetTest extends App{
  val s = MySet(1,2,3,4)
  s + 5 foreach println

  val neg = !s // s.unary_! = all the naturals not equal to 1,2,3,4,
  println(neg(2))
  println(neg(5))

  val negEven = neg.filter(_ % 2 == 0)
  println(negEven(5))

  val negEven5 = negEven + 5 // all the even numbers > 4 + 5
  println(negEven(5))
}
