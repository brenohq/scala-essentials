package lectures.part3fp

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "The number is 1"
    case 2 => "The number is 2"
    case 3 => "The number is 3"
    case _ => "I don't care about other numbers" // wildcard
  }

  println(x)
  println(description)

  // 1. decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(name, age) if age < 21 => s"Hi, my name is $name and I am $age years old. I am a minor."
    case Person(name, age) => s"Hi, my name is $name and I am $age years old. I am an adult."
  }

  println(greeting)

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Labrador")
  animal match {
    case Dog(breed) => println(s"$breed is a dog")
    case Parrot(greeting) => println(s"$greeting is a parrot")
    case _ => println("Unknown animal")
  }

  // match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  /*
    Exercise
    - write a simple function that takes an Expr => human readable string
   */

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => s"(${show(e1)} + ${show(e2)})"
    case Prod(e1, e2) => s"(${show(e1)} * ${show(e2)})"
  }

  println(show(Number(1))) // 1
  println(show(Prod(Number(1), Number(2)))) // (1 * 2)
  println(show(Sum(Number(1), Number(2)))) // (1 + 2)
  println(show(Sum(Number(1), Prod(Number(2), Number(3))))) // (1 + (2 * 3))
  println(show(Prod(Sum(Number(1), Number(2)), Number(3)))) // ((1 + 2) * 3)
}
