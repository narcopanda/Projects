import java.util.{ArrayList, StringTokenizer}
import scala.annotation.tailrec

object FunctionalTest extends App {
def rType(array: ArrayList[String]): String = {
    ???
  }
  def test(array: ArrayList[String]): String = {

    val word = stringToken(array)
//    println(word)
    word match {
      case "add" => "hi"//call r type fn
      case _ => "didn't work"
    }
  }
// generate a string token
  def stringToken(array: ArrayList[String]): String = {
    val str: StringTokenizer = new StringTokenizer(array.get(0))
    @tailrec
    def looper(array: ArrayList[String], str: StringTokenizer, word: String): String = {
      if(!str.hasMoreTokens()) word
      else {
        //println(str.nextToken())
        looper(array, str, word = str.nextToken())
      }
    }
    val word: String = str.nextToken()
    array.add(looper(array, str, word))
    word
  }

  def runTest(array: ArrayList[String]): Unit = {
    @tailrec
    def looper(array: util.ArrayList[String]): util.ArrayList[String] = {
      if(array.size() < 1) array
      else {
        test(array)
        println(array.get(0))
        array.remove(0)
        looper(array)
      }
    }
    looper(array)
  }

  val arr: ArrayList[String] = new ArrayList[String]()
  //need to make the index parseable
  arr.add("add R1 R2")
  //println(arr.get(0))

  val test1 = runTest(arr)
  println(test1)
}
