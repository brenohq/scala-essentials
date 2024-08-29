package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)

  // 1. throwing and catching exceptions
  // throw new NullPointerException()
  // val aWeirdValue: String = throw new NullPointerException()

  // throwable classes extends Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int!")
    else 42
  }

  try {
    println(getInt(true))
  } catch {
    case e: RuntimeException => println("caught a RuntimeException!")
  } finally {
    println("finally")
  }

  // 3. define your own exceptions
  class MyException extends Exception
  val myException = new MyException()
  // throw myException

  /*
    1. crash your program with OutOfMemoryError
    2. crash your program with StackOverflowError
    3. PocketCalculator
        - add(x, y)
        - subtract(x, y)
        - multiply(x, y)
        - divide(x, y)
        - throws OverflowException if add(x, y) exceeds Int.MAX_VALUE
        - throws OverflowException if subtract(x, y) exceeds Int.MIN_VALUE
        - throws MathCalculationException for division by 0
   */

    def crashWithOutOfMemory(): Unit = {
      val array = Array.ofDim[Int](Int.MaxValue)
    }

    def crashWithStackOverflow(): Int = {
      1 + crashWithStackOverflow()
    }

    class OverFlowException extends RuntimeException
    class UnderFlowException extends RuntimeException
    class MathCalculationException extends RuntimeException

    object PocketCalculator {
      def add(x: Int, y: Int) = {
        val result = x + y

        if (x > 0 && y > 0 && result < 0) throw new OverFlowException
        else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
        else result
      }

      def subtract(x: Int, y: Int) = {
        val result = x - y

        if (x > 0 && y < 0 && result < 0) throw new OverFlowException
        else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
        else result
      }

      def multiply(x: Int, y: Int) = {
        val result = x * y

        if (x > 0 && y > 0 && result < 0) throw new OverFlowException
        else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
        else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
        else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
        else result
      }

      def divide(x: Int, y: Int) = {
        if (y == 0) throw new MathCalculationException()
        else x / y
      }
    }
    
    // crashWithOutOfMemory()
    // crashWithStackOverflow()

    // success cases
    println(PocketCalculator.add(10, 10))
    println(PocketCalculator.subtract(10, 10))
    println(PocketCalculator.multiply(10, 10))
    println(PocketCalculator.divide(10, 10))

    // error cases
    // println(PocketCalculator.add(Int.MaxValue, 1))
    // println(PocketCalculator.subtract(Int.MinValue, 1))
    // println(PocketCalculator.multiply(Int.MaxValue, 2))
    // println(PocketCalculator.divide(10, 0))

}
