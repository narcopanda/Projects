object PartialFunctions extends App {

  val aFn = (x: Int) => x + 1 //Function1[Int, Int] === Int => Int

  val aFussyFn = (x: Int) =>
    if(x == 1) 42
    else if (x == 5) 999
    else throw new FunctionNotApplicableException

  class FunctionNotApplicableException extends RuntimeException

  val aNicerFussyFn = (x: Int) => x match {
    case 1 => 42
    case 2 => 56
    case 3 => 999
  }

  //{1,2,5} => Int
  
  val aPartialFn: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 56
    case 3 => 999
  } //partial function value

  println(aPartialFn(2))

  //PF utils
  println(aPartialFn.isDefinedAt(67))

  //lift to fn
  val lifted = aPartialFn.lift // Int => Option[Int]
  println(lifted(2))
  println(lifted(98))

  val pfChain = aPartialFn.orElse[Int, Int]{
    case 45 => 67
  }

  println(pfChain(2))
  println(pfChain(45))

  // PF extend normal fns
  
  val aTotalFn: Int => Int = {
    case 1 => 99
  }

  // HOFs accept partial fn as well
  val aMappedList = List(1,2,3).map{
    case 1 => 42
    case 2 => 78
    case 3 => 1000
  }

  println(aMappedList)

  /* 
    Note: PF can only have ONE parameter type 
   */

  val aManualFussyFn = new PartialFunction[Int, Int]{
    override def apply(x: Int): Int = x match {
      case 1 => 42
      case 2 => 65
      case 5 => 999
    }

    override def isDefinedAt(x: Int): Boolean = 
      x == 1 || x == 2 || x == 5

  }

  val chatBot: PartialFunction[String, String] = {
    case "hello" => "Hi, my name is HAL9000"
    case "goodbye" => "fuck off" 
    case "call mom" => "no"
    case _ => "can't understand"
  }

//  scala.io.Source.stdin.getLines().foreach(line => println("chatBot says: " + chatBot(line)))
  scala.io.Source.stdin.getLines().map(chatBot).foreach(println)
}
