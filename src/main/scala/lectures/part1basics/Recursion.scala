package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }

  println(factorial(10))

  // throws a StackOverflowError
  // println(factorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }

    factorialHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factorialHelper(10, 1)
    = factorialHelper(9, 10 * 1)
    = factorialHelper(8, 9 * 10 * 1)
    = factorialHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factorialHelper(2, 3 * 4 * ... * 10 * 1)
    = factorialHelper(1, 2 * 3 * ... * 10 * 1)
    = 2 * 3 * ... * 10 * 1
   */

  println(anotherFactorial(10))
  println(anotherFactorial(5000))

  // when you need loops, use _tail_ recursion

  /*
    Exercises to practice tail recursion

    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
   */

  def concatenateNTimes(aString: String, n: Int): String = {
    @tailrec
    def concatenateNTimesHelper(aString: String, n: Int, accumulator: String): String = {
      if (n <= 0) accumulator
      else concatenateNTimesHelper(aString, n - 1, aString + accumulator)
    }

    concatenateNTimesHelper(aString, n, "")
  }

  println(concatenateNTimes("hello ", 5))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeRec(n / 2, true)
  }

  println("10 is prime? " + isPrime(10))
  println("37 is prime? " + isPrime(37))

  def aFibonnaciFunction(n: BigInt): BigInt = {
    @tailrec
    def fibonacciRec(n: BigInt, prev: BigInt, curr: BigInt): BigInt = {
      if (n <= 1) prev
      else fibonacciRec(n - 1, curr, prev + curr)
    }

    fibonacciRec(n, 0, 1)
  }

  println("Fibonacci of 10: " + aFibonnaciFunction(10))
  println("Fibonacci of 100: " + aFibonnaciFunction(100))
}
