package lectures.part3FunctionalPrograming

object TuplesAndMaps extends App {

  //  tuples = finite orderd "list"
  val aTuple = new Tuple2(2, "hello, Scala") //Tuple2[Int, String] = (Int, String)

  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "good"))
  println(aTuple.swap) // ("hello, Scala", 2)

  //  maps -keys -> values
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), ("Dan", 789), ("JIM", 123)).withDefaultValue(-1)
  println(phoneBook)

  //  map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Mary"))

  //  add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phoneBook + newPairing
  println(newPhonebook)

  //  functionals on maps
  //  map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  //  filter keys
  println(phoneBook.filterKeys(x => x.startsWith("J")))

  //  mapvaluse
  println(phoneBook.mapValues(num => num * 10))

  //  conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Ang", "Dan", "Mary", "Jim")
  println(names.groupBy(name => name.charAt(0)))


  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendA = network(a)
    val friendB = network(b)

    network + (a -> (friendA + b)) + (b -> (friendB + a))
  }

  def unFriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendA = network(a)
    val friendB = network(b)

    network + (a -> (friendA - b)) + (b -> (friendB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unFriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob")empty, "Mary")
  println(network)

}
