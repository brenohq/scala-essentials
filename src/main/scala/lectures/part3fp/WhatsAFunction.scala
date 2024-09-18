package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // PROBLEM: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  println(adder(4, 5))

  // Function types Function2[A, B, R] === (A, B) => R

  // All Scala Functions are Objects

  /*
      1. a function which takes 2 strings and concatenates them
      2. transform the MyPredicate and MyTransformer into function types
      3. define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
  */

  // 1
  val concatenator: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concatenator("Hello, ", "Scala!"))

  // 3 - HOC
  val megaFunction: Int => Int => Int = (x: Int) => (y: Int) => x * y

  val multiplierBy3 = megaFunction(3)
  val multiplierBy5 = megaFunction(5)

  println(multiplierBy3(4))
  println(multiplierBy5(4))

  println(megaFunction(10)(10)) // curried function

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
