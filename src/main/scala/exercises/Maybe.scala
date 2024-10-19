package exercises

abstract class Maybe[+T] {

  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
  def filter(p: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {
  def map[B](f: Nothing => B): Maybe[B] = MaybeNot
  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
  def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {
  def map[B](f: T => B): Maybe[B] = Just(f(value))
  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)
  def filter(p: T => Boolean): Maybe[T] = if (p(value)) this else MaybeNot
}

object Maybe {
  def fromOption[T](option: Option[T]): Maybe[T] = option match {
    case Some(value) => Just(value)
    case None        => MaybeNot
  }
}

object MaybeTest extends App {
  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(_ % 2 == 0))

  val not3 = MaybeNot
  println(not3)
  println(not3.map((x: Int) => x * 2))
  println(not3.flatMap((x: Int) => Just(x % 2 == 0)))
  println(not3.filter((x: Int) => x % 2 == 0))

  val just3Option = Maybe.fromOption(Option(3))
  println(just3Option)
  println(just3Option.map(_ * 2))
  println(just3Option.flatMap(x => Just(x % 2 == 0)))
  println(just3Option.filter(_ % 2 == 0))

  val not3Option = Maybe.fromOption(None)
  println(not3Option)
  println(not3Option.map((x: Int) => x * 2))
  println(not3Option.flatMap((x: Int) => Just(x % 2 == 0)))
  println(not3Option.filter((x: Int) => x % 2 == 0))
}