package lectures.part2oop

object Objects extends App {
  // Scala does not have "static" class level functionality
  object Person {
    // class-level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bob")
  }

  class Person(val name: String = "Default Person Name") {
    // instance level functionality
  }

  // Object Person and Class Person are COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects = singleton instances
  val breno = Person
  val henrique = Person
  println(breno == henrique)

  val ana = new Person
  val luiza = new Person
  println(ana == luiza)

  val bob = Person(new Person("Breno"), new Person("Ana"))
  println(bob.name)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}
