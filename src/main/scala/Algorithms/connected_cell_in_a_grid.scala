import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

  // Complete the connectedCell function below.
  def connectedCell(matrix: Array[Array[Int]]) = {


  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val m = stdin.readLine.trim.toInt

    val matrix = Array.ofDim[Int](n, m)

    for (i <- 0 until n) {
      matrix(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = connectedCell(matrix)

    printWriter.println(result)

    printWriter.close()
  }
}
