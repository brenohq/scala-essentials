package lectures.part3fp

import scala.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(unsafeMethod()) // crash with NPE
  val result = Option(unsafeMethod()) // Some or None
  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult) // Some(A valid result)

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainedResult) // Some(A valid result)

  // functions on Options
  println(myFirstOption.isEmpty) // false
  println(noOption.isEmpty)      // true
  println(myFirstOption.get)     // UNSAFE - Do not use this

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2)) // Some(8)
  println(myFirstOption.filter(_ > 10)) // None
  println(myFirstOption.flatMap(x => Some(x * 10))) // Some(40)

  // for comprehensions

  /*
      Exercise
   */
  val config: Map[String, String] = Map(
    "host" -> "localhost",
    "port" -> "8080"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  // try to establish a connection, if so - print the connection method
  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)
  connectionStatus.foreach(println) // Connected or None

  // chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
        .map(connection => connection.connect))
    .foreach(println)

  // for-comprehensions
  val forConnectionStatus = for {
    h <- config.get("host")
    p <- config.get("port")
    c <- Connection(h, p)
  } yield c.connect

  println(forConnectionStatus) // Some(Connected) or None
}
