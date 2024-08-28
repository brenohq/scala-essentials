package exercises

abstract class MyGenericList[+A] {

  /*
  head = first element of the list
  tail = remainder of the list
  isGenericEmpty = is the list empty
  add(int) = new list with this element added
  toString = a string representation of the list
   */

  def head: A
  def tail: MyGenericList[A]
  def isGenericEmpty: Boolean
  def add[B >: A](element: B): MyGenericList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object GenericEmpty extends MyGenericList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException()
  override def tail: MyGenericList[Nothing] = throw new NoSuchElementException()
  override def isGenericEmpty: Boolean = true
  override def add[B >: Nothing](x: B): MyGenericList[B] = new GenericCons(x, GenericEmpty)
  override def printElements: String = ""
}

class GenericCons[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {
  override def head: A = h
  override def tail: MyGenericList[A] = t
  override def isGenericEmpty: Boolean = false
  override def add[B >: A](x: B): MyGenericList[B] = new GenericCons(x, this)
  def printElements: String =
    if (t.isGenericEmpty) "" + h
    else s"$h ${t.printElements}"
}

object GenericListTest extends App {
  val listOfIntegers: MyGenericList[Int] = new GenericCons(1, new GenericCons(2, new GenericCons(3, GenericEmpty)))
  val listOfStrings: MyGenericList[String] = new GenericCons("abc", new GenericCons("def", GenericEmpty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
