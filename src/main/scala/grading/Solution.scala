package grading

object Solution {
  def round(x: Int): Int = {
    if ((x % 5) >= 3 && x>37) (x/5 + 1) * 5
    else x
  }
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    val grades = Array.ofDim[Int](n)
    for (gradesItr <- 0 until n) {
      val gradesItem = stdin.readLine.trim.toInt
      grades(gradesItr) = gradesItem
    }
    grades.foreach(x => println(round(x)))
  }
}
