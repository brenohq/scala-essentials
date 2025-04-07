package lectures.part3fp

import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {

  // create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Something went wrong"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No String for you!")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialFailure = {
    // code that might throw
  }

  // utilities
  println(potentialFailure.isSuccess) // true

  // orElse
  def backupMethod(): String = "A valid result"
  val fallback = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallback) // Success(A valid result)

  // If you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException("No better String for you!"))
  def betterBackupMethod(): Try[String] = Success("A better valid result")
  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterFallback)

  // map, flatMap, filter
  println(aSuccess.map(_ * 2)) // Success(6)
  println(aSuccess.flatMap(x => Success(x * 10))) // Success(30)
  println(aSuccess.filter(_ > 10)) // Failure(java.lang.RuntimeException: Something went wrong)

  // for comprehensions

  // exercise
  val host = "localhost"
  val port = "8080"
  def renderHtml(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new scala.util.Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new scala.util.Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Connection could not be established")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // if you get the connection successfully, get the page
  val possibleConnection = HttpService.getSafeConnection(host, port)
  val possibleHtml = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHtml.foreach(renderHtml)

  // shorthand version
  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHtml)

  // for comprehension version
  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHtml(html)
}
