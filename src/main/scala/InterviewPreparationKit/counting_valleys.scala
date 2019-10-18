import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution1 {

  // Complete the countingValleys function below.
  def countingValleys(n: Int, s: String): Int = {
    var before = 0
    var present = 0
    val res = s.foldLeft(0) {(re, c) =>
      before = present
      if (c == 'U') present = before + 1 else present = before - 1
      if (present == 0 && before == -1) re + 1 else re
    }
    res
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter("output.txt")

    val n = stdin.readLine.trim.toInt

    val s = stdin.readLine

    val result = countingValleys(n, s)

    printWriter.println(result)

    printWriter.close()
  }
}
