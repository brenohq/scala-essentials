package lectures.part1basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  }

  val fact10 = trFact(10)
  val fact15 = trFact(15)

  println(fact10)
  println(fact15)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture...")

  savePicture("jpg", 800, 600)
  savePicture()
  savePicture(height = 600, width = 800, format = "png")
}
