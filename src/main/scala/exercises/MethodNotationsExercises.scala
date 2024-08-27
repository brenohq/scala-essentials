package exercises

import scala.language.postfixOps

object MethodNotationsExercises extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def apply(): String = s"Hi, my name is ${name} and I like ${favoriteMovie}. My age is ${age}."
    def apply(n: Int): String = s"${name} watched ${favoriteMovie} ${n} times."

    def learns(thing: String): String = s"${name} is learning ${thing}."
    def learnsScala(): String = this learns "Scala"
  }

  val breno = new Person("Breno", "The Lord of the Rings", 29)

  println((breno + "the mountain biker").apply())

  println((+breno).age)

  println(breno.learnsScala())

  println(breno(5))
}
