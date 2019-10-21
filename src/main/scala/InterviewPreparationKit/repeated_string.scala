package InterviewPreparationKit

import java.io._


object repeated_string {
  // Complete the repeatedString function below.
  def repeatedString(s: String, n: Long): Long = {
    val countA = s.count(_ == 'a')
    val lengS = s.length
    val nDivS = n / lengS
    val _count_a = countA * nDivS
    val lengthOfSCountYet = (n - nDivS*lengS).toInt
    s.slice(0, lengthOfSCountYet).count(_ == 'a') + _count_a
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter("output.txt")

    val s = stdin.readLine

    val n = stdin.readLine.trim.toLong

    val result = repeatedString(s, n)

    printWriter.println(result)

    printWriter.close()
  }
}
