package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>>

  println(1 == x)
  // == !=  > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF Expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  // EVERYTHING in Scala is an expression!

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // the value of a code block is the result of his last expression
  println(aCodeBlock)
}
