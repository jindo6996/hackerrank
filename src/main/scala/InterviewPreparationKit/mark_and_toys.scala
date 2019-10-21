package InterviewPreparationKit

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object mark_and_toys {
  // Complete the maximumToys function below.
  def maximumToys(prices: Array[Int], k: Int): Int = {
    val pricesSorted = prices.sorted
    var sum = 0
    var i = 0
    while (sum + pricesSorted(i) < k) {
      sum += pricesSorted(i)
      i += 1
    }
    i
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter("output.txt")

    val nk = stdin.readLine.split(" ")
    println(nk)
    val n = nk(0).trim.toInt
    println(n)
    val k = nk(1).trim.toInt

    val prices = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = maximumToys(prices, k)

    printWriter.println(result)

    printWriter.close()
  }
}
