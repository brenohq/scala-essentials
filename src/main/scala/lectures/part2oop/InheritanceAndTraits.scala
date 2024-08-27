package lectures.part2oop

object InheritanceAndTraits extends App {

  class Animal {
    val creatureType = "wild"
    def walk() = println("walking")
    protected def eat() = println("eating")
    private def drink() = println("drinking")
  }

  class Cat extends Animal {
    def crunch() = {
      this.eat()
      println("crunch crunch")
    }
  }

  val cat = new Cat()
  cat.walk()
  cat.crunch()
  // cat.drink()

  // constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat(): Unit = super.eat()
  }

  val dog = new Dog()
  dog.eat()
  println(dog.creatureType)

  // type substitution - aka polymorphism
  val unkownAnimal: Animal = new Dog()
  unkownAnimal.walk()

  // overRIDING vs overLOADING

  // super.<method_from_father_class>

  // preventing overrides
  //   - keyword "final" on member or class definition itself
  //   - keyword "sealed" to prevent extensions on different files
}
