package lectures.part3FunctionalPrograming

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

//  unsafe APIs
  def unsafeMethod(): String = null
//  val result = Some(null) //wrong
  val result = Option(unsafeMethod()) //Some or None
  println(result)

//  chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

//  design
  def betterUnsafenethod(): Option[String] = None
  def betterBackUpMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafenethod() orElse betterBackUpMethod()

//  functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // unsafe - Don't do

//  map, flatmap, filter
  println(myFirstOption.map(_ *2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  //for-comprehensions

  val config: Map[String, String] = Map{
    "host" -> "176.45.36.1"
    "port" -> "80"
  }

  class Connection{
    def connect = "Connected"
  }
  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if(random.nextBoolean()) Some(new Connection)
      else None
  }

  val host = config.get("host")
  val port = config.get("port")
  /*
    if(h != null)
      if(p != null)
        return Connection.apply(h,p)
     return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h,p)))

  /*
    if(c !- null)
      return c.connect
     return null
   */
  val connectionStatus = connection.map(x => x.connect)
  println(connectionStatus)
  connectionStatus.foreach(println)

  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
     .foreach(println)

}
