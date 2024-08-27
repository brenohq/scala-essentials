package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    // you can use override keyword or not
    override val creatureType: String = "canine"
    def eat(): Unit = println("crunch crunch")
  }

  // traits

  trait ColdBlooded

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "reptile"

    override def eat(): Unit = println("nom nom nom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat()
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behaviors, abstract classes = things
}
