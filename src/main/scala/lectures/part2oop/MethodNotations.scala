package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person (val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"${this.name} plus ${person.name}"

    def unary_! : String = s"${this.name}, wtf!?"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is ${} and I like ${favoriteMovie}."
  }

  val breno = new Person("Breno", "Her")
  println(breno.likes("Her")) // default calling
  println(breno likes "Her") // infix notation - operator notation (syntax sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(breno hangoutWith tom)
  println(breno + tom)
  println(breno.+(tom))

  println(1 + 2)
  println(1.+(2))

  // prefix notation
  println(-1)
  println(1.unary_-) // only works with - + ~ and !
  println(!breno)
  println(breno.unary_!)

  // postfix notation
  println(breno.isAlive)
  println(breno isAlive)

  // apply
  println(breno.apply())
  println(breno())
}
