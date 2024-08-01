package lectures.part1basics

object ValuesVariablesTypes extends App {

  // vals are immutable
  val x: Int = 42
  println(x)

  // Scala's compiler can infer types
  val y = 100
  println(100)

  val aString: String = "hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'

  val anInt: Int = x
  val aShort: Short = 4232
  val aLong: Long = 32131231212312L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // vars are mutable
  var aVariable: Int = 4
  aVariable = 5

}
