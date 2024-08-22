package lectures.part2oop

object OOBasicsExercises extends App {
  val writer = new Writer("Breno", "Freitas", 1994)
  println(writer.fullName())

  val novel = new Novel("Dois Filhos de Francisco", 2000, writer)
  println(novel.authorAge())
  println(novel.isWrittenBy(writer))

  val novelCopy = novel.copy(2010)
  println(novelCopy.authorAge())
  println(novelCopy.isWrittenBy(writer))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

class Writer(val firstName: String, val surname: String, val year: Int) {
  def fullName(): String = {
    this.firstName + " " + this.surname
  }
}

class Novel(val name: String, val yearOfRelease: Int, val author: Writer) {
  def authorAge(): Int = {
    this.yearOfRelease - author.year
  }

  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(year: Int): Novel = {
    new Novel(this.name, year, this.author)
  }
}

class Counter(val counter: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(counter + 1) // immutability
  }

  def dec = {
    println("decrementing")
    new Counter(counter - 1) // immutability
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(counter)
}
