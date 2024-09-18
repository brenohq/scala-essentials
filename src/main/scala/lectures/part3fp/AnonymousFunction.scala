package lectures.part3fp

object AnonymousFunction extends App {

  // anon function / lambda
  val doubler: Int => Int = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  // careful
  println(justDoSomething)    // function instance
  println(justDoSomething())  // function call

  // curly braces with lambda
  val stringToInt = {
    (str: String) => str.toInt
  }

  println(stringToInt("3"))

  // More syntactic sugar
  val niceIncrementer: Int => Int = _ + 1   // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _  // equivalent to (a, b) => a + b

  println(niceIncrementer(10))
  println(niceAdder(10, 20))

}
