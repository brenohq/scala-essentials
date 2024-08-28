package lectures.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // class parameters are fields
  val jim = Person("Jim", 21)
  println(jim.age)

  // sensible .toString
  println(jim.toString)

  // equals and hashCode implemented out of the box
  val anotherJim = Person("Jim", 21)
  println(jim == anotherJim)

  // hand copy method
  println(jim.copy(name = "Copied Jim"))

  // companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)
  println(mary)

  // are serializable
  // Akka
}
