package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 5))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello ", 3))
  // when you need loops, use recursion

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n - 1)
  }

  /*
  1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
  2. A factorial function 1 * 2 * 3 * 4 * ... * n
  3. A fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
  4. A function that tests if a number is prime
   */

  def aGreetingFunction(name: String, age: Int): Unit = {
    println("Hi, my name is " + name + " and I am " + age + " years old.")
  }
  aGreetingFunction("Breno", 29)

  def aFactorialFunction(n: Int): Int = {
    if (n == 1) 1
    else n * aFactorialFunction(n - 1)
  }

  println("Factorial of 5: " + aFactorialFunction(5))

  def aFibonnaciFunction(n: Int): Int = {
    if (n == 1 || n == 2) 1
    else aFibonnaciFunction(n - 1) + aFibonnaciFunction(n - 2)
  }

  println("Fibonacci of 10: " + aFibonnaciFunction(10))

  def isPrime(n: Int): Boolean = {
    def isPrimeRec(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeRec(t - 1)
    }

    isPrimeRec(n / 2)
  }

  println("10 is prime? " + isPrime(10))
  println("37 is prime? " + isPrime(37))
}
