package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[Key, Value]

  val listOfIntegers = MyList[Int]
  val listOfStrings = MyList[String]

  // generics methods
  object MyList {
    def empty[A]: MyList[A] = MyList[A]
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ???

  // invariant list
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // contravariant list
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  // throws error
  // class Car
  // val newCage = new Cage(new Car)
}
