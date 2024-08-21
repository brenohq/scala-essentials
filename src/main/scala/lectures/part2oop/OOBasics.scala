package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Breno", 29)

  println(person)

  println(person.name)
  println(person.age)

  println(person.field)

  person.greet("Marco")
}

// class Person(name: String, age: Int)
// class parameters ARE NOT fields

class Person(val name: String, val age: Int) {
  val field = "field"

  println("piece of code evaluated when Person instance is created")

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")
}